package PassTheFootball;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StartPage {

    private float startPageWidth = 200;
    private float startPageHeight = 500;
    private Scene startPageScene;
    private ImageView playButton;

    public StartPage(float startPageWidth, float startPageHeight) {

        this.startPageWidth = startPageWidth;
        this.startPageHeight = startPageHeight;

        Pane startPagePane = new Pane();

        Text startPageText = new Text("Pass The Football");
        startPageText.setX(300);
        startPageText.setY(200);
        startPageText.setFont(Font.font(80));
        startPageText.setFill(Color.WHITE);
        startPageText.setStrokeWidth(2);
        startPageText.setStroke(Color.BLACK);

        Text playText = new Text("Let's Play");
        playText.setX(500);
        playText.setY(500);
        playText.setFont(Font.font(40));
        playText.setFill(Color.BLACK);
        playText.setStroke(Color.WHITE);
        playText.setStrokeWidth(1);

        Image startPageImage = null;
        try {
            startPageImage = new Image(new FileInputStream("C:\\Users\\mdati\\Downloads\\Pass The Football\\src\\Images\\Football Field Sunrise.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Image footballImage = null;
        try {
            footballImage = new Image(new FileInputStream("C:\\Users\\mdati\\Downloads\\Pass The Football\\src\\Images\\firy football.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ImageView startPageBackground = new ImageView(startPageImage);
        startPageBackground.setFitWidth(startPageWidth);
        startPageBackground.setFitHeight(startPageHeight);

        playButton = new ImageView(footballImage);
        playButton.setX(430);
        playButton.setY(300);
        playButton.setFitWidth(280);
        playButton.setFitHeight(200);
        playButton.setOnMouseClicked(event -> {

            Game.setScene(GamePage.getScene());
        });

        startPagePane.getChildren().addAll(startPageBackground, playButton, startPageText, playText);

        startPageScene = new Scene(startPagePane, startPageWidth, startPageHeight);


    }

    public Scene getStartPageScene() {
        return startPageScene;
    }

    public ImageView getPlayButton() {
        return playButton;
    }
}
