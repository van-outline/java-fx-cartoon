package cartoon;

import java.util.ArrayList;

/**
 * This is the Train class that creates the train by instantiating
 * several wagons using the creatTrain method.
 */
public class Train {

    private final PaneOrganizer organizer;
    ArrayList<TrainWagon> wagons = new ArrayList<>();

    /**
     * The constructor creates the train by calling the createTrain method.
     */
    public Train(PaneOrganizer organizer){
        this.organizer = organizer;
        this.createTrain();
    }

    /**
     * This method creates the train by making several trainWagon objects
     * and offseting their x position data.
     */
    public void createTrain(){
        for(int i = 0; i < Constants.WAGON_AMOUNT; i++) {
            double xPos = Constants.WAGON_INITIAL_X - Constants.WAGON_OFFSET * i;
            TrainWagon wagon = new TrainWagon(this.organizer, xPos, Constants.WAGON_Y_POS);
            this.wagons.add(wagon);
            if (i != Constants.CONNECTOR_AMOUNT) {
                wagon.addConnectors(this.organizer);
            }
        }
    }

    /**
     * By using a For each loop, each trainwagon object is moved
     * by a given amount.
     */
    public void moveTrain(double xChange){
        for (TrainWagon wagon : this.wagons){
            wagon.moveWagon(xChange);
        }
    }

    public void setTrain(){
        for (TrainWagon wagon : this.wagons){
            wagon.setWagon();
        }
    }

    /**
     * This getter returns the x position of the first train cart,
     * acting as a universal position for the entire train.
     */
    public double getFirstX(){
            return this.wagons.get(0).getWagonX();
        }
}
