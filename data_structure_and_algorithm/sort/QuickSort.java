package solution;

/**
 * 快速排序
 * 
 * 实现方式：递归
 * 时间复杂度 Ω(N*logN)，O(n^2)
 * 空间复杂度 Ω(logN)，O(n)
 * 
 * 原理：
 * 分而治之，取某个元素，交换其他元素使其之前的元素都小于它，之后的元素都大于它，然后对该元素
 * 左右的两个区间进行相同的操作
 * 
 * 更多形式参考：http://www.cnblogs.com/nullzx/p/5880191.html
 */
public class QuickSort {

	public static <T extends Comparable<T>> T[] sort1(T[] arr) {
		sort1(arr, 0, arr.length - 1);
		return arr;
	}

	public static <T extends Comparable<T>> T[] sort2(T[] arr) {
		sort2(arr, 0, arr.length - 1);
		return arr;
	}

	/*
	 * 单端扫描
	 */
	private static <T extends Comparable<T>> void sort1(T[] arr, int lo, int hi) {
		if (lo >= hi)
			return;

		// 将arr[lo]作为 pivot
		// arr[lo + 1, i]存储小于pivot的元素
		// arr[i + 1, j - 1]存储大于pivot的元素
		// arr[j, hi]为未知元素
		int i = lo, j = lo + 1;

		while (j <= hi) {
			// 如果arr[j] < pivot，则将i后移一位，然后交换arr[i]和arr[j]
			// 使小于pivot的元素位于arr[1, i]中
			if (arr[j].compareTo(arr[lo]) < 0) {
				swap(arr, ++i, j);
			}
			++j;
		}

		// 扫描完毕，将pivot放到其正确位置
		// 因arr[lo + 1, i]均小于pivot，所以交换arr[i]和pivot后
		// 仍能保证pivot之前的元素都比pivot小
		swap(arr, lo, i);

		// 递归pivot左边
		sort1(arr, lo, i - 1);

		// 递归pivot右边
		sort1(arr, i + 1, hi);
	}

	/*
	 * 两端扫描
	 */
	private static <T extends Comparable<T>> void sort2(T[] arr, int lo, int hi) {
		if (lo >= hi)
			return;

		// 将arr[lo]作为 pivot
		// arr[lo + 1, i]存储小于pivot的元素
		// arr[j, hi]存储大于pivot的元素
		// arr[i + 1, j - 1]为未知元素
		int i = lo, j = hi;
		T pivot = arr[lo];

		while (i < j) {
			// j从右向左扫描
			// 遇到小于pivot的元素或与i相遇则停止
			while (i < j && arr[j].compareTo(pivot) >= 0) {
				--j;
			}
			// i从左向右扫描
			// 遇到大于pivot的元素或与j相遇则停止
			while (i < j && arr[i].compareTo(pivot) <= 0) {
				++i;
			}

			// 只有当i和j分别找到大于或小于pivot的元素时才交换
			if (i < j) {
				swap(arr, i, j);
			}
		}

		// 扫描完毕，将pivot放到其正确位置
		swap(arr, i, lo);

		// 递归pivot左边
		sort2(arr, lo, i - 1);

		// 递归pivot右边
		sort2(arr, i + 1, hi);
	}

	private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
		T tmp;
		tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
