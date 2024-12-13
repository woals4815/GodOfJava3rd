import java.util.Random;
import java.util.concurrent.Flow.*;

public class ReactiveStreamSubscriber implements Subscriber<Message> {
    private Subscription subscription;
    private String name;
    private boolean completed;

    public ReactiveStreamSubscriber(String name) {
        this.name = name;
        this.completed = false;
    }
    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Message item) {
        Random random = new Random();
        int randomTime = random.nextInt(1000) + 1;
        sleep(randomTime);
        System.out.println("["+name+"] Recevied message: " +  item.getMessage());
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        completed = true;
        System.out.println("["+name+"] Completed");
    }
    public boolean isCompleted() {
        return completed;
    }
    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
