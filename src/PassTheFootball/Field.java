package PassTheFootball;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Field {

    private float fieldX = 0;
    private float fieldY = 0;
    private float fieldWidth = 200;
    private float fieldHeight = 500;

    public Field(float fieldX, float fieldY, float fieldWidth, float fieldHeight) {
        this.fieldX = fieldX;
        this.fieldY = fieldY;
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;

        Image fieldImage = null;
        try {
            fieldImage = new Image(new FileInputStream("C:\\Users\\mdati\\Downloads\\Pass The Football\\src\\Images\\Football Field.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Image grassImage = null;
        try {
            grassImage = new Image(new FileInputStream("C:\\Users\\mdati\\Downloads\\Pass The Football\\src\\Images\\Field Grass.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ImagePattern grassImagePattern = new ImagePattern(grassImage);

        ImageView field = new ImageView(fieldImage);

        field.setX(fieldX);
        field.setY(fieldY);
        field.setFitWidth(fieldWidth);
        field.setFitHeight(fieldHeight);

        Rectangle fieldRectangle = new Rectangle(0,0, fieldWidth, fieldHeight);
        fieldRectangle.setFill(grassImagePattern);

        GamePage.getPane().getChildren().addAll(fieldRectangle, field);

    }

    public float getFieldX() {
        return fieldX;
    }

    public void setFieldX(float fieldX) {
        this.fieldX = fieldX;
    }

    public float getFieldY() {
        return fieldY;
    }

    public void setFieldY(float fieldY) {
        this.fieldY = fieldY;
    }

    public float getFieldWidth() {
        return fieldWidth;
    }

    public void setFieldWidth(float fieldWidth) {
        this.fieldWidth = fieldWidth;
    }

    public float getFieldHeight() {
        return fieldHeight;
    }

    public void setFieldHeight(float fieldHeight) {
        this.fieldHeight = fieldHeight;
    }
}
