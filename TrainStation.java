package cartoon;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * This is the TrainStation class. It creates the stationary
 * train station through many MyRectangle calls. It also creates the train object.
 */
public class TrainStation {

    private final PaneOrganizer organizer;
    private final Train train;
    private Timeline trainTimeline;

    /**
     * The trainstation constructor instantiates the train
     * and creates the station through a method call.
     */
    public TrainStation (PaneOrganizer organizer) {
        this.organizer = organizer;
        this.createStation();
        this.train = new Train(this.organizer);
    }

    /**
     * This method uses MyRectangle and methods within that class
     * to instantiates several Rectangles. It rotates and aligns
     * these rectangles to make a train Station.
     */
    public void createStation(){
        int rotation = 1;
        int pass = 1;
        for (int k = 0; k < Constants.ALL_ROTATED_RECT_AMOUNT; k++){
            for (int i = 0; i < Constants.ROTATED_RECT_AMOUNT; i++){
                if (i % Constants.ALL_ROTATED_RECT_AMOUNT == 0){
                    rotation = 1;
                }
                else{
                    rotation = -1;
                }
                MyRectangle rect = new MyRectangle(
                        this.organizer.getBorderPane(),
                        Constants.HALF_ROTATED_RECT_X_LENGTH +
                                i * Constants.ROTATED_RECT_X_LENGTH -
                                Constants.ROTATED_RECT_X_LENGTH,
                        Constants.ROTATED_RECT_Y_POS,
                        Constants.ROTATED_RECT_WIDTH,
                        Constants.ROTATED_RECT_HEIGHT,
                        Constants.STATION_COLOR);
                rect.rotate(Constants.ROTATED_RECT_ROTATION * rotation * pass);
            }
            pass = -1;
        }
        this.createRect(
                0,
                Constants.TOP_RECT_Y_POS,
                Constants.TOP_BOTTOM_RECT_WIDTH,
                Constants.TOP_BOTTOM_RECT_HEIGHT);
        this.createRect(
                0,
                Constants.BOTTOM_RECT_Y_POS,
                Constants.TOP_BOTTOM_RECT_WIDTH,
                Constants.TOP_BOTTOM_RECT_HEIGHT);
        for (int i = 0; i < Constants.BEAM_RECT_AMOUNT; i++){
            this.createRect(
                    Constants.BEAM_RECT_X_POS*i,
                    Constants.BEAM_RECT_Y_POS,
                    Constants.BEAM_RECT_WIDTH,
                    Constants.BEAM_RECT_HEIGHT);
        }
    }

    /**
     * This is method to simplify the process of creating MyRectangles.
     */
    public void createRect(double x, double y, double w, double h){
        new MyRectangle(
                this.organizer.getBorderPane(),
                x,
                y,
                w,
                h,
                Constants.STATION_COLOR);
    }

    /**
     * This method uses a timeline to call the train. This method is called
     * by the mover class and this sub-timeline is in charge of how fast the
     * train moves across the screen as well as pushing it back to the start
     * when the train is off-screen.
     */
    public void callTrain() {
        if (this.trainTimeline != null){
            this.trainTimeline.stop();
        }
        this.train.setTrain();
        this.trainTimeline = new Timeline(
                new KeyFrame(Duration.seconds(Constants.TRAIN_TIMELINE_DURATION),
                        e -> this.train.moveTrain(Constants.TRAIN_X_CHANGE)));
        this.trainTimeline.setCycleCount(Animation.INDEFINITE);
        this.trainTimeline.play();
    }
}
