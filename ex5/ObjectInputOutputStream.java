package ex5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStream {
    public static void main(String[] args) {
        Student s1 = new Student();
        try {
            FileOutputStream out = new FileOutputStream("ex5/student.out");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(new Student(1, "jae"));
            oos.flush();
        } catch(Exception e) {
            System.out.println("Problem serializing: " + e);
        }
        try {
            FileInputStream in = new FileInputStream("ex5/student.out");
            ObjectInputStream ois = new ObjectInputStream(in);
            s1 = (Student) ois.readObject();
        } catch(Exception e) {
            System.out.println("Problem serializing: " + e);
        }
        System.out.println(s1);
    }
}
