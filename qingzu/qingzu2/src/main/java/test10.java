import java.util.concurrent.LinkedBlockingQueue;

public class test10 {
    /**
     * LinkedBlockingQueue
     *
     * add:add方法在添加元素的时候，若超出了度列的长度会直接抛出异常
     * put:对于put方法，若向队尾添加元素的时候发现队列已经满了会发生阻塞一直等待空间，以加入元素
     * offer:offer方法在添加元素时，如果发现队列已满无法添加的话，会直接返回false。
     *
     * poll:若队列为空，返回null。
     * remove:若队列为空，抛出NoSuchElementException异常。
     * take:若队列为空，发生阻塞，等待有元素。
     */

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        for (int i = 0; i < 4; i++) {
            System.out.println("---------" + i);
            Integer take = queue.take();
            System.out.println("=========" + take);
        }
    }
}

