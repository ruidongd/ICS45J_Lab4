package Lab4;

public class ElevatorEvent {
	
	private int des; 

	private int expectedArrival;
	
	// Ordinary Constructor
	public ElevatorEvent(int destination, int expectedArrival)
	{
		this.des = destination;
		this.expectedArrival = expectedArrival;
	}
	
	public void setDestination(int destination) { des = destination; }
	
	public void setExpectedArrival(int expectedArrival) { this.expectedArrival = expectedArrival; }
	
	public int getDestination() { return des; }
	
	public int getExpectedArrival() { return expectedArrival; }
	
}