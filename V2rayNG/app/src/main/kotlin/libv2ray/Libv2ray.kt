package libv2ray

object Libv2ray {
    fun newV2RayPoint(callback: V2RayVPNServiceSupportsSet, enableTun: Boolean): V2RayPoint = V2RayPoint()
    fun initV2Env(assetPath: String) = Unit
    fun measureOutboundDelay(config: String): Long = -1L
    fun measureDelay(config: String): Long = -1L
    fun queryStats(tag: String): String = ""
    fun checkVersionX(): String = "stub"
}

class V2RayPoint {
    var configureFileContent: String = ""
    var domainName: String = ""
    var isRunning: Boolean = false

    fun runLoop(preferIpv6: Boolean) {
        isRunning = true
    }

    fun stopLoop() {
        isRunning = false
    }

    fun measureDelay(): Long = -1L

    fun queryStats(tag: String, direct: String): Long = 0L
}

interface V2RayVPNServiceSupportsSet {
    fun shutdown(): Long
    fun prepare(): Long
    fun protect(l: Long): Boolean
    fun onEmitStatus(l: Long, s: String?): Long
    fun setup(s: String): Long
}
