package ex1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStream {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("ex1/intput.txt");
        File outputFile = new File("ex1/output.txt");
        FileInputStream in = new FileInputStream(inputFile);
        FileOutputStream out = new FileOutputStream(outputFile);
        int c;
        while((c = in.read()) != -1) {
            System.out.println(c);
            out.write(c);// ma ascii, ep sang char de tra ve chuoi dau
        }
        System.out.println("FileInputStream is used to read a file and FileOutPutStream is used for writing.");
       
        in.close();
        out.close();
    }   
}