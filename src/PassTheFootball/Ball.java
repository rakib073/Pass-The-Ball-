package PassTheFootball;

import PassTheFootball.GoalText;
import PassTheFootball.RotatingBar1;
import PassTheFootball.RotatingBar2;
import PassTheFootball.Team1Player;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ball {

    private float posX = 10;
    private float posY = 10;
    private float radius = 5;
    private static boolean isTeam1 = true;
    static Button homeButton;

    public Ball(float posX, float posY, float radius) {
        this.posX = posX;
        this.posY = posY;
        this.radius = radius;

        Circle ball = new Circle(posX, posY, radius);

        Image ballImage = null;
        try {
            ballImage = new Image(new FileInputStream("C:\\Users\\mdati\\Downloads\\Pass The Football\\src\\Images\\Football.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ImagePattern ballImagePattern = new ImagePattern(ballImage);

        ball.setFill(ballImagePattern);

        //Buttons
        Button startButton = new Button("Start");
        startButton.setLayoutX(750);
        startButton.setLayoutY(650);

        Button passButton = new Button("Pass");
        passButton.setLayoutX(300);
        passButton.setLayoutY(650);

        homeButton = new Button("Home");
        homeButton.setLayoutX(530);
        homeButton.setLayoutY(650);

        //Function of Buttons
        startButton.setOnMouseClicked(event -> {

            GoalText.goalText.setText("");

            if(isTeam1) {

                RotatingBar1.timeline.play();
                RotatingBar2.timeline.stop();

                ball.setCenterX(Team1Player.midfielder2.getCenterX());
                ball.setCenterY(Team1Player.midfielder2.getCenterY() -
                        (Team1Player.midfielder2.getRadius() + ball.getRadius()));
            }
            else {

                RotatingBar2.timeline.play();
                RotatingBar1.timeline.stop();

                ball.setCenterX(Team2Player.midfielder1.getCenterX());
                ball.setCenterY(Team2Player.midfielder1.getCenterY() +
                        (Team2Player.midfielder1.getRadius() + ball.getRadius()));
            }
        });

        passButton.setOnMouseClicked(event -> {

            GoalText.goalText.setText("");

            if(isTeam1){

                Point2D barpoint1 = RotatingBar1.bar.localToParent(RotatingBar1.bar.getEndX(),RotatingBar1.bar.getEndY());

                RotatingBar1.timeline.stop();
                BallMovement.setX((int) (barpoint1.getX()-RotatingBar1.bar.getStartX()));
                BallMovement.setY((int) (barpoint1.getY()-RotatingBar1.bar.getStartY()));
            }

            else if (!isTeam1){

                Point2D barpoint2 = RotatingBar2.bar.localToParent(RotatingBar2.bar.getEndX(),RotatingBar2.bar.getEndY());

                RotatingBar2.timeline.stop();
                BallMovement.setX((int) (barpoint2.getX()-RotatingBar2.bar.getStartX()));
                BallMovement.setY((int) (barpoint2.getY()-RotatingBar2.bar.getStartY()));
            }

            Timeline timeline = new Timeline();

            KeyFrame keyFrame = new KeyFrame(Duration.millis(30), new EventHandler<ActionEvent>() {


                @Override
                public void handle(ActionEvent event) {

                    ball.setCenterX(ball.getCenterX() + BallMovement.getX());
                    ball.setCenterY(ball.getCenterY() + BallMovement.getY());

                    if (goalTeam1(ball)){

                        Scoreline.setGoal2(Scoreline.getGoal2()+1);
                        timeline.stop();
                        GoalText.goalText.setText("Goooal !!! ");
                        ball.setCenterX(GamePage.ballStartX);
                        ball.setCenterY(GamePage.ballStartY);
                        RotatingBar1.reset();
                        isTeam1 = true;
                    }

                    else if (goalTeam2(ball)){

                        Scoreline.setGoal1(Scoreline.getGoal1()+1);
                        timeline.stop();
                        GoalText.goalText.setText("Goooal !!! ");
                        ball.setCenterX(GamePage.ballStartX);
                        ball.setCenterY(GamePage.ballStartY);
                        RotatingBar1.reset();
                        isTeam1 = false;
                    }

                    else if (checkBoundaryX(ball))
                        BallMovement.setX(-(BallMovement.getX()));
                    else if (checkBoundaryY(ball))
                        BallMovement.setY(-(BallMovement.getY()));

                    if (checkCollision(ball, Team1Player.goalKeeper)){

                        ball.setCenterX(Team1Player.goalKeeper.getCenterX() + Team1Player.goalKeeper.getRadius() + ball.getRadius());
                        ball.setCenterY(Team1Player.goalKeeper.getCenterY());
                        BallMovement.setX(Math.abs(BallMovement.getX()));
                        BallMovement.setY(Math.abs(BallMovement.getY()));
                        timeline.stop();
                        RotatingBar1.reset();
                        isTeam1 = true;
                    }

                    else if (checkCollision(ball, Team1Player.defender1)){

                        ball.setCenterX(Team1Player.defender1.getCenterX() + Team1Player.defender1.getRadius() + ball.getRadius());
                        ball.setCenterY(Team1Player.defender1.getCenterY());
                        BallMovement.setX(Math.abs(BallMovement.getX()));
                        BallMovement.setY(Math.abs(BallMovement.getY()));
                        timeline.stop();
                        RotatingBar1.reset();
                        isTeam1 = true;
                    }

                    else if (checkCollision(ball, Team1Player.defender2)){

                        ball.setCenterX(Team1Player.defender2.getCenterX() + Team1Player.defender2.getRadius() + ball.getRadius());
                        ball.setCenterY(Team1Player.defender2.getCenterY());
                        BallMovement.setX(Math.abs(BallMovement.getX()));
                        BallMovement.setY(Math.abs(BallMovement.getY()));
                        timeline.stop();
                        RotatingBar1.reset();
                        isTeam1 = true;
                    }

                    else if (checkCollision(ball, Team1Player.defender3)){

                        ball.setCenterX(Team1Player.defender3.getCenterX() + Team1Player.defender3.getRadius() + ball.getRadius());
                        ball.setCenterY(Team1Player.defender3.getCenterY());
                        BallMovement.setX(Math.abs(BallMovement.getX()));
                        BallMovement.setY(Math.abs(BallMovement.getY()));
                        timeline.stop();
                        RotatingBar1.reset();
                        isTeam1 = true;
                    }

                    else if (checkCollision(ball, Team1Player.midfielder1)){

                        ball.setCenterX(Team1Player.midfielder1.getCenterX() + Team1Player.midfielder1.getRadius() + ball.getRadius());
                        ball.setCenterY(Team1Player.midfielder1.getCenterY());
                        BallMovement.setX(Math.abs(BallMovement.getX()));
                        BallMovement.setY(Math.abs(BallMovement.getY()));
                        timeline.stop();
                        RotatingBar1.reset();
                        isTeam1 = true;
                    }

                    else if (checkCollision(ball, Team1Player.midfielder2)){

                        ball.setCenterX(Team1Player.midfielder2.getCenterX() + Team1Player.midfielder2.getRadius() + ball.getRadius());
                        ball.setCenterY(Team1Player.midfielder2.getCenterY());
                        BallMovement.setX(Math.abs(BallMovement.getX()));
                        BallMovement.setY(Math.abs(BallMovement.getY()));
                        timeline.stop();
                        RotatingBar1.reset();
                        isTeam1 = true;
                    }

                    else if (checkCollision(ball, Team1Player.striker)){

                        ball.setCenterX(Team1Player.striker.getCenterX() + Team1Player.striker.getRadius() + ball.getRadius());
                        ball.setCenterY(Team1Player.striker.getCenterY());
                        BallMovement.setX(Math.abs(BallMovement.getX()));
                        BallMovement.setY(Math.abs(BallMovement.getY()));
                        timeline.stop();
                        RotatingBar1.reset();
                        isTeam1 = true;
                    }

                    if (checkCollision(ball, Team2Player.goalKeeper)){

                        ball.setCenterX(Team2Player.goalKeeper.getCenterX() - Team2Player.goalKeeper.getRadius() - ball.getRadius());
                        ball.setCenterY(Team2Player.goalKeeper.getCenterY());
                        BallMovement.setX(-(Math.abs(BallMovement.getX())));
                        BallMovement.setY(Math.abs(BallMovement.getY()));
                        timeline.stop();
                        RotatingBar2.reset();
                        isTeam1 = false;
                    }

                    else if (checkCollision(ball, Team2Player.defender1)){

                        ball.setCenterX(Team2Player.defender1.getCenterX() - Team2Player.defender1.getRadius() - ball.getRadius());
                        ball.setCenterY(Team2Player.defender1.getCenterY());
                        BallMovement.setX(-(Math.abs(BallMovement.getX())));
                        BallMovement.setY(Math.abs(BallMovement.getY()));
                        timeline.stop();
                        RotatingBar2.reset();
                        isTeam1 = false;
                    }

                    else if (checkCollision(ball, Team2Player.defender2)){

                        ball.setCenterX(Team2Player.defender2.getCenterX() - Team2Player.defender2.getRadius() - ball.getRadius());
                        ball.setCenterY(Team2Player.defender2.getCenterY());
                        BallMovement.setX(-(Math.abs(BallMovement.getX())));
                        BallMovement.setY(Math.abs(BallMovement.getY()));
                        timeline.stop();
                        RotatingBar2.reset();
                        isTeam1 = false;
                    }

                    else if (checkCollision(ball, Team2Player.defender3)){

                        ball.setCenterX(Team2Player.defender3.getCenterX() - Team2Player.defender3.getRadius() - ball.getRadius());
                        ball.setCenterY(Team2Player.defender3.getCenterY());
                        BallMovement.setX(-(Math.abs(BallMovement.getX())));
                        BallMovement.setY(Math.abs(BallMovement.getY()));
                        timeline.stop();
                        RotatingBar2.reset();
                        isTeam1 = false;
                    }

                    else if (checkCollision(ball, Team2Player.midfielder1)){

                        ball.setCenterX(Team2Player.midfielder1.getCenterX() - Team2Player.midfielder1.getRadius() - ball.getRadius());
                        ball.setCenterY(Team2Player.midfielder1.getCenterY());
                        BallMovement.setX(-(Math.abs(BallMovement.getX())));
                        BallMovement.setY(Math.abs(BallMovement.getY()));
                        timeline.stop();
                        RotatingBar2.reset();
                        isTeam1 = false;
                    }

                    else if (checkCollision(ball, Team2Player.midfielder2)){

                        ball.setCenterX(Team2Player.midfielder2.getCenterX() - Team2Player.midfielder2.getRadius() - ball.getRadius());
                        ball.setCenterY(Team2Player.midfielder2.getCenterY());
                        BallMovement.setX(-(Math.abs(BallMovement.getX())));
                        BallMovement.setY(Math.abs(BallMovement.getY()));
                        timeline.stop();
                        RotatingBar2.reset();
                        isTeam1 = false;
                    }

                    else if (checkCollision(ball, Team2Player.striker)){

                        ball.setCenterX(Team2Player.striker.getCenterX() - Team2Player.striker.getRadius() - ball.getRadius());
                        ball.setCenterY(Team2Player.striker.getCenterY());
                        BallMovement.setX(-(Math.abs(BallMovement.getX())));
                        BallMovement.setY(Math.abs(BallMovement.getY()));
                        timeline.stop();
                        RotatingBar2.reset();
                        isTeam1 = false;
                    }
                }
            });

            timeline.getKeyFrames().add(keyFrame);
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        });

        GamePage.getPane().getChildren().addAll(ball, startButton, passButton, homeButton);

    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public static Button getHomeButton() {
        return homeButton;
    }

    boolean checkCollision (Circle circle1, Circle circle2){

        if ( (Math.sqrt((Math.pow((circle1.getCenterX()-circle2.getCenterX()),2) +
                (Math.pow((circle1.getCenterY()-circle2.getCenterY()),2))))) <= (circle1.getRadius()+circle2.getRadius()))
            return true;
        else return false;
    }

    boolean checkBoundaryX (Circle circle){

        if(circle.getCenterX() <= circle.getRadius() + 59 ||
                circle.getCenterX() >= Game.width - 58 - circle.getRadius())
            return true;
        else return false;
    }

    boolean checkBoundaryY (Circle circle){

        if(circle.getCenterY() <= circle.getRadius() + 4  ||
                circle.getCenterY() >= 600 - 4 - circle.getRadius())
            return true;
        else return false;
    }

    boolean goalTeam1 (Circle circle){

        if (circle.getCenterX() <= 59 + circle.getRadius() && circle.getCenterY() >= 232 - circle.getRadius()
                && circle.getCenterY() <= 232 + 134 + circle.getRadius())
            return true;
        else return false;
    }

    boolean goalTeam2 (Circle circle){

        if (circle.getCenterX() >= 1100 - 58 - circle.getRadius() && circle.getCenterY() >= 232 - circle.getRadius()
                && circle.getCenterY() <= 232 + 134 + circle.getRadius())
            return true;
        else return false;
    }
}
