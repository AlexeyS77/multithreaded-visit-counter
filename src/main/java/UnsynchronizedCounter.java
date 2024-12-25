public class UnsynchronizedCounter implements SiteVisitCounter {

    private static int count;

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
        count++;
    }

    @Override
    public void getVisitCount() {
        System.out.println("Потоки без синхронизации. " + "Количесто посетителей сайта: " + count);
    }
}

