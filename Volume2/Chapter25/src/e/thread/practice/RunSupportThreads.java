package e.thread.practice;

public class RunSupportThreads {
    public static void main(String[] args) {
        RunSupportThreads run = new RunSupportThreads();
        run.checkThreadState1();
    }
    public void checkThreadState1() {
        SleepThread thread = new SleepThread(1000);
        SleepThread thread2 = new SleepThread(1000);
        try {
            System.out.println("state = " + thread.getState());
            thread.start();
            thread2.start();
            Thread.sleep(1000);
            System.out.println("state = " + thread.getState() + thread.getName());
            System.out.println("state = " + thread2.getState() + thread2.getName());

            System.out.println("after start state = " + thread.getState());
            System.out.println("after start state = " + thread2.getState() + thread2.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}


class SleepThread extends Thread {
    long sleepTime;
    public SleepThread(long sleepTime) {
        this.sleepTime = sleepTime;
    }
    public void run() {
        try {
            System.out.println("Sleeping " + sleepTime);
            Thread.sleep(sleepTime);
            System.out.println("stopping" + getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}