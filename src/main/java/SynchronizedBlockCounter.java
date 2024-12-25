public class SynchronizedBlockCounter implements SiteVisitCounter {
    private static Integer count = 0;

    @Override
    public void incrementVisitCount() {
        synchronized (this) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // Логируем информацию о прерывании
                System.out.println("Поток " + Thread.currentThread().getName() + " был прерван во время сна");
                // Восстанавливаем состояние прерывания
                Thread.currentThread().interrupt();
            }
            count++;
        }
    }

    @Override
    public void getVisitCount() {
        System.out.println("Синхронизациия с помощью synchronized блоков. " + "Количесто посетителей сайта: " + count);
    }
}
