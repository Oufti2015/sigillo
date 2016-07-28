package sst.sigillo.intrfc;

import java.io.FileNotFoundException;

public interface FileInterface { // NO_UCD (use default)
    public void load() throws FileNotFoundException;

    public void load(String filename) throws FileNotFoundException;

    public void save();

    public void save(String filename);
}
