
public class SquareRoot {
	public double sqrt(int x){
		double low = 1.0, high = (double)x/2, ERROR = 0.0001;
		while(Math.abs(low - high) > ERROR){
			double mid = low + (high-low)/2;
			if(x/mid == mid) return mid;
			else if(x/mid < mid){
				high = mid;
			}else{
				low = mid;
			}
		}
		return low;
	}
	
	public static void main(String[] args) {
		SquareRoot solution = new SquareRoot();
		System.out.println(solution.sqrt(5));
	}
}
