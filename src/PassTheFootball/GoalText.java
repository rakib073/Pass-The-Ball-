package PassTheFootball;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GoalText {

    static Text goalText;

    public GoalText() {

        goalText = new Text("");
        goalText.setFont(Font.font(100));
        goalText.setX(355);
        goalText.setY(320);
        goalText.setFill(Color.RED);
        goalText.setStroke(Color.WHITE);
        goalText.setStrokeWidth(2);

        GamePage.getPane().getChildren().add(goalText);
    }
}
