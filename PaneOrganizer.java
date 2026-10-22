package cartoon;


import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * This is the PaneOrganizer class. It extends cartoon and is in charge of
 * the main graphical elements of the cartoon. It sets up panes, buttons
 * and labels using various Javafx objects.
 */
public class PaneOrganizer {

    private final BorderPane root;
    private BorderPane borderPane;
    private Label trainLabel;

    /**
     * This is the constructor, it instantiates the maine background pane.
     */
    public PaneOrganizer(){
        this.root = new BorderPane();
    }

    /**
     * A simple getter that returns the main root node.
     */
    public BorderPane getRoot(){
        return this.root;
    }

    /**
     * This method creates the background pane that most objects in the scene
     * are on.
     */
    public void createBackgroundPane(){
        this.borderPane = new BorderPane();
        this.borderPane.setPrefSize(Constants.BACKGROUND_PANE_WIDTH,
                Constants.BACKGROUND_PANE_HEIGHT);
        this.root.setCenter(this.borderPane);
        this.borderPane.setStyle(Constants.BACKGROUND_PANE_COLOR);
    }

    /**
     * This method changes the color of the background pane using a
     * 1D array. This 1D array is created in the cartoon class and
     * passes on its values to this method everytime the moon moves.
     * Using a trick that converts rgb values into hex codes, it changes
     * the style of the background pane.
     */
    public void changeBorderPaneColor(double rgb []){
        //Converts Hex into RGB
        String color = String.format("#%02x%02x%02x", (int)rgb[0], (int)rgb[1], (int)rgb[2]);
        this.borderPane.setStyle("-fx-background-color: " + color + ";");
    }

    /**
     * Getter that returns the background borderpane.
     */
    public BorderPane getBorderPane(){
        return this.borderPane;
    }

    /**
     * Getter that returns the train arrival time label.
     */
    public Label getLabel(){
        return this.trainLabel;
    }

    /**
     * This method creates the other important pane in the scene.
     * The button pane is at the bottom of the screen and contains a quit button
     * and two labels. One label is updated through the timeline to show when
     * the next train is arriving and the other label gives directions to move
     * the moon.
     */
    public void createButtonPane(){
        HBox buttonPane = new HBox(); //This instantiates the button pane
        buttonPane.setPrefSize(Constants.BUTTON_PANE_WIDTH,
                Constants.BUTTON_PANE_HEIGHT); //This sets its size
        buttonPane.setStyle(Constants.BUTTON_PANE_COLOR); //This sets its color
        this.root.setBottom(buttonPane);
        Button button = new Button("Quit");
        button.setAlignment(Pos.CENTER);//This instantiates the button
        buttonPane.getChildren().add(button);
        button.setOnAction((ActionEvent e) -> System.exit(0));
        buttonPane.setFocusTraversable(false);
        button.setFocusTraversable(false);
        this.trainLabel = new Label("Train Arriving in");
        this.formatLabel(
                this.trainLabel,
                Constants.TRAIN_LABEL_SCALE,
                Constants.TRAIN_LABEL_X_POS,
                Constants.TRAIN_LABEL_Y_POS);
        buttonPane.getChildren().add(this.trainLabel);
        Label directions = new Label("Use < and > to make the day go by!");
        this.formatLabel(
                directions,
                Constants.DIRECTIONS_LABEL_SCALE,
                Constants.DIRECTIONS_LABEL_X_POS,
                Constants.DIRECTIONS_LABEL_Y_POS);
        buttonPane.getChildren().add(directions);
    }

    /**
     * A method created to ease the creation of multiple labels,
     * takes in a label and changes its scale and xy position.
     */
    public void formatLabel(Label label, double scale, int x, int y){
        label.setScaleX(scale);
        label.setScaleY(scale);
        label.setScaleZ(scale);
        label.setTranslateX(x);
        label.setTranslateY(y);
    }
}