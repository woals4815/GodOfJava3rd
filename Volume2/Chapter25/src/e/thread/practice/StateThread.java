package e.thread.practice;

public class StateThread extends Thread {
    private Object monitor;
    public StateThread(Object monitor) {
        this.monitor = monitor;
    }
    public void run() {
        try {
            for (int i = 0; i < 10000 ; i++) {
                String a = "A";
            }
            synchronized (monitor) { // 모니터 객체의 wait method 호출
                monitor.wait();
            }
            System.out.println(getName() + " is notified");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
