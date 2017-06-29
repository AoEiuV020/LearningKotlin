package aoeiuv020.okhttp.ws

import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString

/**
 * Created by AoEiuV020 on 2017.06.29-20:49:39.
 */
open class PrintListener(val mainThread: Thread) : WebSocketListener() {
    override fun onOpen(webSocket: WebSocket?, response: Response?) {
        println("webSocket = [${webSocket}], response = [${response}]")
    }

    override fun onFailure(webSocket: WebSocket?, t: Throwable?, response: Response?) {
        println("webSocket = [${webSocket}], t = [${t}], response = [${response}]")
        mainThread.interrupt()
    }

    override fun onClosing(webSocket: WebSocket?, code: Int, reason: String?) {
        println("onClosing webSocket = [${webSocket}], code = [${code}], reason = [${reason}]")
        //大概是服务器端close时需要下面这句关闭客户器端？
        webSocket?.close(1000, null)
    }

    override fun onMessage(webSocket: WebSocket?, text: String?) {
        println("webSocket = [${webSocket}], text = [${text}]")
    }

    override fun onMessage(webSocket: WebSocket?, bytes: ByteString?) {
        println("webSocket = [${webSocket}], bytes = [${bytes?.hex()}]")
    }

    override fun onClosed(webSocket: WebSocket?, code: Int, reason: String?) {
        println("onClosed webSocket = [${webSocket}], code = [${code}], reason = [${reason}]")
        mainThread.interrupt()
    }
}