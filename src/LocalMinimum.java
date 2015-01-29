
public class LocalMinimum {
	public int localMin(int[] A){
		int start = 0, end = A.length-1;
		while(start < end){
			int mid = start + (end - start)/2;
			if(mid+1<A.length && A[mid] > A[mid+1]){
				start = mid+1;
			}else if(mid-1 >= 0 && A[mid-1] < A[mid]){
				end = mid-1;
			}else{
				return mid;
			}
		}
		return start;
	}
	
	public static void main(String[] args) {
		int[] A = {15, 13, 12, 18, 19, 20, 7, 6, 5, 4, 3, 2, 1};
		LocalMinimum solution = new LocalMinimum();
		System.out.println(solution.localMin(A));
	}
}
