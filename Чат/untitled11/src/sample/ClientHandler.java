package sample;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ClientHandler implements Runnable{
    private String username;
    private static Date date=new Date();
    private BufferedReader reader;
    private BufferedWriter writer;
    private Socket client;
    private static ArrayList<ClientHandler> clients=new ArrayList<ClientHandler>();
    public ClientHandler(Socket client) throws IOException {
        this.client=client;
        writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
    }

    @Override
    public void run() {
        SimpleDateFormat dateFormat=new SimpleDateFormat("hh:mm");
        try {
            username=reader.readLine();
            date=new Date();
            clients.add(this);
            send(dateFormat.format(date)+"     "+"Server:["+username+"] Подключился");
            myServer.chat.setText(myServer.chat.getText()+dateFormat.format(date)+"     "+"Server:  ["+username+"] Подключился\n");
        }catch (Exception e){}

        while(client.isConnected()){
            try {
                String message = "["+this.username+"]:  "+reader.readLine();
                date=new Date();
                myServer.chat.setText(myServer.chat.getText()+dateFormat.format(date)+"     "+message+"\n");
                send(dateFormat.format(date)+"     "+message);
            }
            catch (Exception e){
                break;
            }
        }
        date=new Date();
        myServer.chat.setText(myServer.chat.getText()+dateFormat.format(date)+"     "+"Server:  ["+this.username+"] Отключился\n");
        send(dateFormat.format(date)+"     "+"Server:  ["+this.username+"] Отключился ",this.username);
        closeClient(this);
    }
    public void send(String message){
        for(ClientHandler clien:clients){
            if(!clien.username.equals(this.username)) {
                try {
                    clien.writer.write(message+"\n");
                    clien.writer.flush();
                } catch (Exception e) {
                }
            }
        }
    }
    public void send(String message,String username){
        for(ClientHandler clien:clients){
            if(clien.username!=null) {
                if (!clien.username.equals(username)) {
                    try {
                        clien.writer.write(message + "\n");
                        clien.writer.flush();
                    } catch (Exception e) {
                    }
                }
            }
        }
    }
    public void closeClient(ClientHandler clientHandler){
        clients.remove(clientHandler);
    }
}
