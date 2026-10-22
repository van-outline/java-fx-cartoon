package cartoon;


import com.sun.org.apache.bcel.internal.Const;
import javafx.scene.paint.Color;

/**
 * This is the moon class that is responsible for all celestial objects in
 * the sky (including stars and sun).
 */
public class Moon{
    private final MyCircle moon;
    private final double shift;
    private final int x;
    private final int y;

    /**
     * This is the moon constructor that instantiates every newly created moon.
     */
    public Moon (
            double moonLocX,
            double moonLocY,
            int radius,
            PaneOrganizer organizer,
            double shift,
            Color color) {
        this.shift = shift;
        this.moon = new MyCircle(organizer.getBorderPane(), moonLocX, moonLocY, radius, color);
        this.x = (int)moonLocX;
        this.y = (int)moonLocY;
    }

    /**
     * This method progresses the moon when it is called in higher classes
     * due to arrowkey presses. Using trigonometry, the moon shifts into and from
     * the horizon.
     */
    public void progressMoon(double time){
        int radDist = (int)Math.sqrt(Math.pow(Constants.SCREEN_WIDTH_HALF -
                this.x, Constants.POWER)
                + Math.pow(Constants.SCREEN_LENGTH_FULL - this.y, Constants.POWER));
        double radians = -time * Constants.RADIANS_CONVERT;
        double xShift = (radDist*Math.cos(radians + Constants.QUARTER + this.shift) +
                Constants.SCREEN_WIDTH_HALF);
        double yShift = (-radDist*Math.sin(radians + Constants.QUARTER + this.shift) +
                Constants.SCREEN_LENGTH_FULL);
        this.moon.getCircle().setCenterX(xShift);
        this.moon.getCircle().setCenterY(yShift);
    }

    /**
     * This method fades the stars out and in of the scene using get and set Opacity.
     */
    public void fadeOut(double time) {
        int t = ((int)time) % Constants.TOTAL_DAY_LENGTH;
        System.out.println(t);
        if (t < 0){
            t += Constants.TOTAL_DAY_LENGTH;
        }
        if (t < Constants.QUARTER_DAY_LENGTH){
            this.moon.getCircle().setOpacity(1 -
                    (1/(double)Constants.QUARTER_DAY_LENGTH)*t);
        }
        else if (t > Constants.THREE_QUARTER_DAY_LENGTH){
            this.moon.getCircle().setOpacity(0 +
                    (1/(double)Constants.QUARTER_DAY_LENGTH)*t);
        }
    }
}
