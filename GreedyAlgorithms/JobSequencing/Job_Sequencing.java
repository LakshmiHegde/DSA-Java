/*
Jib sequencing with deadlines, sequence job before deadline , to acheive give profit
Space =O(N)
Time = O(N^2)
 */
package RBR_DSA.GreedyAlgorithms.JobSequencing;

import java.util.Arrays;
import java.util.Comparator;

class Job
{
    int deadline,profit;
    Job(int deadline,int profit)
    {
        this.deadline=deadline;
        this.profit=profit;
    }
    static Job[] fromArray(int[] arr)
    {
        Job j[]=new Job[arr.length/2];
        int k=0;
        for(int i=0;i<j.length;i++)
        {
            j[i]=new Job(arr[k++],arr[k++]);
        }
        return j;
    }

}
public class Job_Sequencing {
    public static int jobSequencingDeadlines(Job[] jobs,int N)
    {
        int ghantChart[] =new int[N]; // O(N) space
        Arrays.fill(ghantChart,-1); //O(N) time
        int sum=0;
        for(int i=0;i<N;i++) //O(N)
        {
            int j=jobs[i].deadline;
            if(j>N)
                j=N-1;
            else
                j=j-1;
            while(j>=0 && ghantChart[j] != -1) //O(N) time in worst case
                j--;
            if(j>=0)
            {
                ghantChart[j]=jobs[i].profit;
                sum+=ghantChart[j];
            }
        }
        return sum;
    }
    public static void sortArr(Job[] arr)
    {
        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                int f1=o1.profit;
                int f2=o2.profit;
                if(f1 < f2)
                    return 1;
                else if(f1 > f2)
                    return -1;
                else
                    return 0;
            }
        });
    }
    public static void main(String[] args)
    {
        int[] arr={7,15,2,20,5,30,3,18,4,18,5,10,2,23,7,16,3,25};
        Job jobs[]=Job.fromArray(arr);
        sortArr(jobs);
        System.out.println("Max profit "+jobSequencingDeadlines(jobs,jobs.length));

        int[] arr2={3,2,3,4,3,3,4,1,4,10};
        Job jobs2[]= Job.fromArray(arr2);
        sortArr(jobs2);
        System.out.println("Max profit "+jobSequencingDeadlines(jobs2,jobs2.length));
    }
}
