package szgPART;

import java.io.*;

public interface FileActions {
    public void saveObjectToFile(Object obj, String filename);

    public Object loadObjectFromFile(String filename);
}
