package PassTheFootball;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class RotatingBar2 {

    private int barX;
    private int barY;
    private int barWidth;
    private int barHeight;
    static Line bar;
    static Timeline timeline;
    static Rotate rotation;

    public RotatingBar2(int barX, int barY, int barWidth, int barHeight) {

        this.barX = barX;
        this.barY = barY;
        this.barWidth = barWidth;
        this.barHeight = barHeight;

        bar = new Line();
        bar.setStartX(barX);
        bar.setStartY(barY);
        bar.setEndX(barX);
        bar.setEndY(barY - barHeight);
        bar.setStrokeWidth(barWidth);
        bar.setStroke(Color.WHITE);

        Circle barBoundaryCircle = new Circle(barX, barY, barHeight + 5);
        barBoundaryCircle.setStrokeWidth(5);
        barBoundaryCircle.setFill(Color.BLACK);

        Rectangle barBoundaryRectangle = new Rectangle(barX + 5,barY - barHeight - 5,
                barHeight, 10 + (barHeight * 2));

        Shape barBoundary = Shape.subtract(barBoundaryCircle, barBoundaryRectangle);

        rotation = new Rotate(0, barX, barY);

        bar.getTransforms().add(rotation);

        timeline = new Timeline();

        KeyFrame keyFrame = new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

            double angleIncrement = -1;

            @Override
            public void handle(ActionEvent event) {
                rotation.setAngle(rotation.getAngle() + angleIncrement);
                if (rotation.getAngle() >= 0)
                    angleIncrement = -(Math.abs(angleIncrement));
                else if (rotation.getAngle() <= -180) {
                    angleIncrement = (Math.abs(angleIncrement));
                }
            }
        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);

        GamePage.getPane().getChildren().addAll(barBoundary, bar);
    }

    static void reset(){

        timeline.play();
        rotation.setAngle(0);
    }
}
