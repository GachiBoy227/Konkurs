package sample;



import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    String ClientIP;
    int ClientPort;
    static TextArea ServerChat;
    private static Socket clientSocket;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static Read read;
    private Label error;
    private TextArea clientChat;
    Thread threadRead;
    public Client(String ip, int port, TextArea chat,TextArea clientChat, Label error){
        ClientIP=ip;
        ClientPort=port;
        ServerChat=chat;
        this.clientChat=clientChat;
        this.error=error;
        start();
    }

    public void start(){
        try {
            clientSocket = new Socket(InetAddress.getByName(ClientIP), ClientPort);
            ServerChat.setVisible(true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            clientChat.setVisible(true);
            ServerChat.setVisible(true);
            error.setVisible(false);
            ServerChat.setText("Введите имя:");
            read=new Read(in);
            threadRead=new Thread(read);
            threadRead.start();
        } catch (IOException e) {
            error.setVisible(true);
            clientChat.setVisible(false);
            ServerChat.setVisible(false);
        }
    }
    public void send(String text){
            try {
                ServerChat.setText(ServerChat.getText() + text);
                out.write(text);
                out.flush();
            } catch (Exception e) {
                //ОШИБКА отпрваки
                System.out.println(e);
            }
    }

}