package PassTheFootball;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Team2Player {

    private float radius = 5;
    private Color color = Color.BLACK;

    static Circle goalKeeper, defender1, defender2, defender3, midfielder1, midfielder2, striker;

    public Team2Player(float radius, Color color) {

        this.radius = radius;
        this.color = color;

        goalKeeper = new Circle(1000,300, radius, color);
        createPlayer(goalKeeper,1);

        defender1 = new Circle(800,150, radius, color);
        createPlayer(defender1,2);

        defender2 = new Circle(800,300, radius, color);
        createPlayer(defender2,3);

        defender3 = new Circle(800,450, radius, color);
        createPlayer(defender3,4);

        midfielder1 = new Circle(550, 240, radius, color);
        createPlayer(midfielder1,5);

        midfielder2 = new Circle(550, 480, radius, color);
        createPlayer(midfielder2,6);

        striker = new Circle(200, 300, radius, color);
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
        circleText.setFill(Color.BLACK);
        circleText.setFont(Font.font(25));

        circleStackPane.getChildren().addAll(circle, circleText);
        GamePage.getPane().getChildren().add(circleStackPane);
    }
}
