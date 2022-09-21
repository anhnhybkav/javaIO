package ex2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("ex2/intput.txt");
        File outputFile = new File("ex2/output.txt");
        FileReader fr = new FileReader(inputFile);
        FileWriter fw = new FileWriter(outputFile);
        int c;
        while((c = fr.read()) != -1) {
            System.out.println(c);
            fw.write(c);
        }

        System.out.println("FileReader is used to read a file and FileWriter is used for writing.");
       
        fr.close();
        fw.close();
    }
}
