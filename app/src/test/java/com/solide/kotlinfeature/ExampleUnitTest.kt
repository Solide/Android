package com.solide.kotlinfeature

import com.solide.kotlinfeature.coroutine.CoroutineBase
import com.solide.kotlinfeature.coroutine.thread.Consumer
import com.solide.kotlinfeature.coroutine.thread.Producer
import com.solide.kotlinfeature.coroutine.thread.ProducerConsumerTest
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_Koroutine() {
//        ProducerConsumerTest.test1()

        val c = CoroutineBase()
//        c.postItem()
//        c.testWait()
//        c.default()
//        c.lazy()
//        c.atomic()
//        c.undispatched()
        c.funcArea()
    }


}
