package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Cryptographer");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("ic.png")));
        primaryStage.setScene(new Scene(root, 800, 530, Color.TRANSPARENT));
        primaryStage.setResizable(false);
        primaryStage.show();
        stage=primaryStage;
    }
    @Override

    public void stop(){
        Controller.message.stop();
        Controller.tim.cancel();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
