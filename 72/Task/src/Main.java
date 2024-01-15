import java.io.*;
import java.net.*;
import java.util.*;
public class Main {
    public static void main(String[] args){
        try {
            ServerSocket server = new ServerSocket(4444);
            Socket socket = server.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            MyArray myArray = (MyArray) in.readObject();
            Scanner scan = new Scanner(System.in);
            int k = scan.nextInt();
            int[] mas = MyArray.Task(myArray, k);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(mas);
            out.close();
            in.close();
            socket.close();
        }
        catch(ClassNotFoundException e){
            System.out.println("...");
        }
        catch(IOException e){
            System.out.println("Ошибка ввода.вывода");
        }
    }
}
