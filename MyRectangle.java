package cartoon;

import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 * MyRectangle is a class created to ease the handling of
 * rectangle objects. It instantiates rectangles and provides methods
 * that can manipulate.
 */
public class MyRectangle {

    private final Rectangle rect;
    private final Color ogColor;

    /**
     * This is the MyRectangle constructor. It instantiates the circle and
     * adds it to the background pane.
     */
    public MyRectangle(Pane myPane,
                       double xLocation,
                       double yLocation,
                       double rectWidth,
                       double recHeight,
                       Color color){
        this.rect = new Rectangle(
                xLocation,
                yLocation,
                rectWidth,
                recHeight);
        this.rect.setFill(color);
        myPane.getChildren().add(this.rect);
        this.ogColor = color;
    }

    /**
     * This is a getter method that returns the MyRectangle's Rectangle.
     */
    public Rectangle getRect(){
        return this.rect;
    }

    /**
     * This is a getter method that returns the Rectangle's original color.
     */
    public Color getOGColor(){
        return this.ogColor;
    }

    /**
     * This is a setter method that rotates the rectangle.
     */
    public void rotate(int degrees){
        this.rect.setRotate(degrees);
    }
}
