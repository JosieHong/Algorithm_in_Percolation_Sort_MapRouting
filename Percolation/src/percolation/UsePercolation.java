package percolation;

import java.util.Scanner;

public class UsePercolation {

	public static void main(String[] args) {
		
		int n = 0;
		int count = 0;
		
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.close();
		Percolation per = new Percolation(n);

		while(per.percolates() == false) {
			
			//System.out.println("\ncount="+count+"___________________________");
			int x = (int)(Math.random()*n);
			int y = (int)(Math.random()*n);
			//System.out.println("x="+x+";y="+y);
			if(per.isOpen(x,y)==false && per.isFull(x,y)==false) {
				per.open(x,y);
				count++;
			}
			//per.printmap();
			per.setFullOpen();
			//per.printfullopen();
			//System.out.println("___________________________________");
		}
		
		System.out.println("End!");
		System.out.println("count="+count);
		//per.printmap();
		return;
	}

}
