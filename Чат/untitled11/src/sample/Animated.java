package sample;

import javafx.scene.control.Button;

public class Animated {
    Button btn;
    int i=0;
    Animated(Button btn){
        this.btn=btn;
    }
    public void btnAnimated(){
        btn.setOnMousePressed(ev->{
            btn.setScaleX(0.8);
            btn.setScaleY(0.8);
        });
        btn.setOnMouseReleased(ev->{
            btn.setScaleX(1);
            btn.setScaleY(1);
        });
        btn.setOnMouseMoved(e->{
            Thread thread=new Thread(() -> {
                try{
                    while (btn.getOpacity()<1&&btn.isHover()) {
                        btn.setOpacity(btn.getOpacity()+0.1);
                        btn.setScaleX(btn.getScaleX()+0.05);
                        btn.setScaleY(btn.getScaleY()+0.05);
                        this.i+=5;
                        btn.setStyle(btn.getStyle()+"-fx-background-radius:"+i+";");
                        Thread.sleep(50);
                    }
                }
                catch(Exception e1){
                }
            });
            thread.start();
        });
        btn.setOnMouseExited(e->{
            Thread thread=new Thread(() -> {
                try{
                    while (btn.getOpacity()>0.5&&!btn.isHover()){
                        btn.setOpacity(btn.getOpacity()-0.1);
                        btn.setScaleX(btn.getScaleX()-0.05);
                        btn.setScaleY(btn.getScaleY()-0.05);
                        this.i -= 5;
                        btn.setStyle(btn.getStyle()+"-fx-background-radius:"+i+";");
                        Thread.sleep(50);
                    }
                }
                catch(Exception e1){
                }
            });
            thread.start();
        });
    }
}