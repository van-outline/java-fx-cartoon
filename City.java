package cartoon;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import static javafx.scene.paint.Color.BLACK;

/**
 * This is the city class, it is in charge of generating a random city with windows,
 * as well as changing the city's colors in correspondence with the day's time.
 */
public class City {
    private int buildingPos;
    private Color windowColor = null;
    private final PaneOrganizer organizer;
    private int randBuildingWidth;
    private int randHeight;
    private final ArrayList<ArrayList<ArrayList<MyRectangle>>> buildingData;

    /**
     * This is the city's constructor. It creates the city with the createCity method.
     */
    public City(PaneOrganizer organizer){
        this.organizer = organizer;
        this.buildingData = new ArrayList<>();
        this.createCity();
    }

    /**
     * This is the progressCity method. It changes the city's colors based on the time.
     * Because the city is layered, the idea was to make the back layers change more
     * rapidly than the front ones. This is done with the color. Interpolate method which
     * mixes the colors of the buildings with white, making them lighter or darker.
     */
    public void progressCity(double time){
        Color color;
        int t = ((int)time) % Constants.TOTAL_DAY_LENGTH;
        for (int i = 0; i < this.buildingData.size(); i++){
            ArrayList<ArrayList<MyRectangle>> bigRow = this.buildingData.get(i);
            for (ArrayList<MyRectangle> smallRow : bigRow) {
                int layers = (int) (Constants.LAYER_WEIGHT * ((this.buildingData.size() - i) /
                        (double) this.buildingData.size()));
                for (MyRectangle building : smallRow) {
                    color = building.getOGColor();
                    double brightness;
                    if (t < Constants.QUARTER_DAY_LENGTH) {
                        brightness = (t / (double)Constants.QUARTER_DAY_LENGTH) * layers;
                    } else if (t < Constants.HALF_DAY_LENGTH) {
                        brightness = ((Constants.HALF_DAY_LENGTH - t) /
                                (double)Constants.QUARTER_DAY_LENGTH) * layers;
                    } else if (t < Constants.THREE_QUARTER_DAY_LENGTH) {
                        brightness = ((t - Constants.HALF_DAY_LENGTH) /
                                (double)Constants.QUARTER_DAY_LENGTH) * layers;
                    } else {
                        brightness = ((Constants.TOTAL_DAY_LENGTH - t) /
                                (double)Constants.QUARTER_DAY_LENGTH) * layers;
                    }
                    double factor = brightness / Constants.BRIGHTNESS_STRENGTH;
                    if (factor > 1) {
                        factor = 1;
                    }
                    Color blender;
                    blender = Color.WHITE;
                    Color finalColor = color.interpolate(blender, factor);
                    building.getRect().setFill(finalColor);
                }
            }
        }
    }

    /**
     * This is the createCity method. Using createBuildings, it creates random
     * rectangular buildings within three rows of smaller varying rows. Because of
     * these many rows, a 3D Arraylist was used. This method adds each building to
     * the appropriate layer of this Arraylist, so it could be accessed later.
     */
    private void createCity() {
        ArrayList<ArrayList<MyRectangle>> backRows = new ArrayList<>();
        for (int i = 0; i < Constants.BIG_ROW_AMOUNT; i++) {
            ArrayList<MyRectangle> row = new ArrayList<>();
            this.createBuildings(
                    Constants.BACK_BUILDING_LENGTH,
                    i*Constants.BACK_BUILDING_DARKNESS_LEVEL,
                    Constants.BACK_BUILDING_WIDTH_LOWEST+i*Constants.BACK_BUILDING_WIDTH_RANGE,
                    Constants.BACK_BUILDING_HEIGHT_LOWEST+Constants.BACK_BUILDING_HEIGHT_RANGE*i,
                    0,
                    false,
                    row);
            backRows.add(row);
        }
        this.buildingData.add(backRows);
        ArrayList<ArrayList<MyRectangle>> middleRows = new ArrayList<>();
        for (int i = 0; i < Constants.BIG_ROW_AMOUNT; i++) {
            ArrayList<MyRectangle> row = new ArrayList<>();
            this.createBuildings(
                    Constants.MIDDLE_BUILDING_LENGTH,
                    i*Constants.MIDDLE_BUILDING_DARKNESS_LEVEL,
                    Constants.MIDDLE_BUILDING_WIDTH_LOWEST+i*
                            Constants.MIDDLE_BUILDING_WIDTH_RANGE,
                    Constants.MIDDLE_BUILDING_HEIGHT_LOWEST+i*
                            Constants.MIDDLE_BUILDING_HEIGHT_RANGE,
                    Constants.MIDDLE_BUILDING_WINDOW_FACTOR*i+
                            Constants.MIDDLE_BUILDING_WINDOW_FACTOR,
                    true,
                    row);
            middleRows.add(row);
        }
        this.buildingData.add(middleRows);
        ArrayList<ArrayList<MyRectangle>> frontRows = new ArrayList<>();
        ArrayList<MyRectangle> frontRow = new ArrayList<>();
        this.createBuildings(
                Constants.FRONT_BUILDING_LENGTH,
                Constants.FRONT_BUILDING_DARKNESS_LEVEL,
                Constants.FRONT_BUILDING_WIDTH,
                Constants.FRONT_BUILDING_HEIGHT,
                Constants.FRONT_BUILDING_WINDOW_FACTOR,
                true,
                frontRow);
        frontRows.add(frontRow);
        this.buildingData.add(frontRows);
    }

