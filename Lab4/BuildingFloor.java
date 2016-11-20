package Lab4;
class BuildingFloor{
	private int[] totalDestinationRequests;
	private int[] arrivedPassengers;
	private int[] passengerRequests;
	private int approachingElevator;
	public BuildingFloor(){	
		totalDestinationRequests = new int[5];
		arrivedPassengers = new int[5];
		passengerRequests = new int[5];
		approachingElevator = -1;
	}
	
	public int getTotalDestinationRequests(int index)
	{
		return totalDestinationRequests[index];
	}
	public int getArrivedPassengers(int index)
	{
		return totalDestinationRequests[index];
	}
	public int getPassengerRequests(int index)
	{
		return passengerRequests[index];
	}
	public int getApproachingElevator()
	{
		return approachingElevator;
	}
	
	public void setTotalDestinationRequests(int num, int des)
	{
		totalDestinationRequests[des] = num;
	}
	public void setArrivedPassengers(int num, int arr)
	{
		arrivedPassengers[arr] = num;
	}
	public void setPassengerRequests(int num, int floor)
	{
		passengerRequests[floor] = num;
	}
	public void setApproachingElevator(int num)
	{
		approachingElevator = num;
	}
	
}