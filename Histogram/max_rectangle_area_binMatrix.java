/*
time=O(rc), r times, I am applying histogram rectangle function, which takes O(c)
space = O(c)
 */
package RBR_DSA.Histogram;

public class max_rectangle_area_binMatrix {
    public static int area(int[][] arr,int m,int n)
    {
        int max_area=Integer.MIN_VALUE;
        int area=max_rectangle.rectangle_area(arr[0],n);
        if(area>max_area)
            max_area=area;
        for(int i=1;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(arr[i][j] == 0)
                    arr[i][j]=0;
                else
                    arr[i][j]+=arr[i-1][j];
            }
            area=max_rectangle.rectangle_area(arr[i],n);
            if(area>max_area)
                max_area=area;
        }
        return max_area;
    }
    public static void main(String[] args)
    {
        int arr[][]={
                {1,0,1,1,1},
                {0,0,0,0,0}
        };
        System.out.println(area(arr,2,5));

        int arr2[][]={
                {1,0,1,1,1},
                {1,1,1,1,0},
                {1,1,1,1,1}
        };
        System.out.println(area(arr2,3,5));
    }
}
