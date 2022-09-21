package ex4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStream {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream("ex4/invoice"));
        double[] prices = { 1.1, 2.2, 3.3, 4.4 };
        int[] units = { 1, 2, 3, 4 };
        String[] descs = { "Java T-shirt",
                "Java Mug",
                "Duke Juggling Dolls",
                "Java Pin"
        };
        for(int i = 0; i < prices.length; i++) {
            out.writeDouble(prices[i]);
            out.writeChar('\t');
            out.writeInt(units[i]);
            out.writeChar('\t');
            out.writeChars(descs[i]);
            out.writeChar('\n');
        }
        out.close();

        DataInputStream in = new DataInputStream(new FileInputStream("ex4/invoice"));
        double price;
        int unit;
        StringBuffer desc;
        double total = 0.0;

        String lineSepString = System.getProperty("line.separator");
        char lineSep = lineSepString.charAt(lineSepString.length()-1);

        try {
            while(true) {
                price = in.readDouble();
                in.readChar();
                unit = in.readInt();
                in.readChar();
                char chr;
                desc = new StringBuffer(20);
                while((chr = in.readChar()) != lineSep) {
                    desc.append(chr);
                }
                System.out.println("You've ordered " +
                        unit + " units of " +
                        desc + " at $" + price);
                total = total + unit * price;
            }
        } catch (EOFException e) {
        }
        System.out.println("For a TOTAL of: $" + total);
        in.close();
    }
}
