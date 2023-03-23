import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer {
    private static final int BUFFER_SIZE = 5;
    private static ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<Integer>(BUFFER_SIZE);

    public static void main(String[] args) {
        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());
        producer.start();
        consumer.start();
    }

    static class Producer implements Runnable {
        public void run() {
            int i = 1;
            while (true) {
                try {
                    buffer.put(i);
                    System.out.println("Produced: " + i);
                    i++;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        public void run() {
            while (true) {
                try {
                    int consumed = buffer.take();
                    System.out.println("Consumed: " + consumed);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
