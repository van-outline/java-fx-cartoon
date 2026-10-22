package cartoon;

import javafx.scene.paint.Color;
import java.util.ArrayList;

/**
 * This is the TrainWagon class. Using many ArrayLists it
 * creates a system that moves the entire train across the screen.
 */
public class TrainWagon {

    private final MyRectangle wagon;
    private final ArrayList<MyRectangle> trainWindows;
    private final ArrayList<MyCircle> trainWheels;
    private final ArrayList<MyRectangle> trainConnectors;
    private final double wagonX;

    /**
     * The TrainWagon constructor creates every part of the train (wagons, windows, wheels)
     * and stores them in respective arraylists.
     */
    public TrainWagon(PaneOrganizer organizer, double x, double y) {
        this.wagonX = x;
        this.trainWindows = new ArrayList<>();
        this.trainWheels = new ArrayList<>();
        this.trainConnectors = new ArrayList<>();
        this.wagon = new MyRectangle(
                organizer.getBorderPane(),
                this.wagonX,
                y,
                Constants.WAGON_WIDTH,
                Constants.WAGON_HEIGHT,
                Constants.STATION_COLOR);

        for(int k = 0; k < Constants.WAGON_WINDOW_AMOUNT; k++){
            MyRectangle window = new MyRectangle(
                    organizer.getBorderPane(),
                    this.wagonX + Constants.WAGON_WINDOW_INITIAL_POS +
                            Constants.WAGON_WINDOW_INITIAL_OFFSET * k,
                    y + Constants.WAGON_WINDOW_INITIAL_POS,
                    Constants.WAGON_WINDOW_WIDTH,
                    Constants.WAGON_WINDOW_HEIGHT,
                    Constants.WAGON_WINDOW_COLOR);
            this.trainWindows.add(window);
        }

        for(int k = 0; k < Constants.WHEEL_AMOUNT; k++){
            MyCircle wheel = new MyCircle(
                    organizer.getBorderPane(),
                    this.wagonX + Constants.WHEEL_INITIAL_X_POS +
                            Constants.WHEEL_INITIAL_OFFSET * k,
                    y + Constants.WHEEL_INITIAL_Y_POS,
                    Constants.WHEEL_RADIUS,
                    Constants.WHEEL_COLOR);
            this.trainWheels.add(wheel);
        }
    }

    /**
     * Because there are one less connectors than there are wagons, a
     * seperate method was created to create connectors.
     */
    public void addConnectors(PaneOrganizer organizer){
        MyRectangle connectors = new MyRectangle(
                organizer.getBorderPane(),
                this.wagonX - Constants.CONNECTOR_OFFSET,
                Constants.CONNECTOR_Y_POS,
                Constants.CONNECTOR_WINDOW_WIDTH,
                Constants.CONNECTOR_WINDOW_HEIGHT,
                Constants.STATION_COLOR);
        this.trainConnectors.add(connectors);
    }

    /**
     * This method moves each part of the train by using many
     * for each loops to move each element within each Arraylist
     * along with an offset.
     */
    public void moveWagon(double x){
        this.wagon.getRect().setX(this.wagon.getRect().getX() + x);
        for(MyRectangle window : this.trainWindows){
            window.getRect().setX(window.getRect().getX() + x);
        }
        for(MyCircle wheel : this.trainWheels){
            wheel.getCircle().setCenterX(wheel.getCircle().getCenterX() + x);
        }
        for(MyRectangle window : this.trainConnectors){
            window.getRect().setX(window.getRect().getX() + x);
        }
    }

    /**
     * This is a getter that returns the given wagon's x position.
     */
    public  double getWagonX(){
        return this.wagon.getRect().getX();
    }

    public void setWagon() {
        this.wagon.getRect().setX(this.wagonX);
        for(int k = 0; k < Constants.WAGON_WINDOW_AMOUNT; k++){
            this.trainWindows.get(k).getRect().setX(this.wagonX +
                    Constants.WAGON_WINDOW_INITIAL_POS +
                    Constants.WAGON_WINDOW_INITIAL_OFFSET * k);
        }
        for(int k = 0; k < Constants.WHEEL_AMOUNT; k++){
            this.trainWheels.get(k).getCircle().setCenterX(this.wagonX +
                    Constants.WHEEL_INITIAL_X_POS +
                    Constants.WHEEL_INITIAL_OFFSET * k);
        }
        for(int k = 0; k < this.trainConnectors.size(); k++){
            this.trainConnectors.get(k).getRect().setX(this.wagonX -
                    Constants.CONNECTOR_OFFSET);
        }
    }
}
