package sort;

public class RandomQuickSort {
	
	//随机快速排序
	public static <T extends Comparable<? super T>> void RandomQuicksort(T[] arr) {
		
		RandomQuicksort(arr, 0, arr.length-1);
	}
	private static <T extends Comparable<? super T>> void RandomQuicksort(T[] arr, int lo, int hi) {
		
		if(hi<=lo)
			return;
		int j = partition(arr, lo, hi);//切分
		RandomQuicksort(arr, lo, j-1);//将左半部分排序
		RandomQuicksort(arr, j+1, hi);//将右半部分排序
		return;
	}
	//将数组切分为arr[lo...i-1] arr[i] arr[i+1...hi]
	private static <T extends Comparable<? super T>> int partition(T[] arr, int lo, int hi) {
		
		int x = ((int)Math.random() % arr.length) + lo;//产生一个0...arr.length-1的一个随机数作为主元的序号
		exch(arr, x, lo);//交换主元与第一个元素，接下来与快排相同
		int i = lo, j = hi+1;
		T v = arr[lo];//切分元素
		while(true) {
			//扫描左右，检查扫描是否结束并交换元素
			while(arr[++i].compareTo(v)<=0)
				if(i==hi)
					break;
			while(v.compareTo(arr[--j])<=0)
				if(j==lo)
					break;
			if(i>=j)
				break;
			exch(arr, i, j);
		}
		exch(arr, lo, j);
		return j;
	}
	//交换数组arr中 第i个元素与第j个元素的位置
	private static <T extends Comparable<? super T>> void exch(T[] arr, int i, int j) {
		
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return;
	}
}
