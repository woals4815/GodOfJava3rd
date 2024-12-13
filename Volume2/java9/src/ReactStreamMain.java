import java.util.concurrent.SubmissionPublisher;

public class ReactStreamMain {
    public static void main(String[] args) throws InterruptedException  {
        SubmissionPublisher<Integer> pub = new SubmissionPublisher<Integer>();
        ReactiveStreamSubscriber sub1 = new ReactiveStreamSubscriber("sub1");
        ReactiveStreamSubscriber sub2 = new ReactiveStreamSubscriber("sub2");

        System.out.println("submitting items....");

        for (int i = 0; i < 1000; i++) {
            pub.submit(i);
            System.out.println("published: " + i);
        }
        pub.close();
        while(true) {
            if (sub1.isCompleted() && sub2.isCompleted()) {
                break;
            }
            Thread.sleep(100);
        }

        ReactStreamMain main = new ReactStreamMain();
    }
}
