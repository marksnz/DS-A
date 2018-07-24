import java.util.Arrays;
public class HeapSort
{
    private void swap(int[] arr, int a, int b)
    {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private void filterDown(int[] arr, int start, int end)
    {
        int c = start;
        int l = 2 * c + 1;
        while (l <= end) 
        {
            if (l + 1 <= end && arr[l+1] > arr[l]) 
            {
                l++;
            }

            if (arr[l] > arr[c]) 
            {
                swap(arr, l, c);
                c = l;
                l = 2 * c + 1;
            }
            else
            {
                break;
            }
        }
    }

    public void heapSort(int[] arr)
    {
        if (arr == null || arr.length == 1) 
        {
            return;
        }
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) 
        {
            filterDown(arr, i, n - 1);
        }
        for (int j = n - 1; j > 0; j--) 
        {
            swap(arr, 0, j);
            filterDown(arr, 0, j - 1);
        }
    }

    public static void main(String[] args) 
    {
        int a[] = {20,30,90,40,70,110,60,10,100,50,80};
        new HeapSort().heapSort(a);
        System.out.println("After sort : " + Arrays.toString(a));
    }
}