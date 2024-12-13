package e.io.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.Optional;

public class NioSample {
    public static void main(String[] args) throws Exception {
        NioSample sample = new NioSample();
        sample.basicWriteAndRead();
        sample.printnull();
    }
    public void basicWriteAndRead() throws Exception {
        String path = Path.of("").toAbsolutePath().toString();
        writeFile(path + "/hello.txt", "123123123123123");
        readFile(path + "/hello.txt");
    }

    public void writeFile(String filename, String data) throws Exception {
        FileChannel channel = new FileOutputStream(filename).getChannel();
        byte[] byteData = data.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(byteData);
        channel.write(buffer);
        channel.close();
    }
    public void readFile(String filename) throws Exception {
        FileChannel channel = new FileInputStream(filename).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        buffer.flip();
        while(buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
        channel.close();
    }

    public void printnull() {
        System.out.println(Optional.of("hello").isPresent());
        System.out.println(Optional.ofNullable("asdf").isPresent());
    }
}
