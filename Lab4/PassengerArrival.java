package Lab4;
class PassengerArrival{
	private int numPassengers;
	private int destinationFloor;
	private int timePeriod;
	private int expectedTimeOfArrival;
	public PassengerArrival()
	{
		numPassengers = 0;
		destinationFloor = 0;
		timePeriod = 0;
		expectedTimeOfArrival = 0;
	}
	public void setNumPassengers(int num)
	{
		numPassengers = num;
	}

	public void setTimePeriod(int t)
	{
		timePeriod = t;
	}

	public void setDestinationFloor(int df)
	{
		destinationFloor = df;
	}

	public void setExpectedTimeOfArrival(int eta)
	{
		expectedTimeOfArrival = eta;
	}

	public void readFromConfig()
	{
		
	}
	public int getNumPassengers()
	{
		return numPassengers;
	}

	public int getTimePeriod()
	{
		return timePeriod;
	}

	public int getDestinationFloor()
	{
		return destinationFloor;
	}

	public int getExpectedTimeOfArrival()
	{
		return expectedTimeOfArrival;
	}



}
