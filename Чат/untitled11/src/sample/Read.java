package sample;

import javafx.scene.control.TextArea;
import org.w3c.dom.Text;

import java.io.BufferedReader;

public class Read implements Runnable {
    boolean starting;
    BufferedReader out;
    public Read(BufferedReader out){
        this.out=out;
        starting=true;
    }
    @Override
    public void run() {
        while (starting) {
            try {
                    String word = out.readLine();
                    if(word!=null) {
                        Client.ServerChat.setText(Client.ServerChat.getText() + word + "\n");
                    }
                    else {
                        Main.stage.close();
                        System.exit(0);
                    }
            } catch (Exception e) {
                     System.exit(0);
            }
        }
    }
}