    /**
     * This method creates each building using MyRectangle. Each building gets random
     * properties such as random, heights, widths, window amounts, and colors. Some
     * buildings closer to the foreground get windows through the createWindows
     * method.
     */
    private void createBuildings(int length,
                                 int darkLevel,
                                 int buildingWidth,
                                 int buildingHeight,
                                 int windowDim,
                                 boolean hasWindow,
                                 ArrayList<MyRectangle> buildingRow) {
        for (int i = 0; i < length; i++) {
            int randColor = (int) (Math.random() * darkLevel +
                    Constants.BUILDING_DARKNESS_FACTOR);
            this.randBuildingWidth = (int) (Math.random() * buildingWidth + buildingWidth);
            Color buildingColor = Color.rgb(randColor, randColor, randColor);
            this.randHeight = (int) (Math.random() * Constants.BUILDING_HEIGHT_RANDOMIZER)
                    + buildingHeight;
            MyRectangle rect = new MyRectangle(
                    this.organizer.getBorderPane(),
                    this.buildingPos, this.randHeight,
                    this.randBuildingWidth, Constants.DEFAULT_BUILDING_HEIGHT,
                    buildingColor);
            buildingRow.add(rect);
            if (hasWindow){
                this.createWindows(windowDim);
            }
            this.buildingPos = this.buildingPos + this.randBuildingWidth;
        }
        this.buildingPos = 0;
    }

    /**
     * This is the createWindows method. Similarly to CreateBuildings, this method
     * also uses for loops to create many windows randomized to be based on
     * its host buildings dimensions. Some Windows are also randomized to be
     * on or off.
     */
    private void createWindows(int windowDim) {
        int windowAmount = (int) (Math.random() * Constants.WINDOW_AMOUNT_RANGE +
                Constants.WINDOW_AMOUNT_LOWEST);
        double windowSpacing = (double) this.randBuildingWidth/windowAmount;
        for (int k = 0; k < Constants.WINDOW_CAP; k++) {
            for (int j = 0; j < windowAmount; j++) {
                switch ((int) (Math.random() * Constants.LIGHT_STATUS)) {
                    case 0:
                        this.windowColor = Color.rgb(windowDim, windowDim, windowDim);
                        break;
                    case 1:
                        this.windowColor = BLACK;
                        break;
                }
                double windowPosY = this.randHeight + windowSpacing /
                        Constants.WINDOW_Y_OFFSET + windowSpacing * k;
                double windowPosX = windowSpacing /
                        Constants.WINDOW_X_OFFSET + windowSpacing * j + this.buildingPos;
                new MyRectangle(
                        this.organizer.getBorderPane(),
                        windowPosX, windowPosY,
                        windowSpacing/Constants.WINDOW_WIDTH,
                        windowSpacing/Constants.WINDOW_HEIGHT,
                        this.windowColor);
            }
        }
    }
}

