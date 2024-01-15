
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Matrix matrix = new Matrix(3, 4);

        Socket socket = new Socket("localhost", 4000);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(matrix);
        out.flush();

        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        boolean f = in.readBoolean();

        System.out.println(f);

        in.close();
        out.close();
        socket.close();
    }
}
