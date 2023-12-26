package szgPART;

import java.io.*;

public class File implements FileActions {
    public File() {}
    public void saveObjectToFile(Object obj, String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
        } catch (IOException ioe) {
            System.out.println("Error saving object to file: " + filename);
            ioe.printStackTrace();
        }
    }
    public Object loadObjectFromFile(String filename) {
        Object obj = null;
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            obj = ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error reading file: " + filename);
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading object from file: " + filename);
            cnfe.printStackTrace();
        }
        return obj;
    }
}
