public class QuickSortTrace {
    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 9, 1, 7, 3, 8, 6};
        quickSort(arr, 1);
        printArray(arr);
    }

    public static void quickSort(int[] arr, int depth) {
        quickSort(arr, 0, arr.length - 1, depth);
    }

    public static void quickSort(int[] arr, int low, int high, int depth) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high, depth);
            quickSort(arr, low, pivotIndex - 1, depth + 1);
            quickSort(arr, pivotIndex + 1, high, depth + 1);
        }
    }

    public static int partition(int[] arr, int low, int high, int depth) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        printPartition(arr, low, high, depth);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printPartition(int[] arr, int low, int high, int depth) {
        System.out.print(depth + ":    Partition: " + arr[high] + "\n" + depth + ":    ");
        printArray(arr, low, high);
    }

    public static void printArray(int[] arr) {
        printArray(arr, 0, arr.length - 1);
    }

    public static void printArray(int[] arr, int low, int high) {
        System.out.print("[");
        for (int i = low; i <= high; i++) {
            System.out.print(arr[i]);
            if (i < high) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
