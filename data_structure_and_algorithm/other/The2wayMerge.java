package solution;

/**
 * 二路归并（合并两个有序数组，使合并后的数组仍然有序）
 * 
 * 实现方式：迭代
 * 时间复杂度：Ω(n)，O(n)
 * 空间复杂度：若在方法中创建结果数组则为 O(n)，若由参数传入结果数组则为 O(1)
 * 
 * 原理：
 * 依次比较两数组中的最小值，将较小者放入结果数组，并将较小者数组的元素指针后移一位
 */
public class The2wayMerge {

	public static int[] merge(int[] a, int[] b) {
		int[] ret = new int[a.length + b.length];
		int indexA = 0, indexB = 0, indexRet = 0, min;

		while (indexA < a.length && indexB < b.length) {
			// 取较小者并后移其对应的元素指针
			min = a[indexA] < b[indexB] ? a[indexA++] : b[indexB++];
			System.out.println(min);
			ret[indexRet++] = min;
		}

		// 将剩余元素放入结果数组
		// 以下两个while必然只会执行一个
		while (indexA < a.length) {
			ret[indexRet++] = a[indexA++];
		}
		while (indexB < b.length) {
			ret[indexRet++] = b[indexB++];
		}
		return ret;
	}

}
