import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerApp {

    private static final int PORT = 8181;

    public static void main(String[] args) {
        Socket socket;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен, ожидаем подключения");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            int msgCounter = 0;
            while (true){
                String str = in.readUTF();
                System.out.println(str);

                if (str.startsWith("/")){
                    if (str.equals("/stat")){
                        out.writeUTF("Количество повторений: " + msgCounter);
                        continue;
                    }
                    if (str.equals("/end")){
                        out.writeUTF("Завершение работы приложения.");
                        break;
                    }
                }
                out.writeUTF("Эхо: " + str);
                msgCounter++;
            }

//            while (true) {
//                Scanner scanner = new Scanner(System.in);
//                String strOut = scanner.nextLine();
//                out.writeUTF("Сервер сказал: " + strOut);
//            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}