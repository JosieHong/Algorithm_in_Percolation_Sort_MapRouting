package AStar;

import java.util.Scanner;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Test {

    public static void main(String[] args) {
    	
        In in = new In("mapall.txt");
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        
        System.out.println("请输入源点（输入-1结束查找）：");
        Scanner sin = new Scanner(System.in);
        int s = sin.nextInt();
        if(s<0)
        	return;
        System.out.println("请输入终点（输入-1结束查找）：");
        int aim = sin.nextInt();
        if(aim<0)
        	return;
        
        while(s>=0 && aim>=0) {
        	// compute shortest paths
        	long startTime = System.currentTimeMillis();//记录开始的时间
        	AStar as = new AStar(G, s, aim);
            long endTime = System.currentTimeMillis();//记录结束的时间
        	
        	//打印源到目标节点的最短路径
        	if (as.hasPathTo(aim)) {
                StdOut.printf("%d to %d (%.2f)  ", s, aim, as.distTo(aim));
                for (DirectedEdge e : as.pathTo(aim)) {
                    StdOut.print(e + "   ");
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d         no path\n", s, aim);
            }
        	System.out.print("time = ");
        	System.out.print(endTime-startTime);
        	System.out.println("ms");
            
            System.out.println("请输入源点（输入-1结束查找）：");
            s = sin.nextInt();
            if(s == -1)
            	return;
            System.out.println("请输入终点（输入-1结束查找）：");
            aim = sin.nextInt();
            if(aim == -1)
            	return;
        }
        sin.close();
    }
}
