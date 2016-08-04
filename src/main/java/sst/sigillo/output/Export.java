package sst.sigillo.output;

import java.io.File;
import java.io.IOException;

public interface Export {
    public void export2HTML(File file) throws IOException;
}
