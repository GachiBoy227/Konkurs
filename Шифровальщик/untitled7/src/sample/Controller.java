package sample;

import java.awt.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.datatransfer.*;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    public static Message message;
    public static Timer tim;
    boolean check=true;
    boolean checkSwitch=true;
    private double xMenu=0;
    private double yMenu=0;
    private boolean MenuClicked=false;
    @FXML
    private Label TextCopy;
    @FXML
    private ImageView RandMess;
    @FXML
    private Button Buttonicon;
    @FXML
    private Label RandomText;
    @FXML
    private TextArea Input;

    @FXML
    private TextArea Output;

    @FXML
    private Button Send;

    @FXML
    private CheckBox crypt;

    @FXML
    private CheckBox encrtypt;

    @FXML
    private PasswordField key;

    @FXML
    private ImageView logo;


    @FXML
    private Label error;

    @FXML
    public Button CloseMenu;

    @FXML
    private MenuBar MenuMove;

    @FXML
    private Button MenuRoll;

    @FXML
    private Label MenuRollT;

    @FXML
    void initialize() {
//мЕНЮ СТАРТ
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
//ФИНИШ

        logo.setImage(new Image(getClass().getResourceAsStream("icon.png")));
        RandMess.setImage(new Image(getClass().getResourceAsStream("j.png")));
        tim=new Timer();
        TimerTask tas=new TimerTask() {
            @Override
            public void run() {
            RandMess.setOpacity(RandMess.getOpacity()+0.1);
            }
        };
        tim.schedule(tas,1500,60);
        CryptoGraph.alphavit("абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
        Shifr shifr=new Shifr("абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&?*()_+-.[]:, ");
        RandSlova.setSlova("абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&?*()_+-.[]: ".split(""));
        crypt.setSelected(true);
        message=new Message("  псс..Эй..я могу дать тебе случайный ключ",2100,120,RandomText);
        final AnimationTimer timer=new AnimationTimer() {
            @Override
            public void handle(long l) {
                message.start();
                if(crypt.isSelected()&&!check){
                    crypt.setSelected(true);
                    encrtypt.setSelected(false);
                    check=true;
                }
                else if(encrtypt.isSelected()&&check){
                    crypt.setSelected(false);
                    encrtypt.setSelected(true);
                    check=false;
                }
                if(!key.getText().equals("")){
                    error.setDisable(true);
                    if(checkSwitch) {
                        Output.setText("");
                        checkSwitch=false;
                    }
                    RandomText.setVisible(false);
                    RandMess.setVisible(false);
                }
                else{
                    error.setDisable(false);
                    RandomText.setVisible(true);
                    RandMess.setVisible(true);
                    checkSwitch=true;
                }
                if(key.isFocused()){
                    TextCopy.setVisible(false);
                }
            }
        };
        timer.start();
        Buttonicon.setOnAction(e->{
           String n=RandSlova.randslov(8);
            key.setText(n);
            StringSelection stringSelection = new StringSelection(n);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            TextCopy.setVisible(true);
        });
        Animated.btnAnimated(Send);
        Send.setOnAction(e->{
            if(!key.getText().equals("")) {
                if (crypt.isSelected()) {
                     String[]inp=Input.getText().split("\n");
                     if(inp.length>=1){
                         Output.setText("");
                         for (int i=0; i<inp.length;i++){
                             if(!inp[i].equals("")) {
                                 Output.setText(Output.getText() + CryptoGraph.shifrovka(shifr.shifra(inp[i].split(""), key.getText().split("")), 2, 2) + "\n");
                             }
                             }
                     }
                     else {
                         Output.setText(CryptoGraph.shifrovka(shifr.shifra(Input.getText().split(""), key.getText().split("")), 2, 2));
                     }
                } else {
                    String[]inp=Input.getText().split("\n");
                    if(inp.length>=1){
                        Output.setText("");
                        for (int i=0; i<inp.length;i++){
                            if(!inp[i].equals("")) {
                                Output.setText(Output.getText() + shifr.rashifra(CryptoGraph.rashifrovka(inp[i], 2, 2).split(""), key.getText().split("")) + "\n");
                            }
                        }
                    }
                    else {
                        Output.setText(shifr.rashifra(CryptoGraph.rashifrovka(Input.getText(), 2, 2).split(""), key.getText().split("")));
                    }
                }
            }
            else{
                    Output.setText("Вы не ввели ключ[RU]\n" +
                            "You didn't enter the key[EN]");
            }
        });

    }

}
