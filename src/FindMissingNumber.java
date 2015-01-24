
public class FindMissingNumber {
	public static int find(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int gap = Integer.MAX_VALUE;
		for (int i = 0; i <= 1; i++) {
			gap = Math.min(gap, A[i + 1] - A[i]);
		}

		int start = 0, end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[start] + (mid - start) * gap != A[mid]) {
				end = mid;
			} else if (A[mid] + (end - mid) * gap != A[end]){
				start = mid;
			}else{
				return A[A.length-1] + gap;
			}
		}

		return A[start] + gap;
	}

	public static void main(String[] args) {
		int[] A = { 1, 3, 7, 9, 11, 13 };
		System.out.println(find(A));
	}
}
