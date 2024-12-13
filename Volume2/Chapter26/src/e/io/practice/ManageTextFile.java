package e.io.practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class ManageTextFile {
    public static void main(String[] args) {
        ManageTextFile fileManager = new ManageTextFile();
        String cwd = Path.of("").toAbsolutePath().toString();
        System.out.println(cwd);
        fileManager.writeFile(cwd + "/hello.txt", 10);
    }
    public void writeFile(String filename, int numberCount) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(filename, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            for(int i = 0; i < numberCount; i++) {
                bufferedWriter.write(i + "\n");
            }
            System.out.println("file write success");
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
