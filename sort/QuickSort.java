import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;
public class QuickSort
{
    private static int partition(int[] arr, int left, int right)
    {
         int flag = arr[left];
        int i = left;
        int j = right;
        while (i < j) 
        {
            while (arr[j] >= flag && i < j) // not less than, stable
            {
                j--;
            }
            if (i < j) 
            {
                arr[i++] = arr[j];
            }
            while (arr[i] <= flag && i < j) 
            {
                i++;
            }
            if (i < j) 
            {
                arr[j--] = arr[i];
            }
        }
        arr[i] = flag;
        return i;
    }

    /**
    *recursivenon-recursive
    */
    public static void quickSort1(int[] arr, int left, int right)
    {
        if (arr == null || left >= right || arr.length == 1) 
        {
            return ;
        }

        int mid = partition(arr, left, right);
        if (mid > 1) 
        {
            quickSort1(arr, left, mid -1);
        }
        if (mid < right -1) 
        {
            quickSort1(arr, mid + 1, right);
        }
    }

    /**
    *non-recursive
    */
    public static void quickSort2(int[] arr)
    {
        if (arr == null || arr.length == 1) 
        {
            return ;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        stack.push(arr.length-1);
        
        while (!stack.isEmpty()) 
        {
            int r = stack.pop();
            int l = stack.pop();
            int mid = partition(arr, l, r);
            if (mid - 1 > l) 
            {
                stack.push(l);
                stack.push(mid - 1);
            }
            if (mid + 1 < r) 
            {
                stack.push(mid + 1);
                stack.push(r);
            }
        }
    }

    public static void main(String[] args) 
    {
        int[] a = {20,40,30,10,60,50};
        // int[] a = {10,20,30,40,60,50};
        // QuickSort.quickSort1(a, 0, a.length-1);
        QuickSort.quickSort2(a);
        System.out.println("After sort : " + Arrays.toString(a));
    }
}