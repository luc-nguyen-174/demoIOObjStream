import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1,"abc",30));
        users.add(new User(2,"def",31));
        users.add(new User(3,"jadh",28));
        writeFile(users,"demo.bin");
        System.out.println(readFile("demo.bin"));
    }

    public static boolean writeFile(List<User> users , String filename) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(users);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<User> readFile(String filename){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            return (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}