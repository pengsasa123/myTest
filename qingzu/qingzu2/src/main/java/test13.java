public class test13 {

    public static void main(String[] args) {
        int[] arr = {7, 6, 4, 5, 1, 3};
        method(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 冒泡排序
     */
    public static void method(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
