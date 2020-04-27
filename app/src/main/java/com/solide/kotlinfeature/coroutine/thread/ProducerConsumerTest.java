package com.solide.kotlinfeature.coroutine.thread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerTest {

    public static void test1() {
        final Queue<Integer> sharedQueue = new LinkedList();
        Thread producer = new Producer(sharedQueue);
        Thread consumer = new Consumer(sharedQueue);
        producer.start();
        consumer.start();
    }

}
	

	
