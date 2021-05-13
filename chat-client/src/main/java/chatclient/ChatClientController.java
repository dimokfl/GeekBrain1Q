package chatclient;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatClientController {

//    private  static boolean continueRead = true;
    private final String SERVER_ADDRESS = "localhost";
    private final int SERVER_PORT = 8181;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    @FXML
    private TextArea chatArea;
    @FXML
    private TextField inputField;

    @FXML
    private void initialize() throws IOException {
        try{
            openConnection();
            addCloseListener();
        } catch (IOException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка подключения");
            alert.setHeaderText("Сервер не работает");
            alert.showAndWait();
            e.printStackTrace();
            throw e;
        }
    }

    public void openConnection() throws IOException{
        socket = new Socket(SERVER_ADDRESS,SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while (true){
                        System.out.println("Готовы считывать");
                        String strFromServer = in.readUTF();
                        System.out.println("Пользователь написал: " + strFromServer);
                        if (strFromServer.equalsIgnoreCase("/end")){
                            System.out.println("Конец цикла");
                            break;
                        }
//                        chatArea.setText(chatArea.getText() + strFromServer +"\n");
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void addCloseListener() {
        EventHandler<WindowEvent> onCloseRequest = MainApp.mainStage.getOnCloseRequest();
        MainApp.mainStage.setOnCloseRequest(event -> {
            closeConnection();
            if (onCloseRequest != null) onCloseRequest.handle(event);
        });
    }


    private  void closeConnection(){
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void sendMsg() {
        if (!inputField.getText().trim().isEmpty()) {
            chatArea.setText(chatArea.getText() + "Я:" + inputField.getText().trim() + "\n");
            try {
                out.writeUTF(inputField.getText());
                inputField.clear();
                inputField.requestFocus();
            } catch (IOException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Ошибка отправки сообщения");
                alert.setHeaderText("Ошибка отправки сообщения");
                alert.setContentText("При отправке сообщения возникла ошибка" + e.getMessage());
                alert.show();
            }
        }
    }
}
