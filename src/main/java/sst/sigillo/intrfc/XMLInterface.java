package sst.sigillo.intrfc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import lombok.Getter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sst.sigillo.main.SigilloConstants;
import sst.sigillo.model.Bookmark;
import sst.sigillo.model.SigilloData;
import sst.sigillo.model.SigilloModel;
import sst.sigillo.xsd.ObjectFactory;
import sst.sigillo.xsd.Sigillo;
import sst.sigillo.xsd.Sigillo.Bookmarks;
import sst.sigillo.xsd.Sigillo.Preferences;

public class XMLInterface implements FileInterface {

    private static Logger logger = LoggerFactory.getLogger(XMLInterface.class);

    @Getter
    private static FileInterface theOne = null;

    static {
	theOne = new XMLInterface();
    }

    private XMLInterface() {

    }

    public void load() throws FileNotFoundException {
	load(SigilloConstants.DATA_SIGILLO_XML);
    }

    public void load(String filename) throws FileNotFoundException {
	logger.info("Loading XML file " + filename + "...");

	SigilloModel model = SigilloModel.getInstance();
	model.setData(new SigilloData());
	
	ArrayList<Bookmark> bookmarksList = new ArrayList<>();
	JAXBContext jc;

	try {
	    jc = JAXBContext.newInstance("sst.sigillo.xsd");
	    Unmarshaller unmarshaller = jc.createUnmarshaller();
	    Sigillo sigillo = (Sigillo) unmarshaller.unmarshal(new File(filename));
	    // unmarshaller.setValidating(true);
	    for (sst.sigillo.xsd.Sigillo.Bookmarks.Bookmark xmlBookmark : sigillo.getBookmarks().getBookmark()) {
		Bookmark javaBookmark = new Bookmark();
		javaBookmark.setUrl(xmlBookmark.getUrl());
		javaBookmark.setName(xmlBookmark.getName());
		javaBookmark.setCategory(SigilloModel.getInstance().getCategoryByName(xmlBookmark.getCategory()));

		bookmarksList.add(javaBookmark);
	    }
	    model.setBookmarksList(bookmarksList);
	    model.getData().setHeaderColor(sigillo.getPreferences().getHeaderColor());
	    model.getData().setBookmarkColor(sigillo.getPreferences().getBookmarkColor());
	} catch (JAXBException e) {
	    logger.error("Cannot access to XML file " + filename, e);
	    System.exit(-1);
	}

	logger.info("" + bookmarksList.size() + " bookmarks loaded.");
    }

    public void save() {
	save(SigilloConstants.DATA_SIGILLO_XML);
    }

    public void save(String filename) {

	logger.info("Saving XML file " + filename + "...");

	SigilloModel model = SigilloModel.getInstance();

	Collection<Bookmark> sortedList = model.getOrderedBookmarkList();

	ObjectFactory objFact = new ObjectFactory();
	Sigillo sigillo = objFact.createSigillo();
	Bookmarks l = objFact.createSigilloBookmarks();
	for (Bookmark javaBookmark : sortedList) {
	    sst.sigillo.xsd.Sigillo.Bookmarks.Bookmark xmlBookmark = objFact.createSigilloBookmarksBookmark();
	    xmlBookmark.setUrl(javaBookmark.getUrl());
	    xmlBookmark.setName(javaBookmark.getName());
	    xmlBookmark.setCategory(javaBookmark.getCategory().getName());

	    l.getBookmark().add(xmlBookmark);
	}
	sigillo.setBookmarks(l);
	Preferences prefs = objFact.createSigilloPreferences();
	prefs.setHeaderColor(model.getData().getHeaderColor());
	prefs.setBookmarkColor(model.getData().getBookmarkColor());
	sigillo.setPreferences(prefs);
	JAXBContext jc;
	try {
	    jc = JAXBContext.newInstance("sst.sigillo.xsd");
	    Marshaller marshaller = jc.createMarshaller();
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, new Boolean(true));
	    // marshaller.marshal(l, System.out);
	    marshaller.marshal(sigillo, new File(filename));
	} catch (JAXBException e) {
	    logger.error("Cannot access to XML file " + filename, e);
	    System.exit(-1);
	}

    }
}
