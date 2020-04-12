package solution;

import java.util.Arrays;

public class HeapSort {

    public static int[] sort(int[] arr) {
        // 构建大顶堆
        // 最后一个非叶子节点索引为 arr.length / 2 - 1
        for (int i = arr.length / 2 - 1; i >= 0; --i) {
            adjustHeap(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
        // 取堆顶元素放到数组最后，然后重新用剩下的元素构建大顶堆
        for (int i = arr.length - 1; i > 0; --i) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
        return arr;
    }

    private static void adjustHeap(int[] arr, int index, int len) {
        int current = arr[index];
        // 左子结点索引: i * 2 + 1
        // 右子结点索引: i * 2 + 2
        for (int i = 2 * index + 1; i < len; i = 2 * i + 1) {
            int indexRight = i + 1;
            if (indexRight < len && arr[indexRight] > arr[i]) {
                // 如果存在右子结点且左子结点小于右子结点，i 指向右子结点
                ++i;
            }
            if (arr[i] > current) {
                // 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换， 后面会设置父节点）
                arr[index] = arr[i];
                index = i;
            } else {
                break;
            }
        }
        arr[index] = current;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
