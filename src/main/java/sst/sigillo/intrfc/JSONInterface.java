package sst.sigillo.intrfc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import lombok.Getter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sst.common.file.output.OutputFile;
import sst.sigillo.model.Category;
import sst.sigillo.model.SigilloData;
import sst.sigillo.model.SigilloModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONInterface implements FileInterface {

    private static Logger logger = LoggerFactory.getLogger(JSONInterface.class);

    @Getter
    private static FileInterface theOne = null;

    static {
	theOne = new JSONInterface();
    }

    private JSONInterface() {
    }

    @Override
    public void load() throws FileNotFoundException {
	load("data/sigillo.json");
    }

    @Override
    public void load(String filename) throws FileNotFoundException {
	logger.info("Loading JSON file " + filename + "...");

	SigilloModel model = SigilloModel.getInstance();
	StringBuffer buffer = new StringBuffer();
	try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {
	    String line = null;
	    while ((line = br.readLine()) != null) {
		buffer.append(line);
	    }
	} catch (FileNotFoundException e) {
	    logger.warn(e.getMessage());
	    throw e;
	} catch (IOException e) {
	    logger.error("Cannot load file " + filename, e);
	    System.exit(-1);
	}
	Gson gson = new GsonBuilder().registerTypeAdapter(Category.class, new CategoryInstanceCreator()).create();
	model.setData(gson.fromJson(buffer.toString(), SigilloData.class));
    }

    @Override
    public void save() {
	save("data/sigillo.json");
    }

    @Override
    public void save(String filename) {
	logger.info("Saving XML file " + filename + "...");
	// Gson gson = new Gson();
	Gson gson = new GsonBuilder()/* .setPrettyPrinting() */.setVersion(1.0).create();
	SigilloModel model = SigilloModel.getInstance();
	try (OutputFile output = new OutputFile(new File(filename))) {
	    output.print(gson.toJson(model.getData()));
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
