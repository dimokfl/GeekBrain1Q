import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerApp {

    private static final int PORT = 8189;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Socket socket;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен, ожидаем подключения");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str=in.readUTF();
                            System.out.println("Пользователь: "+str+"\n");
                            if (str.equalsIgnoreCase("/end")) break;
                        }
                        String strOut=scanner.nextLine();
                        out.writeUTF("Сервер сказал" + strOut);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}