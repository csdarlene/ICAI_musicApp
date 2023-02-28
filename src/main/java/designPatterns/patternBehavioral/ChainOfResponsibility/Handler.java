package designPatterns.patternBehavioral.ChainOfResponsibility;

public abstract class Handler {
    private Handler next;

    public Handler setNextHandler(Handler next) {
        this.next = next;
        return next;
    }

    public abstract boolean handle(String artist, String song);

    protected boolean handleNext(String artist, String song) {
        if (next == null) {
            return true;
        }
        return next.handle(artist, song);
    }
}