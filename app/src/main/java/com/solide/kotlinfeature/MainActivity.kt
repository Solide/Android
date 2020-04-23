package com.solide.kotlinfeature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.solide.kotlinfeature.coroutine.thread.Consumer
import com.solide.kotlinfeature.coroutine.thread.Producer
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedQueue = LinkedList<Int>()
        val producer: Thread = Producer(sharedQueue)
        val consumer: Thread = Consumer(sharedQueue)
        producer.start()
        consumer.start()
    }
}
