package ca.psiphon

class PsiphonTunnel private constructor(private val hostService: HostService) : ca.psiphon.PsiphonTunnel.HostService {
    interface HostService {
        fun loadLibrary(library: String?) = Unit
        fun getContext(): android.content.Context = throw NotImplementedError()
        fun getPsiphonConfig(): String = "{}"
        fun bindToDevice(fileDescriptor: Long) = Unit
        fun onConnecting() = Unit
        fun onConnected() = Unit
        fun onExiting() = Unit
        fun onListeningSocksProxyPort(port: Int) = Unit
        fun onListeningHttpProxyPort(port: Int) = Unit
        fun onUpstreamProxyError(message: String?) = Unit
        fun onDiagnosticMessage(message: String?) = Unit
        fun onStartedWaitingForNetworkConnectivity() = Unit
        fun onStoppedWaitingForNetworkConnectivity() = Unit
        fun onClientRegion(region: String?) = Unit
        fun onConnectedServerRegion(region: String?) = Unit
    }

    companion object {
        fun newPsiphonTunnel(hostService: HostService): PsiphonTunnel = PsiphonTunnel(hostService)
    }

    fun setClientPlatformAffixes(clientPlatform: String, clientSuffix: String) = Unit
    fun setVpnMode(vpnMode: Boolean) = Unit
    fun startTunneling(serverEntries: String) = Unit
    fun stop() = Unit
}

object Tun2SocksJniLoader {
    fun loadLibrary() = Unit
    fun runTun2Socks(
        tunFd: Int,
        mtu: Int,
        netifIpAddr: String,
        netmask: String,
        ipv6Address: String?,
        socksServerAddress: String,
        udpgwServerAddress: String,
        enableTransparentDns: Int
    ) = Unit
    fun terminateTun2Socks() = Unit
}
