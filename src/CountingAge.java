
public class CountingAge {
	public static void countAge(int[] ages){
		if(ages == null || ages.length == 0) {
			return;
		}
		int i = 0;
		while(i <ages.length){
			int cnt = getCount(ages, i);
			System.out.println(ages[i]+":"+cnt);
			i += cnt;
		}
	}
	
	private static int getCount(int[] A, int i){
		int exp = 0, count = 1, temp = A[i];
		while(i < A.length && A[i] == temp){
			while((i + (1<<exp)) < A.length && A[(i+(1<<exp))]==temp){
				exp++;
			}
			if(exp == 0){
				break;
			}
			count += 1 << (exp-1);
			i += 1 << (exp-1);
			exp = 0;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] A = {8,8,8,9,9,11,15,16,16,16};
		System.out.println(getCount(A,5));
		countAge(A);
	}
}
