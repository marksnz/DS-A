import java.util.Arrays;
public class BubbleSort
{
    public void bubbleSort(int[] arr)
    {
        if ((arr == null) || (arr.length == 1)) 
        {
            return ;
        }
        
        for (int i = arr.length -1; i > 0; i--) 
        {
            int k = 0;
            for (int j = 0; j < i; j++) 
            {

                if (arr[j] > arr[j+1]) 
                {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    k = j; //k remembers the first position of the orderd sequence from tail
                }
                // System.out.println(Arrays.toString(arr) + "k=" + k + ", i=" + i);
            }
            i = k + 1; //i jumps to the last disorder one, in the worst case, k equals i-1
        }

    }
    public static void main(String[] args) 
    {
        int[] a = {20,40,30,10,60,50};
        // int[] a = {10,20,30,40,60,50};
        new BubbleSort().bubbleSort(a);
        System.out.println("After sort : " + Arrays.toString(a));
    }
}