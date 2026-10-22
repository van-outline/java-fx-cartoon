package cartoon;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * This is my top-level class, Cartoon. This class instantiates other important classes
 * while also being an important place for the logic to occur that will be used throughout
 * the entire program. For example, a key variable time, is instantiated here and modified
 * to assist in other instantiated classes such as Sky and its objects.
 */
public class Cartoon {

    public double time;
    private final PaneOrganizer organizer;
    private final City city;
    private final Sky sky;
    private int t;
    private final double [] rgb;

    /**
     * This is the other constructor. This is where most labels and panes are
     * instantiated and this is also where many class objects are created. This
     * is also where time is controlled through a KeyEvent lambda expression.
     */
    public Cartoon (PaneOrganizer organizer) {
        this.rgb = new double [Constants.RGB_LENGTH];
        this.organizer = organizer;
        this.organizer.createBackgroundPane();
        this.sky = new Sky(organizer);
        this.city = new City(organizer);
        TrainStation trainStation = new TrainStation(organizer);
        this.organizer.createButtonPane();
        new Mover(trainStation, this.organizer, this);
    }

    /**
     * This method progresses the day. It is called when < and > are pressed.
     * It calls the key two object classes to progress, sky and city passing
     * the very important time variable. It also changes the color of the background
     * to simulate the changing day.
     */
    public void progressDay(){
        this.sky.progressSky(this.time);
        this.organizer.changeBorderPaneColor(this.changeDayBasedColor(Constants.skyRGB));
        this.city.progressCity(this.time);
    }

    /**
     * This method changes the sky's color using time. It checks what time it is (which
     * is determined by how much the < and > keys have been pressed). It then calls method
     * changeRGB which uses a linearization formula to smoothly shift the sky's color as
     * the day progresses. This is all controlled by a 3D array, the stores the initial and final
     * values for each RGB channel within the 8 sections of the day (midnight, dawn, midday, etc.)
     * This method then outputs the result of the equation into a 1D array that stores the
     * calculated RGB at a give time in the day.
     */
    public double [] changeDayBasedColor(int[][][] rgbArray){
        this.t = ((int)this.time) % Constants.TOTAL_DAY_LENGTH;
        if (this.t < 0){
            this.t += Constants.TOTAL_DAY_LENGTH;
        }
        if (this.t < Constants.DAY_SECTION_LENGTH * Constants.EARLY_MORNING_SECTION){
            this.changeRGB(rgbArray, Constants.EARLY_MORNING_SECTION - 1);
        }
        else if (this.t < Constants.DAY_SECTION_LENGTH * Constants.DAWN_SECTION){
            this.changeRGB(rgbArray, Constants.DAWN_SECTION - 1);
        }
        else if (this.t < Constants.DAY_SECTION_LENGTH * Constants.LATE_MORNING_SECTION){
            this.changeRGB(rgbArray, Constants.LATE_MORNING_SECTION - 1);
        }
        else if (this.t < Constants.DAY_SECTION_LENGTH * Constants.NOON_SECTION){
            this.changeRGB(rgbArray, Constants.NOON_SECTION - 1);
        }
        else if (this.t < Constants.DAY_SECTION_LENGTH * Constants.AFTERNOON_SECTION){
            this.changeRGB(rgbArray, Constants.AFTERNOON_SECTION - 1);
        }
        else if (this.t < Constants.DAY_SECTION_LENGTH * Constants.DUSK_SECTION){
            this.changeRGB(rgbArray, Constants.DUSK_SECTION - 1);
        }
        else if (this.t < Constants.DAY_SECTION_LENGTH * Constants.LATE_EVENING_SECTION){
            this.changeRGB(rgbArray, Constants.LATE_EVENING_SECTION - 1);
        }
        else{
            this.changeRGB(rgbArray, Constants.MIDNIGHT_SECTION - 1);
        }
        return this.rgb;
    }


    /**
     * ChangeRGB uses a simple linear formula to smoothly output a value for each RGB
     * channel that corresponds with sky's color at that time of day.
     */
    public void changeRGB (int[][][] rgbArray, int part){
        for (int i = 0; i < Constants.RGB_LENGTH; i++){
            this.rgb[i] = rgbArray[part][i][0]+((rgbArray[part][i][1] -
                    rgbArray[part][i][0])/(double)Constants.DAY_SECTION_LENGTH) *
                    (this.t -(double)Constants.DAY_SECTION_LENGTH*part);
        }
    }
}
