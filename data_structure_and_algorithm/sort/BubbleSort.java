package solution;

/**
 * 冒泡排序，时间复杂度 Ω(n)，O(n^2)；空间复杂度 O(1)
 * 
 * 原理：
 * 逐一对比所有相邻元素，若构成逆序对（a[i] > a[i+1]）则交换两者，直至整个数组有序
 */
public class BubbleSort {

	public static <T extends Comparable<T>> T[] sort(T[] arr) {
		// 标志数组是否已经有序
		boolean sorted = false;
		// 用于交换数组成员的中间变量
		T tmp;

		while (!sorted) {
			sorted = true;
			for (int i = 0; i < arr.length - 1; ++i) {
				// 如果前一项目大于后一项，则交换两者
				if (arr[i].compareTo(arr[i + 1]) > 0) {
					tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					sorted = false;
				}
			}
		}
		return arr;
	}

}
