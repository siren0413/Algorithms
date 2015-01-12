
public class FindPeakElement {
	public static int findPeak(int[] arr){
		if(arr == null || arr.length == 0) return -1;
		if(arr.length == 1) return 0;
		if(arr.length > 1 && arr[0] > arr[1]) return 0;
		if(arr.length > 1 && arr[arr.length-2] < arr[arr.length-1]) return arr.length-1;
		for(int i = 1; i < arr.length-1; i++){
			if(arr[i-1] < arr[i]  && arr[i] >  arr[i+1]) return i;
		}
		return -1;
	}
	
	public static int findPeak2(int[] arr){
		if(arr == null || arr.length == 0) return -1;
		int start = 0, end = arr.length-1;
		while(start < end){
			int mid = (start + end + 1) /2 ;
			if(arr[mid] >= arr[mid-1]) start = mid;
			else end = mid-1;
		}
		return start;
	}
	
	public static int findPeakElement(int[] num) {
        int low = 0;
        int high = num.length - 1;
        while (low < high) {
            int mid = (low + high + 1)/2;
            if (mid == 0 || num[mid] > num[mid-1]) {
                low = mid;
            } else {
                high = mid-1;
            }
        }
        return low;
    }

	public static void main(String[] args){
		int[] arr = {1,9,3,5,4,2};
		System.out.println(findPeak2(arr));
		System.out.println(findPeakElement(arr));
	}
	
}
