package e.io.practice;

import java.nio.IntBuffer;

public class NioDetailSample {
    public static void main(String[] args) {
        NioDetailSample nioDetailSample = new NioDetailSample();
        nioDetailSample.checkBuffer();
    }
    public void checkBuffer() {
        try {
            IntBuffer buffer = IntBuffer.allocate(1024);
            for (int i = 0; i < 100; i++) {
                buffer.put(i);
            }
            System.out.println("capacity " + buffer.capacity());
            System.out.println("position " + buffer.position());
            System.out.println("limit " + buffer.capacity());
            buffer.flip();
            System.out.println("buffer flipped");

            System.out.println("position " + buffer.position());
            System.out.println("limit " + buffer.limit());
            System.out.println("capacity " + buffer.capacity());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
