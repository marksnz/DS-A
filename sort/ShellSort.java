import java.util.Arrays;
public class ShellSort
{
    public static void shellSort(int[] arr)
    {
        if ((arr == null) || (arr.length == 1))  
        {
            return ;
        }
        for (int gap = arr.length / 2; gap > 0; gap /= 2) 
        {
            for (int k = 0; k < gap; k++) 
            {
                for (int i = k + gap; i < arr.length ; i += gap) 
                {
                    int toInsert = arr[i];
                    int j = i - gap;
                    while (j >= 0 && arr[j] > toInsert) 
                    {
                        arr[j + gap] = arr[j];
                        j -= gap;
                    }
                    arr[j + gap] = toInsert;
                }
            }
        }

        
    }
    public static void main(String[] args) 
    {
        int[] a = {20,40,30,10,60,50};
        // int[] a = {10,20,30,40,60,50};
        ShellSort.shellSort(a);
        System.out.println("After sort : " + Arrays.toString(a));
    }
}