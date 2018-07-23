import java.util.Arrays;
//not stable
public class SelectionSort
{
    public static void selectionSort(int[] arr)
    {
        if ((arr == null) || (arr.length == 1))  
        {
            return ;
        }
        for (int i = 0; i < arr.length - 1; i++) 
        {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) 
            {
                if (arr[j] < arr[min]) 
                {
                    min = j;
                }
                
            }
            if (i != min) 
            {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }

    public static void main(String[] args) 
    {
        // int[] a = {20,40,30,10,60,50};
        int[] a = {10,20,30,40,60,50};
        SelectionSort.selectionSort(a);
        System.out.println("After sort : " + Arrays.toString(a));
    }
}