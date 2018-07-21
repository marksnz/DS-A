import java.util.Arrays;
public class InsertSort
{
    public void insertSort(int[] arr)
    {
        if ((arr == null) || (arr.length == 1))  
        {
            return ;
        }

        for (int i = 1; i < arr.length ; i++) 
        {
            int toInsert = arr[i];
            int j = i - 1;
            while (j>=0 && arr[j] > toInsert) 
            {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = toInsert;
        }
    }
    public static void main(String[] args) 
    {
        // int[] a = {20,40,30,10,60,50};
        int[] a = {10,20,30,40,60,50};
        new InsertSort().insertSort(a);
        System.out.println("After sort : " + Arrays.toString(a));
    }
}