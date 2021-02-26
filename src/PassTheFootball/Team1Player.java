package PassTheFootball;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Team1Player {

    private float radius = 5;
    private Color color = Color.WHITE;

    static Circle goalKeeper, defender1, defender2, defender3, midfielder1, midfielder2, striker;

    public Team1Player(float radius, Color color) {

        this.radius = radius;
        this.color = color;


        goalKeeper = new Circle(100,300, radius, color);
        createPlayer(goalKeeper, 1);

        defender1 = new Circle(300,150, radius, color);
        createPlayer(defender1, 2);

        defender2 = new Circle(300,300, radius, color);
        createPlayer(defender2,3);

        defender3 = new Circle(300,450, radius, color);
        createPlayer(defender3,4);

        midfielder1 = new Circle(550, 120, radius, color);
        createPlayer(midfielder1,6);

        midfielder2 = new Circle(550, 360, radius, color);
        createPlayer(midfielder2,5);

        striker = new Circle(900, 300, radius, color);
        createPlayer(striker,7);
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    void createPlayer(Circle circle, Integer number){

        StackPane circleStackPane = new StackPane();
        circleStackPane.setLayoutX(circle.getCenterX() - circle.getRadius());
        circleStackPane.setLayoutY(circle.getCenterY() - circle.getRadius());

        Text circleText = new Text(number.toString());
        circleText.setFill(Color.WHITE);
        circleText.setFont(Font.font(25));

        circleStackPane.getChildren().addAll(circle, circleText);
        GamePage.getPane().getChildren().add(circleStackPane);
    }
}
