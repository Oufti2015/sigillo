package sst.sigillo.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.enterprise.inject.Default;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sst.common.file.output.OutputFile;
import sst.common.file.replaceFile.ReplaceFile;
import sst.common.html.AbstractHTMLElement;
import sst.common.html.HTML;
import sst.common.html.HTMLDiv;
import sst.common.html.HTMLHyperlinks;
import sst.common.html.HTMLListItem;
import sst.common.html.HTMLThemeBreak;
import sst.common.html.HTMLUnorderedList;
import sst.sigillo.model.Bookmark;
import sst.sigillo.model.SigilloModel;

@Default
public class MenuHTMLExportFile implements Export {
    private static Logger logger = LoggerFactory.getLogger(MenuHTMLExportFile.class);

    @Override
    public void export2HTML(File file) throws IOException {
	createCSS();

	logger.info("Exporting to HTML file " + file.getName() + "...");

	HTML html = new HTML();
	html.head().title("Oufti Bookmarks").styleSheet("menu.css").styleSheet("sigillo.css").javaScript("sigillo.js");
	// html.body().footer("Sigillo - St&eacute;phane STIENNON - " + new
	// Date()).addChild(createBookmarksTable(SigilloModel.getInstance().getOrderedBookmarkList()));
	html.body().footer("Sigillo - St&eacute;phane STIENNON - " + new Date())
		.addChild(createBookmarksMenu(SigilloModel.getInstance().getOrderedBookmarkList()));
	try (OutputFile output = new OutputFile(file)) {
	    output.println(html.toString());
	}
	logger.info("Export done. ");
    }

    private void createCSS() throws FileNotFoundException, IOException {
	logger.info("Creating CSS Sheet...");
	ReplaceFile replace = new ReplaceFile();
	replace.add("<%COLOR_HEADER%>", SigilloModel.getInstance().getData().getHeaderColor());
	replace.add("<%COLOR_CONTENT%>", SigilloModel.getInstance().getData().getBookmarkColor());
	replace.run("data/sigillo.template.css", "sigillo.css");
	logger.info("Creation of CSS Sheet done");
    }

    private HTMLUnorderedList newLine(HTMLDiv div) {
	div.addChild(new HTMLThemeBreak());
	HTMLUnorderedList ul = new HTMLUnorderedList();
	ul.id("menu");
	div.addChild(ul);
	return ul;
    }

    private HTMLListItem newColumn(HTMLUnorderedList ul, String categoryName) {
	HTMLListItem li = new HTMLListItem();
	li.classId("bleu");
	li.addChild(new HTMLHyperlinks().href("#").textContent(categoryName));
	ul.addChild(li);
	return li;
    }

    private AbstractHTMLElement createBookmarksMenu(Collection<Bookmark> list) {

	HTMLDiv div = new HTMLDiv();
	HTMLUnorderedList mainUl = newLine(div);

	HTMLListItem liBleu = null;
	HTMLUnorderedList ul = null;
	HTMLListItem li = null;

	String currentCategory = null;
	int i = 0;

	for (Bookmark bm : list) {
	    if (null == currentCategory || !currentCategory.equals(bm.getCategoryName())) {

		if (7 == i) {
		    mainUl = newLine(div);
		    i = 0;
		}

		liBleu = newColumn(mainUl, bm.getCategoryName());
		ul = new HTMLUnorderedList();
		li = new HTMLListItem();
		ul.addChild(li);
		liBleu.addChild(ul);

		currentCategory = bm.getCategory().getName();
		i++;
	    }
	    li.addChild(new HTMLHyperlinks().href(bm.getUrl()).target("_blank").textContent(bm.getName()));
	}

	return div;
    }
}
