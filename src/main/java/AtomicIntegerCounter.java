import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicIntegerCounter implements SiteVisitCounter {
    private AtomicInteger atomicInteger = new AtomicInteger();

   @Override
    public void incrementVisitCount() {
       try {
           Thread.sleep(100);
       } catch (InterruptedException e) {
           // Логируем информацию о прерывании
           System.out.println("Поток " + Thread.currentThread().getName() + " был прерван во время сна");
           // Восстанавливаем состояние прерывания
           Thread.currentThread().interrupt();
       }
        atomicInteger.incrementAndGet();
    }

    @Override
    public void getVisitCount() {System.out.println("Синхронизация с помощью AtomicInteger. " + "Количесто посетителей сайта: " + atomicInteger);
    }
}
