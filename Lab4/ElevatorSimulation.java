package Lab4;

import java.util.Scanner;

class ElevatorSimulation{
	private int totalTime;
	private int rateTime;
	private BuildingManager bm;
	
    public void start(){

    }

    public void printBuildingState(){

    }
    public void getConfig(){
    	Scanner reader = new Scanner(System.in);
    	totalTime = reader.nextInt();
    	rateTime = reader.nextInt();
    	
    	reader.close();
    }
}
