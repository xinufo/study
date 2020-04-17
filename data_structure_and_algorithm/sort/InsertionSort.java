package solution;

/**
 * 插入排序
 * 
 * 实现方式：迭代
 * 时间复杂度 Ω(n)，O(n^2)
 * 空间复杂度 O(1)
 * 
 * 原理： 
 * 依次取出某个元素，将此元素之前的所有元素视为已经有序，将该元素插入到合适的位置使得插入后的序列仍然有序
 */
public class InsertionSort {

	public static <T extends Comparable<T>> T[] sort(T[] arr) {
		// 用于缓存要插入的元素
		T tmp;
		int j;

		for (int i = 1; i < arr.length; ++i) {
			tmp = arr[i];
			// 遍历并移动之前元素
			for (j = i - 1; j >= 0; --j) {
				if (arr[j].compareTo(tmp) > 0) {
					arr[j + 1] = arr[j];
				} else {
					break;
				}
			}
            arr[++j] = tmp;
		}
		return arr;
	}

}
