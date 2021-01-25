import java.util.concurrent.*;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT + 1);
    public static final Semaphore semaphore = new Semaphore(CARS_COUNT / 2, true);
    public static volatile boolean isWin = false;

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (Car car : cars) {
            new Thread(car).start();
        }
        countDownLatch.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        cyclicBarrier.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}

