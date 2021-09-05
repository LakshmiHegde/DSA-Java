package RBR_DSA.ArrayProblems;

public class ReversePairs {
    int merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i=0,j=0;
        int cnt=0;
        while(i<n1 && j<n2)
        {
            if(L[i] <= R[j]*2)
            {
                i++;
            }
            else
            {
                cnt+=(n1-i);
                j++;
            }
        }
        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        i = 0;
        j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        return cnt;
    }
    int sort(int arr[], int l, int r)
    {
        int cnt=0;
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            cnt+=sort(arr, l, m);
            cnt+=sort(arr, m + 1, r);

            // Merge the sorted halves
            cnt+=merge(arr, l, m, r);
        }
        return cnt;
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String[] args)
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array");
        printArray(arr);

        ReversePairs ob = new ReversePairs();
        System.out.println(ob.sort(arr, 0, arr.length - 1));

        System.out.println("\nSorted array");
        printArray(arr);

    }
}
