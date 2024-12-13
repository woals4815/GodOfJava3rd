package e.io.practice;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;

public class ManageObject {
    public static void main(String[] args) throws Exception {
        ManageObject m = new ManageObject();
        String fullPath = Path.of(".").toAbsolutePath().toString();
        m.saveObject(fullPath + "/object.txt", new SerialDTO("name", 1, "male"));
    }

    public void saveObject(String fullPath, SerialDTO s) throws Exception {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(fullPath);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(s);
        }catch (Exception e) {
            e.printStackTrace();
            if (fos != null) {
                fos.close();
            }
            if (oos != null) {
                oos.close();
            }
        }
    }

}
