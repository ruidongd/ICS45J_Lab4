package Lab4;
class Elevator implements Runnable{
    private int elevatorID;
    private BuildingManager manager;
    private int curFloor;
    private int numOfPassengers;
    public Elevator(int id, BuildingManager bm)
    {
        elevatorID = id;
        manager = bm;
    }
    
    @Override
    public void run(){
    	
    }
}
