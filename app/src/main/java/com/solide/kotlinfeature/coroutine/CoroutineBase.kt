package com.solide.kotlinfeature.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CoroutineBase {
    suspend fun requestToken() {
        print("requestToken 1")
        print("requestToken 2")
        print("requestToken 3")
        print("requestToken 4")
        print("requestToken 5")
        print("requestToken 6")
        print("requestToken 7")
    }   // 挂起函数

    suspend fun createPost(){
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
}