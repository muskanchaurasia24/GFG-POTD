// Given two unsorted arrays arr1[] and arr2[]. They may contain duplicates. For each element in arr1[] count elements less than or equal to it in array arr2[].

// Example 1:

// Input:
// m = 6, n = 6
// arr1[] = {1,2,3,4,7,9}
// arr2[] = {0,1,2,1,1,4}
// Output: 4 5 5 6 6 6
// Explanation: Number of elements less than
// or equal to 1, 2, 3, 4, 7, and 9 in the
// second array are respectively 4,5,5,6,6,6


//{ Driver Code Starts
import java.util.*;

class Count
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            int arr1[] = new int[m];
            int arr2[] = new int[n];
            
            for(int i = 0; i < m; i++)
              arr1[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              arr2[i] = sc.nextInt();
              
            Solution gfg = new Solution();
            ArrayList<Integer> res = gfg.countEleLessThanOrEqual(arr1, arr2, m, n);
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
        
    }
}
// } Driver Code Ends


// Complete the function given below
class Solution
{
    static int binarySearch(int arr[],int value)
    {
        int l = 0, r = arr.length-1;
        while(l <= r)
        {
            int mid = (l+r)/2;
            if(arr[mid] <= value)   l = mid+1;
            else r = mid-1;
        }
        return l;
    }
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
        Arrays.sort(arr2);
        ArrayList<Integer> list = new ArrayList<>();
  
        for(int i=0;i<m;i++) list.add(binarySearch(arr2,arr1[i]));
        return list;
    }
}

// arr1 = 0 1 1 1 2 4
// hs   = 1 2 3 4 5 6
