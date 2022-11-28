import java.util.Objects;

public class SyncService {

    public synchronized void checkSyncCallLogic() {

        for (int i = 0; i < 100; i++) {
            System.out.println("Thread: " + Thread.currentThread().getName());
        }
    }

    public void checkPartSyncCallLogic() {
        for (int i = 0; i < 10; i++) {
            System.out.println("SYNC CALL: " + Thread.currentThread().getName());
        }
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("sync call: " + Thread.currentThread().getName());
            }
        }
    }

    public void checkSyncCallForSomeObject(Object object) {
        synchronized (object) {
            for (int i = 0; i < 100; i++) {
                System.out.println("sync call for object: " + Thread.currentThread().getName());
            }
        }
    }
}
