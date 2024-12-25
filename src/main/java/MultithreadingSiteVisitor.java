import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MultithreadingSiteVisitor {
    private SiteVisitCounter siteVisitCounter;
    private long startTime; // Время начала обработки
    private long endTime;   // Время окончания

    MultithreadingSiteVisitor(SiteVisitCounter siteVisitCounter) {
        this.siteVisitCounter = siteVisitCounter;
    }

    public void visitMultithread(int numOfThreads) {
        startTime = System.currentTimeMillis(); // Запоминаем время начала (в миллисекундах)
        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);
        for (int i = 0; i < numOfThreads; i++) {
            executorService.submit(() -> {
                siteVisitCounter.incrementVisitCount();
            });
    }
        executorService.shutdown();
        waitUntilAllVisited(executorService);
        endTime = System.currentTimeMillis(); // Запоминаем время окончания (в миллисекундах)
    }

    private void waitUntilAllVisited(ExecutorService executorService) {
        try {
            // Ожидаем завершения всех задач в течение 1 минуты
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow(); // Принудительно завершаем, если не завершились
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow(); // Принудительно завершаем, если поток был прерван
            Thread.currentThread().interrupt(); // Восстанавливаем статус прерывания
        }
    }

    public void getTotalTimeOfHandling () {
        System.out.println("Общее время обработки всех потоков " + ((endTime - startTime) / 1000.0) + " сек.");
    }
}




