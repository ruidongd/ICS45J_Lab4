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
    private int pickFloor;
    public Elevator(int id, BuildingManager bm)
    {
    	pickFloor = 0;
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
					currentFloor = moveQueue.remove(0).getDestination();
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
        int count = 0;
        for(int des = currentFloor + 1; des < 5; des++){
            int numOfPass = manager.getFloor(currentFloor, des);
            if(numOfPass > 0)
            {
            	count++;
                numOfPassengers += numOfPass;
                passengerDestinations[des] += numOfPass;
                totalLoadedPassengers += numOfPass;
                ElevatorEvent newEvent = new ElevatorEvent(des, SimClock.getTime() + 5 * Math.abs(des - currentFloor) + 10*count);
                moveQueue.add(newEvent);
                manager.setCurrentPassengers(currentFloor, des, 0);
                pickFloor = currentFloor;
                System.out.format("| TIME %4d | ELEVATOR #%d   | ELEVATOR FINISHED LOADING %d PASSENGERS FROM FLOOR #%d TO FLOOR #%d\n\n",
						SimClock.getTime(), elevatorID, numOfPass, currentFloor, des);
            }
        }
        // No one are going up.
        if(numOfPassengers == 0){
            for(int des = currentFloor - 1; des >= 0; des--){
                int numOfPass = manager.getFloor(currentFloor, des);
                if(numOfPass > 0)
                {
                	count++;
                    numOfPassengers += numOfPass;
                    passengerDestinations[des] += numOfPass;
                    totalLoadedPassengers += numOfPass;
                    ElevatorEvent newEvent = new ElevatorEvent(des, SimClock.getTime() + 5 * Math.abs(des - currentFloor) + 10*count);
                    moveQueue.add(newEvent);
                    manager.setCurrentPassengers(currentFloor, des, 0);
                    pickFloor = currentFloor;
                    System.out.format("| TIME %4d | ELEVATOR #%d   | ELEVATOR FINISHED LOADING %d PASSENGERS FROM FLOOR #%d TO FLOOR #%d\n\n",
    						SimClock.getTime(), elevatorID, numOfPass, currentFloor, des);
                }
            }
        }
        manager.updateApproachingElevator(currentFloor, -1);
    }

    public void unloadPassengers(){
    	int numOfPass = passengerDestinations[currentFloor];
    	totalUnloadedPassengers += numOfPass;
    	numOfPassengers -= numOfPass;
    	manager.updateTotalArr(elevatorID, currentFloor, numOfPass);
    	passengerDestinations[currentFloor] = 0;
		manager.updateApproachingElevator(currentFloor, -1);
		System.out.format("| TIME %4d | ELEVATOR #%d   | ELEVATOR FINISHED UNLOADING %d PASSENGERS FROM FLOOR #%d TO FLOOR #%d\n\n",
				SimClock.getTime(), elevatorID, numOfPass, pickFloor, currentFloor);
    }

    public void nextEvent(){
		int des = manager.schduleEvent(elevatorID);
		if(des != -1)
		{
			ElevatorEvent temp = new ElevatorEvent(des, SimClock.getTime() + 5 * Math.abs(des - currentFloor) + 10);
			moveQueue.add(temp);
			System.out.format("| TIME %4d | ELEVATOR #%d   | ELEVATOR IS APPROACHING FROM FLOOR #%d TO FLOOR #%d\n\n",
					SimClock.getTime(), elevatorID, currentFloor, des);
		}
    }
}
