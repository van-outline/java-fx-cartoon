package cartoon;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * MyCircle is a class created to ease the handling of
 * circle objects. It instantiates Circles and provides methods
 * that can manipulate.
 */
public class MyCircle {
    private final Circle circle;

    /**
     * This is the MyCircle constructor. It instantiates the circle and
     * adds it to the background pane.
     */
    public MyCircle(Pane myPane,
                    double xLocation,
                    double yLocation,
                    double radius,
                    Color color){
        this.circle = new Circle(
                xLocation,
                yLocation,
                radius,
                color);
        myPane.getChildren().add(this.circle);
    }

    /**
     * This is a getter method that returns the MyCircle's Circle.
     */
    public Circle getCircle(){
        return this.circle;
    }
}
