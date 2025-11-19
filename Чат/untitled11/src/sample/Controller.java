package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button CloseMenu;

    @FXML
    private MenuBar MenuMove;

    @FXML
    private Button MenuRoll;

    @FXML
    private Label MenuRollT;

    @FXML
    private Button CreateClient;

    @FXML
    private Button CreateServer;

    private boolean MenuClicked;
    private static Scene scene;

    double xMenu;
    double yMenu;

    @FXML
    void initialize() {
        Animated ButtonServ=new Animated(CreateServer);
        ButtonServ.btnAnimated();
        Animated ButtonClient=new Animated(CreateClient);
        ButtonClient.btnAnimated();
        //start
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
        //konec
        CreateServer.setOnAction(e->{
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/server.fxml"));
            try {
                loader.load();
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
            Parent root=loader.getRoot();
            Main.stage.setScene(new Scene(root,Color.TRANSPARENT));
            Main.stage.show();
        });
        CreateClient.setOnAction(e->{
            FXMLLoader load=new FXMLLoader();
            load.setLocation(getClass().getResource("/sample/client.fxml"));
            try {
                load.load();
            }
            catch (Exception er){

            }
            Parent parent=load.getRoot();
            Scene scene=new Scene(parent,Color.TRANSPARENT);
            Main.stage.setScene(scene);
            Main.stage.show();
        });

    }
}
