package Lab4;

import java.util.ArrayList;

class ElevatorSimulation{
	private int totalTime;
	private int rateTime;
	private BuildingManager bm;
	private ArrayList<PassengerArrival> listOfPA;
	private ArrayList<Elevator> elevators;
    public void start(){
		listOfPA = new ArrayList<PassengerArrival>();
		bm = new BuildingManager();
		getConfig();
		for(int i = 0; i < 5; i++)
		{
			elevators.add(Elevator(i, bm));
		}
		int currentTime = 0;
		while(currentTime < totalTime){

		}
    }

    public void printBuildingState(){

    }
    public void getConfig(){
    	Scanner reader = new Scanner(System.in);
    	totalTime = reader.nextInt();
    	rateTime = reader.nextInt();
		for(int i = 0; i < 5; i++)
		{
			PassengerArrival temp = new PassengerArrival();
			temp.setNumPassengers(reader.nextInt());
			temp.setDestinationFloor(reader.nextInt());
			temp.setTimePeriod(reader.nextInt());
			temp.setExpectedTimeOfArrival(reader.nextInt());
			listOfPA.add(temp);
		}
    	reader.close();
    }
}
