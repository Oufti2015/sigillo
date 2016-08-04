package sst.sigillo.output;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("ExportEngine")
public class ExportEngine {
    private static Logger logger = LoggerFactory.getLogger(ExportEngine.class);

    private Export export = null;

    public Export getExport() {
	return export;
    }

    @Inject
    public void setExport(Export export) {
	this.export = export;
    }

    public void run() {
	try {
	    if (export != null) {
		System.out.println("CDI export = " + export);
		export.export2HTML(new File("index.html"));
	    } else {
		new MenuHTMLExportFile().export2HTML(new File("index.html"));
	    }
	    // new HTMLExportMultipleFiles().export2HTML(new
	    // File("index.html"));
	} catch (IOException e) {
	    logger.error("Cannot create outputfile", e);
	    System.exit(-1);
	}

    }

}
