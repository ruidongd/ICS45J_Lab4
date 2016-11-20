package Lab4;
import java.util.ArrayList;
class Elevator implements Runnable{
    private int elevatorID;
    private BuildingManager manager;
    private int currentFloor;
    private int numOfPassengers;
    private int totalLoadedPassengers;
    private int totalUnloadedPassengers;
    private ArrayList<ElevatorEvent> moveQueue;
    private int[] passengerDestinations;
    public Elevator(int id, BuildingManager bm)
    {
        elevatorID = id;
        manager = bm;
        currentFloor = 0;
        numOfPassengers = 0;
        totalLoadedPassengers = 0;
        totalUnloadedPassengers = 0;
        passengerDestinations = new int[5];
        moveQueue = new ArrayList<ElevatorEvent>();
    }

    @Override
    public void run(){
    	while(!Thread.interrupted())
		{
			if(!moveQueue.isEmpty()) {
				if(moveQueue.get(0).getExpectedArrival() == SimClock.getTime())
				{
					ElevatorEvent next = moveQueue.remove(0);
					currentFloor = next.getDestination();
					if(numOfPassengers == 0)
						loadPassengers();
					else
						unloadPassengers();
				}
			}
			else
				nextEvent();
		}
    }
    public void loadPassengers(){
        // check for up
        for(int i = currentFloor; i < 5; i++){
            
        }
    }

    public void unloadPassengers(){
    }

    public void nextEvent(){
		int des = manager.schduleEvent(elevatorID);
		if(des != -1)
		{
			ElevatorEvent temp = new ElevatorEvent(des, SimClock.getTime() + 5 * Math.abs(des - currentFloor));
			moveQueue.set(0, temp);
		}
    }
}
