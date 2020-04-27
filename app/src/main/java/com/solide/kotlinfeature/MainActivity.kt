package com.solide.kotlinfeature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.solide.kotlinfeature.coroutine.thread.Consumer
import com.solide.kotlinfeature.coroutine.thread.Producer
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
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

    fun main(args: Array<String>) = runBlocking<Unit> {
        val result: Deferred<String> = async { doSomethingTimeout() }
        println("I will got the result ${result.await()}")
    }

    suspend fun doSomethingTimeout(): String {
        delay(1000)
        return "Result"
    }
}
