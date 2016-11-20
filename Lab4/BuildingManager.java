package Lab4;
class BuildingManager{
	private BuildingFloor[] floors;
	public BuildingManager()
	{
		floors = new BuildingFloor[5];
		for(int i = 0; i < 5; i++){
			floors[i] = new BuildingFloor();
		}
	}
	public synchronized void updateTotalDes(int start, int des, int num){
		floors[start].setTotalDestinationRequests(num+floors[start].getTotalDestinationRequests(des), des);
	}
	public synchronized void updateCurrentPassengers(int start, int des, int num){
		floors[start].setPassengerRequests(num + floors[start].getPassengerRequests(des), des);
	}
	public synchronized void setCurrentPassengers(int start, int des, int num){
		floors[start].setPassengerRequests(num, des);
	}
	public synchronized void updateTotalArr(int ID, int des, int num){
		floors[des].setArrivedPassengers(num+floors[des].getArrivedPassengers(ID), ID);
	}
	public synchronized int getFloor(int index, int des){
		int res = floors[index].getPassengerRequests(des);
		updateCurrentPassengers(index, des, 0);
		return res;
	}
	public synchronized void updateApproachingElevator(int floor, int ID){
		floors[floor].setApproachingElevator(ID);
	}

	public boolean havingRequest(int i){
		for(int j = 0; j < 5; j++){
			if(floors[i].getPassengerRequests(j) > 0)
				return true;
		}
		return false;
	}
	public synchronized int schduleEvent(int elevatorID){
		for(int i = 0; i < 5; i++){
			if(floors[i].getApproachingElevator() == -1 && havingRequest(i))
				{
					floors[i].setApproachingElevator(elevatorID);
					return i;
				}
		}
		return -1;
	}

}
