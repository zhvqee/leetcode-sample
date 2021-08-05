package heapsort;

import java.util.stream.IntStream;

public class HeapSort {

    public static void sort(int[] arr) {
        // 建立堆
        for (int j = (arr.length - 1) / 2; j >= 0; j--) {
            buildHeap(arr, j, arr.length - 1);
        }
        heapSort(arr, 0, arr.length - 1);
    }

    private static void heapSort(int[] arr, int begin, int end) {
        for (int j = end; j > 0; j--) {
            swap(arr, j, begin);
            buildHeap(arr, begin, j - 1);
        }
    }

    private static void swap(int[] arr, int s1, int s2) {
        int tmp = arr[s1];
        arr[s1] = arr[s2];
        arr[s2] = tmp;
    }

    // 大顶堆->从小到大排序
    private static void buildHeap(int[] arr, int begin, int end) {
        int top = arr[begin];
        for (int j = 2 * begin + 1; j <= end; j = 2 * j + 1) {
            if (j < end) {
                j = arr[j] > arr[j + 1] ? j : j + 1;
            }
            if (arr[j] < top) {
                break;
            }
            arr[begin] = arr[j];
            begin = j;
        }
        arr[begin] = top;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{49, 38, 65, 97, 76, 13, 27, 49};
        sort(arr);
        IntStream.of(arr).forEach(c -> {
            System.out.print(c + " ");
        });
    }
}
