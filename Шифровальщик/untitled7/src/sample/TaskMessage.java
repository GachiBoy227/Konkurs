package sample;


import javafx.scene.control.Label;

import java.util.TimerTask;

public class TaskMessage extends TimerTask {
    private String[] message;
    private Message mess;
    Label text;
    TaskMessage(Message mess,Label text){
        this.mess=mess;
        this.message=mess.message;
        this.text=text;
    }
    @Override
    public void run() {
        if(mess.count<message.length) {
            mess.count++;
        }
        else{
            mess.stop();
        }
    }
}
