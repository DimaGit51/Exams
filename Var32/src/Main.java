import java.io.*;
import java.net.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try{
            serverSocket = new ServerSocket(4000);
            socket = serverSocket.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Matrix m = (Matrix) ois.readObject();
            boolean flag = Matrix.BoolSque(m);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeBoolean(flag);
            oos.flush();
            oos.close();
            ois.close();
            socket.close();
            serverSocket.close();
        }catch (ClassNotFoundException e){
            System.out.println("Not Class");
        }catch (IOException e){
            System.out.println("IO");
        }
    }
}