package Domain_Camp_Questions.advance_java;
public class Multithreading_java {

static class SharedQueue {
    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value) {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println("(Producer) Thread 1 produces: " + data);
        notify();
    }

    public synchronized void consume() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("(Consumer) Thread 2 consumed: " + data);
        hasData = false;
        notify();
    }
}

static class Producer extends Thread {
    private final SharedQueue queue;

    public Producer(SharedQueue queue) {
        this.queue = queue;
    }

    public void run() {
        int i = 1;
        while (i <= 7) {
            queue.produce(i++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

static class Consumer extends Thread {
    private final SharedQueue queue;

    public Consumer(SharedQueue queue) {
        this.queue = queue;
    }

    public void run() {
        int i = 1;
        while (i <= 7) {
            queue.consume();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            i++;
        }
    }
}

    public static void main(String[] args) {
        SharedQueue queue = new SharedQueue();

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        producer.start();
        consumer.start();
    }
}

