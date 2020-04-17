package solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main() {
        Integer[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        for (int i = 0; i < 30; ++i) {
            List<Integer> list = Arrays.stream(arr).collect(Collectors.toList());
            Collections.shuffle(list);
            arr = list.toArray(new Integer[0]);
            QuickSort.sort1(arr);
            System.out.println(Arrays.toString(arr));
            int k;
            for (k = 0; k < arr.length - 1; ++k) {
                if (arr[k] > arr[k + 1]) {
                    System.out.println("error");
                    break;
                }
            }
        }
    }

}
