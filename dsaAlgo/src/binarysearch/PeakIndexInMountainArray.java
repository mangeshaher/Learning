package binarysearch;

/*
An array arr is a mountain if the following properties hold:
arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ...
> arr[arr.length - 1].
You must solve it in O(log(arr.length)) time complexity.

Example 1:
Input: arr = [0,1,0]
Output: 1
Example 2:
Input: arr = [0,2,1,0]
Output: 1
Example 3:
Input: arr = [0,10,5,2]
Output: 1

Constraints:
3 <= arr.length <= 105
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array.
*/

public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        return bSearch(arr, 0, arr.length-1);
    }

    public int bSearch(int[] arr, int l, int r){
        int mid = (l+r)/2;
        if(mid>0 && arr[mid]>arr[mid-1] && mid<arr.length-1 && arr[mid]>arr[mid+1]){
            return mid;
        }
        else if(mid<arr.length-1 && arr[mid]<arr[mid+1]){
            return bSearch(arr, mid+1, r);
        }
        else{
            return bSearch(arr, l, mid);
        }
    }
}
