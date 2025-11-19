package sample;

import javafx.scene.control.Button;

public class Animated {
    public static void btnAnimated(Button btn){
        btn.setOnMousePressed(ev->{
            btn.setScaleX(0.8);
            btn.setScaleY(0.8);
        });
        btn.setOnMouseReleased(ev->{
            btn.setScaleX(1);
            btn.setScaleY(1);
        });
    }
}
