package sst.sigillo.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.enterprise.inject.Alternative;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sst.common.file.output.OutputFile;
import sst.common.file.replaceFile.ReplaceFile;
import sst.common.html.AbstractHTMLElement;
import sst.common.html.HTML;
import sst.common.html.HTMLHyperlinks;
import sst.common.html.table.HTMLTable;
import sst.common.html.table.HTMLTableCell;
import sst.common.html.table.HTMLTableRow;
import sst.sigillo.model.Bookmark;
import sst.sigillo.model.Category;
import sst.sigillo.model.SigilloModel;

@Alternative
public class TableHTMLExportFile implements Export {
    private static Logger logger = LoggerFactory.getLogger(TableHTMLExportFile.class);

    @Override
    public void export2HTML(File file) throws IOException {
	createCSS();

	logger.info("Exporting to HTML file " + file.getName() + "...");

	HTML html = new HTML();
	html.head().title("Oufti Bookmarks").styleSheet("menu.css").styleSheet("sigillo.css").javaScript("sigillo.js");
	// html.body().footer("Sigillo - St&eacute;phane STIENNON - " + new
	// Date()).addChild(createBookmarksTable(SigilloModel.getInstance().getOrderedBookmarkList()));
	html.body().footer("Sigillo - St&eacute;phane STIENNON - " + new Date())
		.addChild(createBookmarksTable(SigilloModel.getInstance().getOrderedBookmarkList()));
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

    private AbstractHTMLElement createBookmarksTable(Collection<Bookmark> list) {

	HTMLTable table = new HTMLTable();
	HTMLTableRow row = table.newRow();
	HTMLTableCell cell = null;
	HTMLTable catTable = null;

	String currentCategory = null;
	int i = 0;

	for (Bookmark bm : list) {
	    if (null == currentCategory || !currentCategory.equals(bm.getCategoryName())) {
		if (null != catTable) {
		    cell.addChild(catTable);
		    // row.addTableCell(cell);
		}

		if (7 == i) {
		    row = table.newRow();
		    i = 0;
		}

		cell = row.newCell();
		cell.classId("category");
		catTable = new HTMLTable();
		setCategory(catTable, bm.getCategory());

		currentCategory = bm.getCategory().getName();
		i++;
	    }
	    HTMLTableRow catRow = catTable.newRow();
	    HTMLTableCell catCell = catRow.newCell();
	    catCell.addChild(new HTMLHyperlinks().href(bm.getUrl()).target("_blank").textContent(bm.getName()));
	    catCell.classId("bookmark");
	}
	if (null != catTable) {
	    cell.addChild(catTable);
	}

	return table;
    }

    private void setCategory(HTMLTable catTable, Category category) {
	catTable.newRow().newHead().textContent(category.getName());
    }
}
