import DeadBlock.First;
import DeadBlock.Second;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        SyncService syncService = new SyncService();
        syncService.checkSyncCallLogic();
        syncService.checkPartSyncCallLogic();

        Object object = new Object();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> syncService.checkSyncCallForSomeObject(object));
            thread.start();
        }

        First first = new First();
        Second second = new Second();

        first.setSecond(second);
        second.setFirst(first);

        Thread firstThread = new Thread(() -> System.out.println(first.getStringFromSecondClass()));
        Thread secondThread = new Thread(() -> System.out.println(second.getStringFromFirstClass()));

        firstThread.start();
        secondThread.start();

        Object o = new Object();
        Thread thread = new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread running: " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        });
        thread.start();
        synchronized (o) {
            o.wait();
        }
        System.out.println("Finished");
    }
}
