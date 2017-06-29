package aoeiuv020.okhttp.ws

import okhttp3.*
import okio.ByteString
import org.junit.Test
import java.util.concurrent.TimeUnit

/**
 * 复制自okhttp官方test
 * https://github.com/square/okhttp/blob/master/samples/guide/src/main/java/okhttp3/recipes/WebSocketEcho.java
 * Created by AoEiuV020 on 2017.06.29-17:36:08.
 */
class EchoTest : WebSocketListener() {
    lateinit var mainThread: Thread
    @Test
    fun echo() {
        mainThread = Thread.currentThread()
        val client = OkHttpClient.Builder()
                .readTimeout(0, TimeUnit.MILLISECONDS)
                .build()
        val request = Request.Builder()
                .url("ws://echo.websocket.org")
                .build()
        val webSocket = client.newWebSocket(request, this)
        webSocket.send("hello")
        client.dispatcher().executorService().shutdown()
        try {
            Thread.sleep(10000)
        }catch (ignore: InterruptedException) {
        }
    }

    override fun onOpen(webSocket: WebSocket?, response: Response?) {
        println("webSocket = [${webSocket}], response = [${response}]")
        webSocket?.apply {
            send("Hello...")
            send("...World!")
            send(ByteString.decodeHex("deadbeef"))
            close(1000, "Goodbye, World!")
        }
    }

    override fun onFailure(webSocket: WebSocket?, t: Throwable?, response: Response?) {
        println("webSocket = [${webSocket}], t = [${t}], response = [${response}]")
    }

    override fun onClosing(webSocket: WebSocket?, code: Int, reason: String?) {
        println("webSocket = [${webSocket}], code = [${code}], reason = [${reason}]")
        //大概是server端自动close时需要下面这句关闭服务器端？
        webSocket?.close(1000, null)
    }

    override fun onMessage(webSocket: WebSocket?, text: String?) {
        println("webSocket = [${webSocket}], text = [${text}]")
    }

    override fun onMessage(webSocket: WebSocket?, bytes: ByteString?) {
        println("webSocket = [${webSocket}], bytes = [${bytes?.hex()}]")
    }

    override fun onClosed(webSocket: WebSocket?, code: Int, reason: String?) {
        println("webSocket = [${webSocket}], code = [${code}], reason = [${reason}]")
        mainThread.interrupt()
    }
}