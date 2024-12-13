import java.util.concurrent.SubmissionPublisher;

public class ReactiveStreamWithProcessorMain {
    public static void main(String[] args) throws InterruptedException {
        SubmissionPublisher<Message> publisher = new SubmissionPublisher<>();
        ReactiveStreamProcessor processor = new ReactiveStreamProcessor();
        ReactiveStreamSubscriber sub1 = new ReactiveStreamSubscriber("sub1");
        ReactiveStreamSubscriber sub2 = new ReactiveStreamSubscriber("sub2");

        publisher.subscribe(processor);
        processor.subscribe(sub1);
        processor.subscribe(sub2);

        for (int i = 0; i < 100; i++) {
            publisher.submit(new Message("This is message your age is " + i));
            Thread.sleep(100);
        }
        publisher.close();
        while (true) {
            if(sub1.isCompleted() && sub2.isCompleted()) {
                break;
            }
            Thread.sleep(100);
        }


    }
}
