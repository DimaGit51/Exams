package Task_68;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TEST_68 {
    public static void main(String[] args) throws IOException {
        System.out.println("Ебат\n");

        MyArray myArray = new MyArray(1);
        myArray.setArray(new int[]{1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0});// 1, 2

        Socket socket = new Socket("localhost", 4000);

        ObjectOutputStream out =  new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(myArray);
        out.flush();

        DataInputStream in = new DataInputStream(socket.getInputStream());
        System.out.println(in.readInt());
    }
}
