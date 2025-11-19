package sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.WindowEvent;

import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class myServer {
    private ServerSocket socket;
    private InetAddress address;
    private int port;
    public static TextArea chat;
    myServer(String ip,String port,TextArea chat,Label error){
        try {
            address = InetAddress.getByName(ip);
            this.port=Integer.parseInt(port);
            myServer.chat=chat;
            start();
            error.setVisible(false);
        }
        catch(Exception e){
            error.setVisible(true);
        }
    }
    private void start() {
    try{
        socket = new ServerSocket(port, 100,address);
        chat.setVisible(true);
        while (!socket.isClosed()) {
            Socket client = socket.accept();
            ClientHandler clientHandler = new ClientHandler(client);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }
        catch(IOException e){
        }
}
}
