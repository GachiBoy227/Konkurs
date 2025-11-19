package sample;


import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


import java.util.Timer;
import java.util.TimerTask;

public class Message {
    protected String[] message;
    protected int count=0;
    private int oldcount=0;
    private int delay;
    Timer timer;
    TaskMessage task;
    Label text;
    Message(String message, int delay,int loop,Label text){
            this.message = message.split("");
            this.delay = delay;
            text.setText("");
            this.text = text;
            task = new TaskMessage(this,text);
            timer = new Timer();
            timer.schedule(task, delay, loop);
    }
    public void start(){
        if(count>oldcount){
            oldcount=count;
            text.setText(text.getText()+message[count-1]);
        }
    }
    public void stop(){
        timer.cancel();
    }
}
