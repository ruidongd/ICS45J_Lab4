package Lab4;

public class ElevatorEvent {
	
	private int des; 

	private int expectedArrival;
	public ElevatorEvent(){
		
	}
	public ElevatorEvent(int destination, int time)
	{
		des = destination;
		this.expectedArrival = time;
	}
	
	public void setDestination(int destination) { des = destination; }
	
	public void setExpectedArrival(int expectedArrival) { this.expectedArrival = expectedArrival; }
	
	public int getDestination() { return des; }
	
	public int getExpectedArrival() { return expectedArrival; }
	
}