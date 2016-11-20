package Lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class ElevatorSimulation{
	private int totalTime;
	private int rateTime;
	private BuildingManager bm;
	private ArrayList<ArrayList<PassengerArrival>> listOfPA;
	private ArrayList<Elevator> elevators;
	public ElevatorSimulation() {
		bm = new BuildingManager();
		listOfPA = new ArrayList<ArrayList<PassengerArrival>>(5);
		elevators = new ArrayList<Elevator>(5);
		
		for(int i = 0; i < 5; i++)
		{
			elevators.add(new Elevator(i, bm));
			listOfPA.add(new ArrayList<PassengerArrival>());
		}
	}

    public void start(){
    	String file = "ElevatorConfig.txt";
    	if(!getConfig(file))
    		return;
    	
    	Thread elevator_1 = new Thread(elevators.get(0));
    	Thread elevator_2 = new Thread(elevators.get(1));
    	Thread elevator_3 = new Thread(elevators.get(2));
    	Thread elevator_4 = new Thread(elevators.get(3));
    	Thread elevator_5 = new Thread(elevators.get(4));
    	
    	elevator_1.start();
    	elevator_2.start();
    	elevator_3.start();
    	elevator_4.start();
    	elevator_5.start();
    	
    	while(SimClock.getTime() <= totalTime && !Thread.interrupted()) {
			processThread();
		}
    	
		elevator_1.interrupt();
		elevator_2.interrupt();
		elevator_3.interrupt();
		elevator_4.interrupt();
		elevator_5.interrupt();
    	
    }
    
    public boolean getConfig(String file){
    	try{
    		Scanner reader = new Scanner(new File("/Users/Ruidong/Documents/workspace/proj4/src/Lab4/ElevatorConfig.txt"));
        	totalTime = Integer.parseInt(reader.nextLine());
        	rateTime = Integer.parseInt(reader.nextLine());
    		for(int i = 0; i < 5; i++)
    		{
    			String[] line = reader.nextLine().split(";");
    			for(int j = 0; j < line.length; j++)
    			{
    				PassengerArrival temp = new PassengerArrival();
    				temp.setNumPassengers(Integer.parseInt(line[j].split(" ")[0]));
    				temp.setDestinationFloor(Integer.parseInt(line[j].split(" ")[1]));
    				temp.setTimePeriod(Integer.parseInt(line[j].split(" ")[2]));
    				temp.setExpectedTimeOfArrival(Integer.parseInt(line[j].split(" ")[2]));
    				listOfPA.get(i).add(temp);
    			}
    		}
        	reader.close();
        	return true;
    	}
    	catch(FileNotFoundException e){
			System.out.println("Cannot open the file.");
			return false;
    	}
    	
    }
    public void processThread(){
    	int currentTime = SimClock.getTime();
    	for(int i = 0; i < 5; ++i) {
			for(int j = 0; j < listOfPA.get(i).size(); ++j) {
				PassengerArrival currentPA = listOfPA.get(i).get(j);
				if(currentPA.getExpectedTimeOfArrival() == currentTime) {
					System.out.format("| TIME %4d | ELEVATOR #N/A | %d PASSENGER IS REQUESTING FROM FLOOR #%d TO FLOOR #%d\n\n",
							currentTime, currentPA.getNumPassengers(), i,
							currentPA.getDestinationFloor());
					currentPA.setExpectedTimeOfArrival(currentTime + currentPA.getTimePeriod());
					int des = currentPA.getDestinationFloor();
					int numOfPassengers = currentPA.getNumPassengers();
					bm.updateTotalDes(i, des, numOfPassengers);
					bm.updateCurrentPassengers(i, des, numOfPassengers);
				}
			}
		}
    	
    	try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("InterruptedException from Thread!");
		}
		SimClock.tick();
    }
    
    public void printBuildingState(){
    	
    }
}
