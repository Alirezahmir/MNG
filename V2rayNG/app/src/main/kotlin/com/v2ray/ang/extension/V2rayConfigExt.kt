package com.v2ray.ang.extension

import com.v2ray.ang.dto.V2rayConfig

fun V2rayConfig.OutboundBean.populateMux(stat: String, concr: String = "8") {
    val enabled = stat.equals("ON", true)
    if (mux == null) mux = V2rayConfig.OutboundBean.MuxBean(enabled = enabled)
    mux?.enabled = enabled
    if (concr.toIntOrNull() != null) {
        mux?.concurrency = concr.toInt()
    }
}

fun V2rayConfig.OutboundBean.OutSettingsBean.populateFragment(
    packets: String,
    length: String? = null,
    interval: String? = null,
    fakehost_domain: String? = null
) {
    fragment = V2rayConfig.OutboundBean.OutSettingsBean.FragmentBean(
        packets = packets,
        length = length,
        interval = interval
    )
    if (packets == "fakehost" && !fakehost_domain.isNullOrEmpty()) {
        noises = listOf(
            V2rayConfig.OutboundBean.OutSettingsBean.NoiseBean(
                type = "rand",
                packet = fakehost_domain,
                delay = "0"
            )
        )
    }
}
