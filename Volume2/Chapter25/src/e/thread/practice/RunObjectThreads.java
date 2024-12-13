package e.thread.practice;

public class RunObjectThreads {
    public static void main(String[] args) {
        RunObjectThreads run = new RunObjectThreads();
        run.checkThreadState2();
    }
    public void checkThreadState2() {
        Object monitor = new Object();
        StateThread thread = new StateThread(monitor);
        StateThread thread2 = new StateThread(monitor);
        try {
            System.out.println("tread state = " + thread.getState());
            System.out.println("2- tread state = " + thread.getState());
            thread.start();
            thread2.start();
            System.out.println("after start state = " + thread.getState());
            System.out.println("2- after start state = " + thread2.getState());

            Thread.sleep(100);
            System.out.println("after sleep state = " + thread.getState());
            System.out.println("2- after sleep state = " + thread2.getState());

            synchronized (monitor) {
                monitor.notifyAll();
            }

            Thread.sleep(100);
            System.out.println("thread state after notify = " + thread.getState());
            System.out.println("2 - thread state after notify = " + thread2.getState());

            thread.join();
            thread2.join();
            System.out.println("thread state after join = " + thread.getState());
            System.out.println("2- thread state after join = " + thread2.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
