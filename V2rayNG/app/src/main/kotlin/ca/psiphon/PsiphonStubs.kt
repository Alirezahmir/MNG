package ca.psiphon

abstract class PsiphonTunnel {
    abstract class HostService {
        open fun loadLibrary(library: String?) = Unit
        open fun getContext(): android.content.Context = throw NotImplementedError()
        open fun getPsiphonConfig(): String = "{}"
        open fun bindToDevice(fileDescriptor: Long) = Unit
        open fun onConnecting() = Unit
        open fun onConnected() = Unit
        open fun onExiting() = Unit
        open fun onListeningSocksProxyPort(port: Int) = Unit
        open fun onListeningHttpProxyPort(port: Int) = Unit
        open fun onUpstreamProxyError(message: String?) = Unit
        open fun onDiagnosticMessage(message: String?) = Unit
        open fun onStartedWaitingForNetworkConnectivity() = Unit
        open fun onStoppedWaitingForNetworkConnectivity() = Unit
        open fun onClientRegion(region: String?) = Unit
        open fun onConnectedServerRegion(region: String?) = Unit
    }
}

object Tun2SocksJniLoader {
    fun loadLibrary() = Unit
}
