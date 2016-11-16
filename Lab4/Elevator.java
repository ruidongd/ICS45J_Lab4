package Lab4;
class Elevator{
    private int elevatorID;
    private BuildingManager manager;
    public Elevator(int id, BuildingManager bm)
    {
        elevatorID = id;
        manager = bm;
    }
}
