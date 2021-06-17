/*
maxReachableIndex = Maximum index you can reach at any point of time.
stepsAboutToTake = steps that are needed to reach maxIndexReachable value.
jumps = jumps taken, to reach maximumReachableIndex

Time = O(n)
Space = O(1)
 */
package RBR_DSA.MinimumJumps;

public class SecondApproach {
    public static int greedyApproachToJump(int[] arr)
    {
        int stepsAboutToTake = 0;
        int maxReachableIndex =0;
        int jumps=1;

        if(arr[0] == 0)
            return -1;
        maxReachableIndex=stepsAboutToTake = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if (i == arr.length - 1)
                return jumps;

            stepsAboutToTake--;
            maxReachableIndex = Math.max(i+arr[i] , maxReachableIndex);
            if(stepsAboutToTake == 0)
            {
                    jumps++;
                  //  System.out.println("i = "+ i+"maxRrach = "+ maxReachableIndex);
                    if (i >= maxReachableIndex)
                        return -1;
                    stepsAboutToTake = maxReachableIndex - i;
            }
        }
        return -1;
    }
    public static void main(String[] args)
    {
        String arr[] = "70 40 9 19 94 84 15 87 71 45 87 85 5 53 13 43 10 50 94 91 38 63 98 33 99 91 86 66 43 80 35 79 20 10 98 80 61 13 66 31 24 18 82 97 72 61 39 48 11 99 38 49 27 2 49 26 59 0 58 1 81 59 80 67 70 77 46 97 56 79 27 81 63 75 77 0".split(" ");
        int intarr[]= new int[arr.length];
        for(int i=0;i<arr.length;i++)
            intarr[i]=Integer.valueOf(arr[i]);
        // System.out.println("Minimum jumps required "+greedyApproachToJump(intarr));

        int testCase1[]={2, 3 ,1, 1, 2, 4 ,2 ,0, 1, 1};
        System.out.println("Minimum jumps required "+greedyApproachToJump(testCase1));

        int testCase2[]={2,2 ,0, 1, 1};
        System.out.println("Minimum jumps required "+greedyApproachToJump(testCase2));

        int testCase3[]={1,0, 1, 1};
        System.out.println("Minimum jumps required "+greedyApproachToJump(testCase3));

        int testCase4[]={0,2, 1, 1};
        System.out.println("Minimum jumps required "+greedyApproachToJump(testCase4));

        int testCase5[]={2, 0, 0};
        System.out.println("Minimum jumps required "+greedyApproachToJump(testCase5));

        int testCase6[]={2,2,3,2,2, 0, 1,5};
        System.out.println("Minimum jumps required "+greedyApproachToJump(testCase6));

    }
}
