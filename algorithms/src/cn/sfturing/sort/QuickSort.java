/*
package cn.sfturing.sort;



public class QuickSort {
    int a[] = {6,4,2,1,8};

    public QuickSort() {

        quickSort(a, 0, a.length - 1);

        for (int i : a
                ) {
            System.out.print(i + " ");

        }


    }

    public int getMiddle(int[] list, int low, int high) {
        int temp = list[low];
        while (low < high) {
            while (low < high && list[high] >= temp) {
                high--;
            }
            list[low] = list[high];
            while (low < high && list[low] <= temp) {
                low++;
            }
            list[high] = list[low];
        }
        list[low] = temp;
        return low;
    }

    public void _quickSort(int[] list, int low, int high) {

        if (low < high) {
            int mid = getMiddle(list, low, high);
            _quickSort(list, low, mid - 1);
            _quickSort(list, mid + 1, high);
        }
    }

    public void quickSort(int[] list, int low, int high) {
        if (list.length > 0) {
            _quickSort(list, low, high);
        }
    }

    public static void main(String[] args) {
        new QuickSort();
    }

}
*/
