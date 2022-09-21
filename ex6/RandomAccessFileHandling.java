package ex6;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileHandling {
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("ex6/test.txt", "rw");
            raf.writeInt(10);
            raf.writeInt(43);
            raf.writeInt(88);
            raf.writeInt(455);

            // change the 3rd integer from 88 to 99
            raf.seek((3 - 1) * 4);
            raf.writeInt(99);
            raf.seek(0); // go to the first integer
            int i = raf.readInt();
            while (i != -1) {
                System.out.println(i);
                i = raf.readInt();
            }
            raf.close();
        } catch (IOException e) {

        }
    }
}
