package sort;

public class QuickSortwithDijkstra3wayPartition {

	//Dijkstra 3-路划分快速排序
	public static <T extends Comparable<? super T>> void QuicksortwithDijkstra3wayPartition(T[] arr) {
		
		QuicksortwithDijkstra3wayPartition(arr, 0, arr.length-1);
	}
	private static <T extends Comparable<? super T>> void QuicksortwithDijkstra3wayPartition(T[] arr, int lo, int hi) {
		
		if(hi<=lo)
			return;
		int lt = lo, i = lo+1, gt = hi;
		T v = arr[lo];
		while(i<=gt) {
			int cmp = arr[i].compareTo(v);
			if(cmp<0)
				exch(arr, lt++, i++);
			else if(cmp>0)
				exch(arr, i, gt--);
			else
				i++;
		}
		QuicksortwithDijkstra3wayPartition(arr, lo, lt-1);
		QuicksortwithDijkstra3wayPartition(arr, gt+1, hi);
	}
	//交换数组arr中 第i个元素与第j个元素的位置
	private static <T extends Comparable<? super T>> void exch(T[] arr, int i, int j) {
			
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return;
	}
}
