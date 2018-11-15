package percolation;

import java.util.Scanner;

public class percolationstats {

	private static double[] p; //记录每次的渗透率
	private static int n = 0,t = 0;
	private static double mean = 0,dev = 0,low = 0,high = 0;
	public percolationstats(int n,int t) {
	
		p = new double[t];
		for(int i=0;i<t;i++) {
			Percolation per = new Percolation(n);
			while(per.percolates() == false) { //当n*n的区域内未渗透时 打开堵住的点
				int x = (int)(Math.random()*n);
				int y = (int)(Math.random()*n);
				if(per.isOpen(x,y)==false && per.isFull(x,y)==false ) {
					per.open(x,y);
					p[i]++;
				}
				per.setFullOpen(); //重新计算全透过的点
			}
			p[i] = p[i]/(n*n);
			//System.out.println("p["+i+"]="+p[i]);
		}
		/*double temp = 0; //渗透率按升序 冒泡排序
		for(int i=0;i<t;i++) {
			for(int j=i;j<t;j++) {
				if(p[i]>p[j]) {
					temp = p[i];
					p[i] = p[j];
					p[j] = temp;
				}
			}
		}*/
		
	}
	public double mean() {//求平均数
		double sum = 0;
		for(int i=0;i<t;i++) {
			sum = sum+p[i];
		}
		mean = sum/t;
		return mean;
	}
	public double stddev() {//求偏差
		double sum = 0;
		for(int i=0;i<t;i++) {
			sum = sum+(p[i]-mean)*(p[i]-mean);
		}
		return Math.sqrt(sum/t);
	}
	public double confidenceLo() {//求置信区间的下界
		
		return mean-dev/Math.sqrt(t)*1.96;
	}
	public double confidenceHi() {//求置信区间的上界
		
		return mean+dev/Math.sqrt(t)*1.96;
	}
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("矩阵边长 n =");
		n = in.nextInt();
		System.out.println("实验次数 t =");
		t = in.nextInt();
		in.close();
		long startTime = System.nanoTime();//记录开始的时间
		percolationstats per = new percolationstats(n,t);
		long endTime = System.nanoTime();//记录结束的时间
		long time = (endTime-startTime)/1000;
		System.out.print("Time = ");
        System.out.print(time);
        System.out.println("ms");
        
		mean = per.mean(); //渗透率的平均值
		dev = per.stddev();//渗透率的方差
		low = per.confidenceLo();//允许误差5%时的最小值
		high = per.confidenceHi();//允许误差5%时的最大值
		
		System.out.println("mean="+mean);
		System.out.println("dev="+dev);
		System.out.println("low="+low);
		System.out.println("high="+high);
		  
	    System.out.println(Runtime.getRuntime().totalMemory());//输出java虚拟在执行此程序时在操作系统内所占内存
		
		return;
	}
}
