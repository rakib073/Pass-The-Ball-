package PassTheFootball;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class GamePage {

    static Pane pane;
    private static Scene scene;
    final static float width = 1100;
    final static float height = 700;
    final static float ballStartX = width/2;
    final static float ballStartY = (height-100)/2;
    final static float ballRadius = 9;

    public GamePage(){

        pane = new Pane();

        //Creating Field
        Field field = new Field(0,0, width, height - 100);

        //Creating Ball
        Ball ball = new Ball(ballStartX, ballStartY, ballRadius);

        //Creating Goal Text
        GoalText goalText = new GoalText();

        Scoreline scoreline = new Scoreline();

        //Generating Players
        Team1Player team1Players = new Team1Player(20, Color.BLACK);
        Team2Player team2Players = new Team2Player(20, Color.WHITE);

        //Creating Bar
        RotatingBar1 rotatingBar1 = new RotatingBar1(100,650,5,45);
        RotatingBar2 rotatingBar2 = new RotatingBar2(1000,650,5,45);

        scene = new Scene(pane, width, height);

    }

    public static Pane getPane() {
        return pane;
    }

    public static void setPane(Pane pane) {
        GamePage.pane = pane;
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        GamePage.scene = scene;
    }
}
