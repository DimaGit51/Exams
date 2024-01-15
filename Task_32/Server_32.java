package Task_32;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_32 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(4000);

        Socket socket = serverSocket.accept();
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        MyMatrix matrix = (MyMatrix) in.readObject();

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeBoolean(MyMatrix.isMegik(matrix));
        out.flush();

        out.close();
        in.close();
        socket.close();
        serverSocket.close();
    }
}
