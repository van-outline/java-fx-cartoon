package cartoon;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

/**
 * This is the mover class. It is responsible for moving the trains using
 * timelines.
 */
public class Mover{
    private final TrainStation trainStation;
    private final PaneOrganizer organizer;
    private Cartoon cartoon;

    /**
     * This is the Mover constructor that sets up the main timeline
     * using setUpTimeline.
     */
    public Mover(TrainStation trainStation, PaneOrganizer organizer, Cartoon cartoon){
        this.cartoon = cartoon;
        this.trainStation = trainStation;
        this.organizer = organizer;
        this.setUpTimeline();
        this.organizer.getBorderPane().setFocusTraversable(true);
        this.organizer.getBorderPane().setOnKeyPressed((KeyEvent e) -> this.changeDaytime(e));
    }
    /**
     * Upon pressing < or >, this method is called due to the lambda expression
     * in the constructor. This is the cental controller of the day changing
     * mechanic. If < is pressed, the day moves backwards, and vice versa with the
     * > key.
     */
    public void changeDaytime(KeyEvent e){
        KeyCode keyPressed = e.getCode();
        switch (keyPressed) {
            case LEFT:
                this.cartoon.time --;
                this.cartoon.progressDay();
                break;
            case RIGHT:
                this.cartoon.time ++;
                this.cartoon.progressDay();
                break;
            default:
                break;
        }
        e.consume();
    }

    /**
     * This is the setUpTimeline method. By generating a random arrival time
     * using Math.random, a lambda expression calls method callTrain using that
     * arrival time. the method also calls trainTimes, which updates the label.
     */
    private void setUpTimeline(){
        double trainTime = Constants.TRAIN_TIME_CAP *
                Math.random() + Constants.TRAIN_TIME_INITIAL;
        int[] timeLeft = {(int) trainTime};
        this.organizer.getLabel().setText("Train Arriving in " + timeLeft[0]);
        KeyFrame kf = new KeyFrame(
                Duration.seconds(1),
                (ActionEvent e) -> {
                    timeLeft[0]--;
                    this.organizer.getLabel().setText("Train Arriving in " + timeLeft[0]);
                    if (timeLeft[0] <= 0){
                        this.trainStation.callTrain();
                    }
                });
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(timeLeft[0]);
        timeline.setOnFinished(e -> this.setUpTimeline());
        timeline.play();
    }
}
