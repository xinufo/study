package solution;

import java.lang.reflect.Array;

/**
 * 归并排序
 * 
 * 实现方式：递归
 * 时间复杂度 Ω(N*logN)，O(N*logN)
 * 空间复杂度 O(n)
 * 
 * 原理： 
 * 采用分而治之策略，将数组分割成两个部分，然后使其各自有序，再将这两个部分合并到一起
 */
public class MergeSort {

	public static <T extends Comparable<T>> T[] sort(T[] arr) {
		// 在递归外部创建辅助空间
		T[] helper = createArray(arr);
		sort(arr, 0, arr.length - 1, helper);
		return arr;
	}

	private static <T extends Comparable<T>> void sort(T[] arr, int lo, int hi, T[] helper) {
		if (lo < hi) {
			int mid = (hi + lo) / 2;
			// 排序左边
			sort(arr, lo, mid, helper);
			// 排序右边
			sort(arr, mid + 1, hi, helper);
			// 二路归并
			merge(arr, lo, mid, hi, helper);
		}
	}

	private static <T extends Comparable<T>> void merge(T[] arr, int lo, int mid, int hi, T[] helper) {
		// 结果数组、左边数组、右边数组的元素指针
		int indexRet = lo, indexA = lo, indexB = mid + 1;
		T min;

		// 依次取左右数组中最小元素的较小者放入结果数组
		while (indexA <= mid && indexB <= hi) {
			min = arr[indexA].compareTo(arr[indexB]) < 0 ? arr[indexA++] : arr[indexB++];
			helper[indexRet++] = min;
		}

		// 放入剩余元素
		while (indexA <= mid) {
			helper[indexRet++] = arr[indexA++];
		}
		while (indexB <= hi) {
			helper[indexRet++] = arr[indexB++];
		}

		// 合并结果写入原数组
		for (int i = lo; i <= hi; ++i) {
			arr[i] = helper[i];
		}
	}

	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> T[] createArray(T[] arr) {
		T[] ret = (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length);
		return ret;
	}

}
