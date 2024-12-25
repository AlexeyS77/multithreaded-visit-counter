public class Main {
    public static void main(String[] args) {
        //1.UnsynchronizedCounter: Используйте обычный int для счетчика без механизмов синхронизации.
        UnsynchronizedCounter unsynchronizedCounter = new UnsynchronizedCounter();
        MultithreadingSiteVisitor multithreadingSiteVisitor1 = new MultithreadingSiteVisitor(unsynchronizedCounter);
        multithreadingSiteVisitor1.visitMultithread(100);
        unsynchronizedCounter.getVisitCount();
        multithreadingSiteVisitor1.getTotalTimeOfHandling();
        System.out.println();

        //2.VolatileCounter: Используйте volatile int для счетчика без дополнительной синхронизации.
        VolatileCounter volatileCounter = new VolatileCounter();
        MultithreadingSiteVisitor multithreadingSiteVisitor2 = new MultithreadingSiteVisitor(volatileCounter);
        multithreadingSiteVisitor2.visitMultithread(100);
        volatileCounter.getVisitCount();
        multithreadingSiteVisitor2.getTotalTimeOfHandling();
        System.out.println();

        //3.SynchronizedBlockCounter: Используйте обычный Integer с синхронизацией доступа через synchronized блок.
        SynchronizedBlockCounter synchronizedBlockCounter = new SynchronizedBlockCounter();
        MultithreadingSiteVisitor multithreadingSiteVisitor3 = new MultithreadingSiteVisitor(synchronizedBlockCounter);
        multithreadingSiteVisitor3.visitMultithread(100);
        synchronizedBlockCounter.getVisitCount();
        multithreadingSiteVisitor3.getTotalTimeOfHandling();
        System.out.println();

        //4.AtomicIntegerCounter: Используйте AtomicInteger для счетчика.
        AtomicIntegerCounter atomicIntegerCounter = new AtomicIntegerCounter();
        MultithreadingSiteVisitor multithreadingSiteVisitor4 = new MultithreadingSiteVisitor(atomicIntegerCounter);
        multithreadingSiteVisitor4.visitMultithread(100);
        atomicIntegerCounter.getVisitCount();
        multithreadingSiteVisitor4.getTotalTimeOfHandling();
        System.out.println();

        //5.ReentrantLockCounter: Используйте обычный int с синхронизацией доступа через ReentrantLock.
        ReentrantLockCounter reentrantLockCounter = new ReentrantLockCounter();
        MultithreadingSiteVisitor multithreadingSiteVisitor5 = new MultithreadingSiteVisitor(reentrantLockCounter);
        multithreadingSiteVisitor5.visitMultithread(100);
        reentrantLockCounter.getVisitCount();
        multithreadingSiteVisitor5.getTotalTimeOfHandling();



    }
}
