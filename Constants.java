package cartoon;

import javafx.scene.paint.Color;

public class Constants {

    public static final int RGB_LENGTH = 3;
    public static final int DAY_SECTION_LENGTH = 45;
    public static final int QUARTER_DAY_LENGTH = 90;
    public static final int HALF_DAY_LENGTH = 180;
    public static final int THREE_QUARTER_DAY_LENGTH = 270;
    public static final int TOTAL_DAY_LENGTH = 360;
    public static final int EARLY_MORNING_SECTION = 1;
    public static final int DAWN_SECTION = 2;
    public static final int LATE_MORNING_SECTION = 3;
    public static final int NOON_SECTION = 4;
    public static final int AFTERNOON_SECTION = 5;
    public static final int DUSK_SECTION = 6;
    public static final int LATE_EVENING_SECTION = 7;
    public static final int MIDNIGHT_SECTION = 8;
    public static final String BUTTON_PANE_COLOR = "-fx-background-color: #778899";
    public static final int BUTTON_PANE_WIDTH = 1920;
    public static final int BUTTON_PANE_HEIGHT = 50;
    public static final int BACKGROUND_PANE_WIDTH = 1920;
    public static final int BACKGROUND_PANE_HEIGHT = 1080;
    public static final String BACKGROUND_PANE_COLOR = "-fx-background-color: #1A1A40";
    public static final int[][][] skyRGB =  {
            { {26, 59},  {26, 67},  {64, 113} },
            { {59, 243}, {67, 144}, {113, 79} },
            { {243, 135},{144, 206},{79, 235} },
            { {135, 0},  {206, 150},{235, 255} },
            { {0, 115},  {150, 194},{255, 251} },
            { {115, 255},{194, 110},{251, 64} },
            { {255, 11}, {110, 19}, {64, 43} },
            { {11, 26},  {19, 26},  {43, 64} }};
    public static final int SCREEN_WIDTH_HALF = 960;
    public static final int SCREEN_LENGTH_FULL = 1080;
    public static final int POWER = 2;
    public static final double RADIANS_CONVERT = Math.PI/180;
    public static final double QUARTER = Math.PI/2;
    public static final int TRAIN_TIME_CAP = 5;
    public static final int TRAIN_TIME_INITIAL = 10;
    public static final int LAYER_WEIGHT = 10;
    public static final double BRIGHTNESS_STRENGTH = 30.0;
    public static final int BIG_ROW_AMOUNT = 3;
    public static final int BACK_BUILDING_LENGTH = 50;
    public static final int BACK_BUILDING_DARKNESS_LEVEL = 5;
    public static final int BACK_BUILDING_WIDTH_LOWEST = 20;
    public static final int BACK_BUILDING_WIDTH_RANGE = 5;
    public static final int BACK_BUILDING_HEIGHT_LOWEST = 250;
    public static final int BACK_BUILDING_HEIGHT_RANGE = 50;
    public static final int MIDDLE_BUILDING_LENGTH = 50;
    public static final int MIDDLE_BUILDING_DARKNESS_LEVEL = 10;
    public static final int MIDDLE_BUILDING_WIDTH_LOWEST = 30;
    public static final int MIDDLE_BUILDING_WIDTH_RANGE = 5;
    public static final int MIDDLE_BUILDING_HEIGHT_LOWEST = 350;
    public static final int MIDDLE_BUILDING_HEIGHT_RANGE = 50;
    public static final int MIDDLE_BUILDING_WINDOW_FACTOR = 50;
    public static final int FRONT_BUILDING_LENGTH = 24;
    public static final int FRONT_BUILDING_DARKNESS_LEVEL = 80;
    public static final int FRONT_BUILDING_WIDTH = 80;
    public static final int FRONT_BUILDING_HEIGHT = 500;
    public static final int FRONT_BUILDING_WINDOW_FACTOR = 224;
    public static final int BUILDING_DARKNESS_FACTOR = 20;
    public static final int BUILDING_HEIGHT_RANDOMIZER = 100;
    public static final int DEFAULT_BUILDING_HEIGHT = 1000;
    public static final int WINDOW_AMOUNT_LOWEST = 4;
    public static final int WINDOW_AMOUNT_RANGE = 2;
    public static final int WINDOW_CAP = 50;
    public static final int LIGHT_STATUS = 2;
    public static final int WINDOW_Y_OFFSET = 4;
    public static final int WINDOW_X_OFFSET = 4;
    public static final int WINDOW_WIDTH = 2;
    public static final int WINDOW_HEIGHT = 2;
    public static final int TRAIN_LABEL_SCALE = 2;
    public static final int TRAIN_LABEL_X_POS = 890;
    public static final int TRAIN_LABEL_Y_POS = 10;
    public static final double DIRECTIONS_LABEL_SCALE = 1.5;
    public static final int DIRECTIONS_LABEL_X_POS = 1400;
    public static final int DIRECTIONS_LABEL_Y_POS = 10;
    public static final double TRAIN_TIMELINE_DURATION = 0.01;
    public static final int TRAIN_X_CHANGE = 10;
    public static final int MOON_Y_POS = 100;
    public static final int SUN_Y_POS = 2060;
    public static final double STAR_X_POS = 2500;
    public static final double STAR_Y_POS = 2500;
    public static final int MOON_SUN_RADIUS = 100;
    public static final double STAR_RADIUS = 3;
    public static final double SUN_SHIFT = Math.PI;
    public static final double STAR_SHIFT = 2*Math.PI;
    public static final Color MOON_COLOR = Color.LIGHTYELLOW;
    public static final Color SUN_COLOR = Color.GOLD;
    public static final Color STAR_COLOR = Color.LIGHTYELLOW;
    public static final int STAR_AMOUNT = 2000;
    public static final int WAGON_AMOUNT = 4;
    public static final int WAGON_INITIAL_X = -250;
    public static final int WAGON_OFFSET = 300;
    public static final int WAGON_Y_POS = 795;
    public static final int CONNECTOR_AMOUNT = 3;
    public static final int CONNECTOR_OFFSET = 50;
    public static final int CONNECTOR_Y_POS = 855;
    public static final int ALL_ROTATED_RECT_AMOUNT = 2;
    public static final int ROTATED_RECT_AMOUNT = 24;
    public static final double ROTATED_RECT_X_LENGTH = 120*Math.cos(Math.PI/4);
    public static final double HALF_ROTATED_RECT_X_LENGTH = 60*Math.cos(Math.PI/4);
    public static final int ROTATED_RECT_Y_POS = 880;
    public static final int ROTATED_RECT_WIDTH = 10;
    public static final int ROTATED_RECT_HEIGHT = 120;
    public static final Color STATION_COLOR = Color.DARKRED;
    public static final int ROTATED_RECT_ROTATION = -45;
    public static final int TOP_RECT_Y_POS = 890;
    public static final int TOP_BOTTOM_RECT_WIDTH = 1920;
    public static final int TOP_BOTTOM_RECT_HEIGHT = 15;
    public static final double BOTTOM_RECT_Y_POS = 890+120*Math.sin(Math.PI/4);
    public static final int BEAM_RECT_AMOUNT = 12;
    public static final int BEAM_RECT_X_POS = 160;
    public static final int BEAM_RECT_Y_POS = 900;
    public static final int BEAM_RECT_WIDTH = 40;
    public static final int BEAM_RECT_HEIGHT = 180;
    public static final int WAGON_WIDTH = 250;
    public static final int WAGON_HEIGHT = 90;
    public static final int WAGON_WINDOW_AMOUNT = 3;
    public static final int WAGON_WINDOW_INITIAL_POS = 10;
    public static final int WAGON_WINDOW_INITIAL_OFFSET = 80;
    public static final int WAGON_WINDOW_WIDTH = 70;
    public static final int WAGON_WINDOW_HEIGHT = 50;
    public static final Color WAGON_WINDOW_COLOR = Color.ALICEBLUE;
    public static final int WHEEL_AMOUNT = 4;
    public static final int WHEEL_INITIAL_X_POS = 48;
    public static final int WHEEL_INITIAL_OFFSET = 48;
    public static final int WHEEL_INITIAL_Y_POS = 90;
    public static final int WHEEL_RADIUS = 10;
    public static final Color WHEEL_COLOR = Color.GRAY;
    public static final int CONNECTOR_WINDOW_WIDTH = 50;
    public static final int CONNECTOR_WINDOW_HEIGHT = 10;
}