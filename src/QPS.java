import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Date;


public class QPS {
	private volatile AtomicInteger querys;
	private int QPS;
	private TimerTask task;
	
	public QPS(int qps){
		this.QPS = qps;
		this.querys = new AtomicInteger(0);
		task = new TimerTask() {
			@Override
			public void run() {
				querys.getAndSet(0);
			}
		};
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, 1000);
	}
	
	public void setQPS(int qps){
		this.QPS = qps;
	}
	
	public boolean allowRequest(){
		if(querys.getAndIncrement() >= QPS){
			return false;
		}
		System.out.println(new Date() + " request succeed");
		return true;
	}
	
	
	public static void main(String[] args) {
		final QPS solution = new QPS(1);
		for(int i = 0; i < 10; i++){
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					while(true){
						solution.allowRequest();
					}
				}
			});
			t.start();
		}
	}
}
