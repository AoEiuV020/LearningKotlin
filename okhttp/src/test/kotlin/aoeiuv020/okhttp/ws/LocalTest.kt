package aoeiuv020.okhttp.ws

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import org.junit.Test
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.Proxy
import java.util.concurrent.TimeUnit

/**
 * Created by AoEiuV020 on 2017.06.29-20:41:25.
 */
class LocalTest : WebSocketListener() {
    @Test
    fun local() {
        val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress(InetAddress.getByName("localhost"), 8080))
        val client = OkHttpClient.Builder()
                .readTimeout(0, TimeUnit.MILLISECONDS)
                .proxy(proxy)
                .build()
        val request = Request.Builder()
                .url("ws://localhost:8081")
                .build()
        val webSocket = client.newWebSocket(request, object : PrintListener(Thread.currentThread()) {
            override fun onMessage(webSocket: WebSocket?, text: String?) {
                super.onMessage(webSocket, text)
                text?.takeIf { it.length > 1 }
                        ?.substring(0, text.length - 1)
                        ?.let { s ->
                            webSocket?.apply {
                                send(s)
                            }
                        }
                        ?: webSocket?.close(1000, "sent all")
            }
        })
        println(System.currentTimeMillis())
        webSocket.send("hello")
        println(System.currentTimeMillis())
        client.dispatcher().executorService().shutdown()
        try {
            Thread.sleep(10000)
        } catch (ignore: InterruptedException) {
        }
        webSocket.close(1000, "timeout")
    }
}