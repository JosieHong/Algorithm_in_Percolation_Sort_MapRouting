package sort;

public class Sort {

	private static final int MAX = 10000;//定义数组大小的宏
	private static final int SIZE = 10;//定义元素大小的宏
	public static void main(String[] args) {
		
		Integer[] arr = new Integer[MAX];
		for(int i=0;i<MAX; i++) {
			arr[i] = (int)(Math.random()*SIZE);
		}
		System.out.println("MAX = "+MAX+" SIZE = "+SIZE);
		
		//插入排序
        long startTime3 = System.nanoTime();//记录开始的时间
        InsertionSort.Insertionsort(arr);
        long endTime3 = System.nanoTime();//记录结束的时间
        long time3 = (endTime3-startTime3)/1000;
        System.out.print("InsertionSort:     		    Time = ");
        System.out.println(time3+"ms");
        /*for (Integer i : arr)
            System.out.print(i + " ");
        System.out.println("");*/
		
		//自顶向下的归并排序
		long startTime1 = System.nanoTime();//记录开始的时间
        MergeSortBH.TopdownMergesort(arr);
        long endTime1 = System.nanoTime();//记录结束的时间
        long time1 = (endTime1-startTime1)/1000;
        System.out.print("TopdownMergeSort:   		    Time = ");
        System.out.println(time1+"ms");
        /*for (Integer i : arr1)
            System.out.print(i + " ");
        System.out.println("");*/
        
        //自底向上的归并排序
        long startTime2 = System.nanoTime();//记录开始的时间
        MergeSortBU.BottomupMergesort(arr);
        long endTime2 = System.nanoTime();//记录结束的时间
        long time2 = (endTime2-startTime2)/1000;
        System.out.print("BottomupMergeSort:   		    Time = ");
        System.out.println(time2+"ms");
        /*for (Integer i : arr2)
            System.out.print(i + " ");
        System.out.println("");*/
        
        //随机快速排序
        long startTime4 = System.nanoTime();//记录开始的时间
        RandomQuickSort.RandomQuicksort(arr);
        long endTime4 = System.nanoTime();//记录结束的时间
        long time4 = (endTime4-startTime4)/1000;
        System.out.print("RandomQuickSort: 		    Time = ");
        System.out.println(time4+"ms");
        /*for (Integer i : arr4)
            System.out.print(i + " ");
        System.out.println("");*/

        
        //Dijkstra 3-路划分快速排序
        long startTime5 = System.nanoTime();//记录开始的时间
        QuickSortwithDijkstra3wayPartition.QuicksortwithDijkstra3wayPartition(arr);
        long endTime5 = System.nanoTime();//记录结束的时间
        long time5 = (endTime5-startTime5)/1000;
        System.out.print("QuickSortwithDijkstra3wayPartition: Time = ");
        System.out.println(time5+"ms");
        /*for (Integer i : arr5)
            System.out.print(i + " ");
        System.out.println("");*/   
    }

}
