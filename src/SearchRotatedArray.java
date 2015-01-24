
public class SearchRotatedArray {
	public int search(int[] A, int k){
		if(A == null || A.length == 0) return -1;
		int start = 0, end = A.length-1;
		while(start < end){
			int mid = start + (end-start)/2;
			if(A[mid] == k){
				return mid;
			}else if(A[start] < A[mid]){
				if(A[start] <= k && k < A[mid]){
					end = mid-1;
				}else {
					start = mid+1;
				}
			}else {
				if(A[mid] < k && k <= A[end]){
					start = mid+1;
				}else{
					end = mid-1;
				}
			}
		}
		if(A[start]!=k) return -1;
		return start;
	}
	
	public static void main(String[] args) {
		int[] A = {4,5,6,7,8,9,1,2,3};
		SearchRotatedArray solution = new SearchRotatedArray();
		System.out.println(solution.search(A, 2));
		System.out.println(solution.search(A, 11));
	}
}
