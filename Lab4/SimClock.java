package Lab4;
class SimClock{
	private static int currentTime;
	
	public static int getTime(){
		return currentTime;
	}
	public static void tick(){
		currentTime++;
	}
}