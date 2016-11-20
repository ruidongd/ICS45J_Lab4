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

	public int getTotalDestinationRequests(int des)
	{
		return totalDestinationRequests[des];
	}
	public int getArrivedPassengers(int ID)
	{
		return totalDestinationRequests[ID];
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
	public void setArrivedPassengers(int num, int ID)
	{
		arrivedPassengers[ID] = num;
	}
	public void setPassengerRequests(int num, int des)
	{
		passengerRequests[des] = num;
	}
	public void setApproachingElevator(int num)
	{
		approachingElevator = num;
	}

}
