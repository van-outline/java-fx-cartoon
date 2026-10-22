package cartoon;

import javafx.scene.paint.Color;
import java.util.ArrayList;

/**
 * This is the Sky class, it is in charge of creating various Moon objects
 * as well as progressing them throughout the day using time.
 */
public class Sky {

    private final PaneOrganizer organizer;
    private final Moon moon;
    private final Moon sun;
    ArrayList<Moon> stars = new ArrayList<>();


    /**
     * This is the constructor that instantiates all 3 celestial classes, moon, sun, and stars.
     */
    public Sky (PaneOrganizer organizer){
        this.organizer = organizer;
        this.moon = new Moon(
                Constants.SCREEN_WIDTH_HALF,
                Constants.MOON_Y_POS,
                Constants.MOON_SUN_RADIUS,
                organizer,
                0,
                Constants.MOON_COLOR);
        this.sun = new Moon(
                Constants.SCREEN_WIDTH_HALF,
                Constants.SUN_Y_POS,
                Constants.MOON_SUN_RADIUS,
                organizer, Constants.SUN_SHIFT,
                Constants.SUN_COLOR);
        this.createStars();
    }

    /**
     * This method progresses each moon in accordance with time.
     */
    public void progressSky(double time){
        this.moon.progressMoon(time);
        this.sun.progressMoon(time);
        this.progressStars(time);
    }

    /**
     * Because stars is an arraylist, progressStars uses a for loop to access
     * every star in the array and progress them using methods.
     */
    public void progressStars(double time){
        for(int i = 0; i < Constants.STAR_AMOUNT; i++){
            this.stars.get(i).progressMoon(time);
            this.stars.get(i).fadeOut(time);
        }
    }

    /**
     * This method creates stars by instantiating many moon objects and putting them
     * into an arraylist.
     */
    public void createStars(){
        for(int i = 0; i < Constants.STAR_AMOUNT; i++){
            Moon star = new Moon(
                    Math.random()*Constants.STAR_X_POS,
                    Math.random()*Constants.STAR_Y_POS,
                    (int)(Math.random()*Constants.STAR_RADIUS),
                    this.organizer,
                    Math.random()*Constants.STAR_SHIFT,
                    Constants.STAR_COLOR);
            this.stars.add(star);
        }
        this.progressStars(1);
        this.progressStars(-1);
    }
}
