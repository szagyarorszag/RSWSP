package szgPART;

import java.io.*;

public interface FileActions {
    void saveObjectToFile(Object obj, String filename);

    public Object loadObjectFromFile(String filename);
}
