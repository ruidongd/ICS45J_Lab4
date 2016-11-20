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
	public void update(int start, int des, int num){
		floors[start].setTotalDestinationRequests(num+floors[start].getTotalDestinationRequests(des), des);
		floors[start].setPassengerRequests(num+floors[start].getPassengerRequests(des), des);
	}
	
}
