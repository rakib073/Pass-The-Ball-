package PassTheFootball;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game extends Application {

    static Scene scene;
    final static float width = 1100;
    final static float height = 700;

    public static void main(String args[]){

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        GamePage gamePage = new GamePage();

        StartPage startPage = new StartPage(width, height);
        scene = startPage.getStartPageScene();

        startPage.getPlayButton().setOnMouseClicked(event -> {
            stage.setScene(gamePage.getScene());
        });

        Ball.getHomeButton().setOnMouseClicked(event -> {
            stage.setScene(startPage.getStartPageScene());
        });

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Pass The Football");
        stage.show();
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        Game.scene = scene;
    }
}
