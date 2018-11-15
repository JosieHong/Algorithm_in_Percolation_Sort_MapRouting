package percolation;

public class Percolation {
	public Percolation(int n) {
		this.n = n;//渗透矩阵的变长
	    map = new int[n*n];//记录渗透矩阵中各点状态 0表示close 1表示open 2表示fullopen
		fullopen = new int[n*n];//记录fullopen的点 便于查找
	}
	private int n;
	private int[] map;
	private int[] fullopen;
	private int head = 0, tail = 0;
	public void setFullOpen(){
		int[][] trydirection = {{0,1},{1,0},{0,-1},{-1,0}};
		head = 0;
		for(int k=0;k<n;k++) { //第一行open的节点记录进fullopen
			if(map[k] == 1) {
				fullopen[tail] = k;
				map[k]=2;
				tail++;
			}	
		}
		while(head<tail) { //广度优先搜索 将其余行与fullopen中相连的节点记录进fullopen
			for(int k=0;k<4;k++) { //对四个方向进行尝试
				int x = fullopen[head]/n;
				int y = fullopen[head]%n;
				int tx = x+trydirection[k][0];
				int ty = y+trydirection[k][1];
				//System.out.print("x="+x+"y="+y+"tx="+tx+"ty="+ty);
				if(tx<0||ty<0||tx>=n||ty>=n) { //越界
					//System.out.println(" Over!");
					continue;
				}
				else if(isOpen(tx,ty) == true) {
					fullopen[tail] = tx*n+ty;
					map[tx*n+ty]=2;
					tail++;
					//System.out.println(" Open it!");
				}
				//else
					//System.out.println("");
			}
			head++;
		}
		//System.out.println("head="+head+"tail="+tail);
		return;
	}
	public void open(int i,int j) {
		this.map[i*n+j] = 1;
		//System.out.println("open("+i+","+j+")");
		return;
	}
	public boolean isOpen(int i,int j) {
		if(map[i*n+j] == 1) 
			return true;
		else 
			return false;
	}
	public boolean isFull(int i,int j) {
		if(map[i*n+j] == 2) 
			return true;
		else
			return false;
	}
	public boolean percolates() {//判断是否全渗透
		for(int p=0;p<tail;p++) {
			if(fullopen[p] > (n-1)*n)
				return true;
		}
		return false;
	}
	public void printmap() { //输出原图
		for(int i=0;i<n*n;i++) {
			System.out.print(map[i]);
			if(i%n == (n-1))
				System.out.println("");
		}
	}
	public void printfullopen() { //输出已渗透的点
		System.out.print("fullopen:");
		for(int i=0;i<n*n;i++) {
			System.out.print(fullopen[i]+" ");
		}
		System.out.println("");
	}
}
