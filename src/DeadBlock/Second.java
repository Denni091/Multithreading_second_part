package DeadBlock;

public class Second {

    private First first;

    public First getFirst() {
        return first;
    }

    public void setFirst(First first) {
        this.first = first;
    }

    public synchronized String getString() {
        return "Hello from second class";
    }

    public synchronized String getStringFromFirstClass() {
        return first.getString();
    }
}
