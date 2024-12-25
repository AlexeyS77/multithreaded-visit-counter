import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter implements SiteVisitCounter {

    private static int count;
    Lock lock = new ReentrantLock();

    @Override
    public void incrementVisitCount() {
            lock.lock();
            try {
                Thread.sleep(100);
                count++;
            } catch (InterruptedException e) {
                // Логируем информацию о прерывании
                System.out.println("Поток " + Thread.currentThread().getName() + " был прерван во время сна");
                // Восстанавливаем состояние прерывания
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }


    @Override
    public void getVisitCount() {
        System.out.println("Синхронизация с помощью интерфейса Lock. " + "Количесто посетителей сайта: " + count);
    }


}
