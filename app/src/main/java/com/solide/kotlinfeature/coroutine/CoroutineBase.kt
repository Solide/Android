package com.solide.kotlinfeature.coroutine

import kotlinx.coroutines.*

class CoroutineBase {

    private suspend fun requestToken() {
        print("requestToken 1")
        print("requestToken 2")
        print("requestToken 3")
        print("requestToken 4")
        print("requestToken 5")
        print("requestToken 6")
        print("requestToken 7")
    }   // 挂起函数

    private suspend fun createPost() {
        print("createPost 1")
        print("createPost 2")
        print("createPost 3")
        print("createPost 4")
        print("createPost 5")
        print("createPost 6")
        print("createPost 7")
    }// 挂起函数

    fun postItem() {
        GlobalScope.launch { // 创建一个新协程
            val token = requestToken()
            val post = createPost()
            // 需要异常处理，直接加上 try/catch 语句即可
        }
    }

    fun testWait() = runBlocking<Unit> {
        println("0")
        val result: Deferred<String> = async { doSomethingTimeout() }
        println("1")
        println("I will got the result ${result.await()}")
        println("2")
    }

    private suspend fun doSomethingTimeout(): String {
        delay(1000)
        return "Result"
    }

    /**
     * 立即执行协程体
     */
    fun default() = runBlocking {
        val job = GlobalScope.launch(start = CoroutineStart.DEFAULT) {
            println("1: " + Thread.currentThread().name)
        }
        // 不需要调用join方法
        // job.join()
    }

    /**
     * 只有在需要的情况下才执行协程体
     */
    fun lazy() = runBlocking {
        val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
            println("1: " + Thread.currentThread().name)
        }
        // 一定调用join方法,否则不会执行
        job.join()
    }


    /**
     * 立即执行协程体，但在开始运行之前无法取消, 即开启协程会无视cancelling状态
     */
    fun atomic() = runBlocking {
        val job = GlobalScope.launch(start = CoroutineStart.ATOMIC) {
            println("1: " + Thread.currentThread().name + " \n ")
            delay(1000)
            println("2: " + Thread.currentThread().name + " \n ")
        }
        print("3" + " \n ")
        job.cancel()
        print("4" + " \n ")
        delay(2000)
        print("5" + " \n ")
    }

    fun undispatched() = runBlocking {
        println("0: " + Thread.currentThread().name)
        // 注意这里没有用GlobalScope.launch
        // 因为GlobalScope.launch启动的是一个顶层协程, 无法关联当前协程的上下文（coroutineContext）, 导致结果有偏差
        launch(context = Dispatchers.Default, start = CoroutineStart.UNDISPATCHED) {
            println("1: " + Thread.currentThread().name)
            delay(1000)
            println("2: " + Thread.currentThread().name)
        }
        delay(2000)
    }


    fun funcArea() = runBlocking { // this: CoroutineScope
        launch {
            delay(200L)
            println("Task from runBlocking")
        }

        coroutineScope { // 创建一个协程作用域
            launch {
                delay(500L)
                println("Task from nested launch")
            }

            delay(100L)
            println("Task from coroutine scope") // 这一行会在内嵌 launch 之前输出
        }

        println("Coroutine scope is over") // 这一行在内嵌 launch 执行完毕后才输出
    }


}