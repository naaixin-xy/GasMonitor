public class TestThread {
	public static long testVar;
	public static class  MyThread extends Thread{
		
		public MyThread(String name) {
			super(name);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				testVar++;
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		int i=0;
		for(i=0;i<20;i++) {
			new MyThread("线程"+String.valueOf(i)).start();
		}
		while(true) {
			System.out.println(testVar);
			Thread.sleep(2000);
		}
	}
}
