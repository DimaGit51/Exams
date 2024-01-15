package Task_68;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(4000);

        Socket socket = serverSocket.accept();
        ObjectInputStream in  = new ObjectInputStream(socket.getInputStream());

        MyArray array = (MyArray) in.readObject();

        Scanner scanner = new Scanner(System.in);
        int value = 0, count = 0;
        try {
            value = scanner.nextInt();
            count = scanner.nextInt();
        }catch (Exception e){
            System.out.println("Некоректные данные");
        }

        int rezalt = MyArray.getCount(array, value, count);

        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeInt(rezalt);

        in.close();
        out.close();
        socket.close();
    }
}
