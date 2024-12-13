import java.util.concurrent.Flow.*;
import java.util.concurrent.SubmissionPublisher;

public class ReactiveStreamProcessor extends SubmissionPublisher<Message> implements Subscriber<Message> {
    private Subscription subscription;
    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Message item) {
        submit(new ProcessedMessage(item.getMessage(), "Target is Human"));
        System.out.println("Processor published to subscriber item:["+item.getMessage()+"]");
        subscription.request(1);
    }

    @Override
    public void onError(Throwable error) {
        error.printStackTrace();
        closeExceptionally(error);
    }

    @Override
    public void onComplete() {
        close();
    }
}
