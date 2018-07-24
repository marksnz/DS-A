import java.util.Arrays;
public class MergeSort
{
    private String print2(int[]a, int l, int r)
    {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = l; i <= r; i++) 
        {
            sb.append(a[i]);
            sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
    private String print3(int[]a, int l, int m, int r)
    {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = l; i <= m; i++) 
        {
            sb.append(a[i]);
            sb.append(" ");
        }
        sb.append("], [ ");
        for (int i = m + 1; i <= r; i++) 
        {
            sb.append(a[i]);
            sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    private void merge(int[] a, int l, int mid, int r)
    {
        System.out.println("Before merge: " + print3(a, l, mid, r));
        int[] b = new int[r - l + 1];
        int index = 0;
        int l1 = l;
        int r1 = mid + 1;
        while (index < b.length && l1 <= mid && r1 <= r) 
        {
            if (a[l1] <=a[r1]) 
            {
                b[index++] = a[l1++];
            }
            else
            {
                b[index++] = a[r1++];
            }
        }
        if (l1 > mid) 
        {
            while (r1 <= r) 
            {
                int t= a[r1++];
                b[index++] = t;
            }
        }
        if (r1 > mid) 
        {
            while (l1 <= mid) 
            {
                b[index++] = a[l1++];
            }
        }
        for (int i = 0; i < b.length; i++) 
        {
            a[l+i] = b[i];
        }
        System.out.println("After  merge: " + print2(a, l, r));
    }

    public void mergeSort(int[] arr, int l, int r)
    {
        if (arr == null) 
        {
            return ;
        }
        if (r > l) 
        {
            
            int mid = (l + r) / 2;
            System.out.printf("split: %d, %d, %d\n", l, mid, r);
            if (mid > l) 
            {
                mergeSort(arr, l , mid);
            }
            if (mid + 1 < r) 
            {
                mergeSort(arr, mid + 1, r);
            }
            merge(arr, l, mid, r);
        }
    }

    public static void main(String[] args) 
    {
        int a[] = {80,30,60,40,20,10,50,70};
        // int a[] = {30};
        new MergeSort().mergeSort(a, 0, a.length - 1);
        System.out.println("After sort : " + Arrays.toString(a));
    }
}