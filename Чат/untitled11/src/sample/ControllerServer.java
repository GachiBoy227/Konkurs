package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ControllerServer {
    @FXML
    private Button CloseMenu;

    @FXML
    private MenuBar MenuMove;

    @FXML
    private Button MenuRoll;

    @FXML
    private Label LabelIP;

    @FXML
    private Label LabelPort;

    @FXML
    private TextField EditIP;

    @FXML
    private TextField EditPort;

    @FXML
    private Label MenuRollT;
    @FXML
    private Button CreateServer;
    @FXML
    private Label tochka;
    @FXML
    private TextArea ServerChat;
    @FXML
    private Label Waiting;

    private boolean MenuClicked;

    double xMenu;
    double yMenu;

    private String lengthEdit1="";
    private String lengthEdit2="";

    @FXML
    void initialize(){
        final AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(EditIP.isFocused()){
                    OpacityLabelAnimated(LabelIP,-0.05,0.4);
                }
                else{
                    OpacityLabelAnimated(LabelIP,0.05,1);
                }
                if(EditPort.isFocused()){
                    OpacityLabelAnimated(LabelPort,-0.05,0.4);
                }
                else {
                    OpacityLabelAnimated(LabelPort,0.05,1);
                }
                lengthEdit1 = lengthField(EditIP, lengthEdit1, 15);
                lengthEdit2 = lengthField(EditPort, lengthEdit2, 5);
            }
        };
        timer.start();
        Animated ButtonServ=new Animated(CreateServer);
        ButtonServ.btnAnimated();
        //nac
        MenuRollT.setOnMouseEntered(e->{
            MenuRoll.setStyle(MenuRoll.getStyle()+"-fx-background-color:#d76e00;");
            MenuRollT.setStyle("-fx-text-fill:white;");
        });
        MenuRollT.setOnMouseExited(e->{
            MenuRoll.setStyle(MenuRoll.getStyle()+"-fx-background-color:orange;");
            MenuRollT.setStyle("-fx-text-fill:black;");
        });
        MenuRoll.setOnMouseEntered(e->{
            MenuRoll.setStyle(MenuRoll.getStyle()+"-fx-background-color:#d76e00;");
            MenuRollT.setStyle("-fx-text-fill:white;");
        });
        MenuRoll.setOnMouseExited(e->{
            MenuRoll.setStyle(MenuRoll.getStyle()+"-fx-background-color:orange;");
            MenuRollT.setStyle("-fx-text-fill:black;");
        });
        MenuRoll.setOnAction(e->{
            Main.stage.setIconified(true);
        });
        MenuRollT.setOnMousePressed(e->{
            Main.stage.setIconified(true);
        });

        CloseMenu.setOnMouseEntered(e->{
            CloseMenu.setStyle("-fx-background-color:#5c0000;"+"\n"+"-fx-text-fill:white;");
        });
        CloseMenu.setOnMouseExited(e->{
            CloseMenu.setStyle("-fx-background-color:#cc0605;"+"\n"+"-fx-text-fill:black;");
        });

        CloseMenu.setOnAction(e->{
            Main.stage.close();
            System.exit(0);
        });

        MenuMove.setOnMouseEntered(e->{
            if(MenuClicked){

            }
            else{
                MenuMove.setCursor(Cursor.OPEN_HAND);
            }
        });
        MenuMove.setOnMousePressed(mouseEvent -> {
            MenuClicked=true;
            xMenu=mouseEvent.getSceneX();
            yMenu=mouseEvent.getSceneY();
            MenuMove.setCursor(Cursor.CLOSED_HAND);
        });
        MenuMove.setOnMouseReleased(e->{
            MenuClicked=false;
            MenuMove.setCursor(Cursor.OPEN_HAND);
        });
        MenuMove.setOnMouseDragged(mouseEvent -> {
            Main.stage.setX(mouseEvent.getScreenX()-xMenu);
            Main.stage.setY(mouseEvent.getScreenY()-yMenu);
        });
        //con
        CreateServer.setOnAction(e->{
            timer.stop();
            EditIP.setVisible(false);
            EditPort.setVisible(false);
            LabelIP.setVisible(false);
            LabelPort.setVisible(false);
            tochka.setVisible(false);
            CreateServer.setVisible(false);
            Thread server=new Thread(new Runnable() {
                @Override
                public void run() {
                    myServer server=new myServer(EditIP.getText(),EditPort.getText(),ServerChat,Waiting);
                }
            });
            server.start();
        });
    }
 private void OpacityLabelAnimated(Label label,double animation,double ogranichenie){

             if(ogranichenie>0.5){
                 if(label.getOpacity()<ogranichenie){
                     label.setOpacity(label.getOpacity()+animation);
                 }
             }
             else{
                 if(label.getOpacity()>ogranichenie){
                     label.setOpacity(label.getOpacity()+animation);
                 }
             }
         }
    private String lengthField(TextField textField,String Text,int length){
        if(textField.getLength()==length){
            Text=textField.getText();
        }
        if(textField.getLength()>length){
            int pos=textField.getCaretPosition()-1;
            textField.setText(Text);
            textField.positionCaret(pos);
        }
        return Text;
    }

}

