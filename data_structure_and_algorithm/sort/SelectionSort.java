package solution;

/**
 * 选择排序
 * 
 * 实现方式：迭代
 * 时间复杂度 Ω(n^2)，O(n^2)
 * 空间复杂度 O(1)
 * 
 * 原理：
 * 每趟扫描选出最小的元素与扫描开始位置的元素交换
 */
public class SelectionSort {

	public static <T extends Comparable<T>> T[] sort(T[] arr) {
		int indexMin;
		T tmp;
		for (int i = 0; i < arr.length; ++i) {
			// 最小元素位置
			indexMin = i;

			// 选出最小元素
			for (int j = i + 1; j < arr.length; ++j) {
				if (arr[j].compareTo(arr[indexMin]) < 0) {
					indexMin = j;
				}
			}

			// 交换元素
			if (indexMin != i) {
				tmp = arr[i];
				arr[i] = arr[indexMin];
				arr[indexMin] = tmp;
			}
		}
		return arr;
	}

}
