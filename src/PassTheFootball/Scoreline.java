package PassTheFootball;


import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Scoreline {

    private static int goal1 = 0;
    private static int goal2 = 0;
    static Text scoreLine;

    public Scoreline() {

        scoreLine = new Text();
        scoreLine.setText("Team 1 - " + goal1 + " : " + goal2 + " - Team 2");
        scoreLine.setFont(Font.font(40));
        scoreLine.setX(340);
        scoreLine.setY(640);

        GamePage.getPane().getChildren().add(scoreLine);

    }

    public static int getGoal1() {
        return goal1;
    }

    public static void setGoal1(int goal1) {
        Scoreline.goal1 = goal1;
        Scoreline.scoreLine.setText("Team 1 - " + goal1 + " : " + goal2 + " - Team 2");
    }

    public static int getGoal2() {
        return goal2;
    }

    public static void setGoal2(int goal2) {
        Scoreline.goal2 = goal2;
        Scoreline.scoreLine.setText("Team 1 - " + goal1 + " : " + goal2 + " - Team 2");
    }
}
