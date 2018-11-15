package AStar;

public class Node {

	private final int x;
    private final int y;
    
	public Node(int x, int y){
		if (x < 0) throw new IllegalArgumentException("Node coordination must be nonnegative integers");
        if (y < 0) throw new IllegalArgumentException("Node coordination must be nonnegative integers");
		this.x = x;
		this.y = y;
	}
	
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
}
