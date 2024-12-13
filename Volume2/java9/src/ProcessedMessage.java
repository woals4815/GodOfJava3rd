public class ProcessedMessage extends Message {
    private String target;
    public ProcessedMessage(String message, String target) {
        super(message);
        this.target = target;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + target;
    }
}
