package DeadBlock;

public class First {

    private Second second;

    public Second getSecond() {
        return second;
    }

    public void setSecond(Second second) {
        this.second = second;
    }

    public synchronized String getString() {
        return "Hello from first class";
    }

    public synchronized String getStringFromSecondClass() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return second.getString();
    }
}
