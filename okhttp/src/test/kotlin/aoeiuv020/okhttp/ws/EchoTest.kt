package aoeiuv020.okhttp.ws

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okio.ByteString
import org.junit.Test
import java.util.concurrent.TimeUnit

/**
 * 复制自okhttp官方test
 * https://github.com/square/okhttp/blob/master/samples/guide/src/main/java/okhttp3/recipes/WebSocketEcho.java
 * Created by AoEiuV020 on 2017.06.29-17:36:08.
 */
class EchoTest {
    @Test
    fun echo() {
        val client = OkHttpClient.Builder()
                .readTimeout(0, TimeUnit.MILLISECONDS)
                .build()
        val request = Request.Builder()
                .url("ws://echo.websocket.org")
                .build()
        val webSocket = client.newWebSocket(request, object : PrintListener(Thread.currentThread()) {
            override fun onOpen(webSocket: WebSocket?, response: Response?) {
                super.onOpen(webSocket, response)
                webSocket?.apply {
                    send("Hello...")
                    send("...World!")
                    send(ByteString.decodeHex("deadbeef"))
                    close(1000, "Goodbye, World!")
                }
            }
        })
        webSocket.send("hello")
        client.dispatcher().executorService().shutdown()
        try {
            Thread.sleep(10000)
        } catch (ignore: InterruptedException) {
        }
    }

}