package com.v2ray.ang.gfwknocker

import android.content.Context
import com.tencent.mmkv.MMKV

class my_preference_storage(context: Context? = null) {
    private val storage = MMKV.mmkvWithID("gfwknocker_preferences")

    fun get_value(key: String, default: String = ""): String = storage.decodeString(key, default) ?: default

    fun put_value(key: String, value: String) {
        storage.encode(key, value)
    }

    fun put_array(key: String, value: Array<String>) {
        storage.encode(key, value.joinToString("\u001F"))
    }

    fun get_array(key: String): Array<String> {
        val value = storage.decodeString(key, "") ?: ""
        return if (value.isEmpty()) emptyArray() else value.split("\u001F").toTypedArray()
    }
}

class config_pkg_reader(
    private val url: String,
    private val fileName: String,
    private val context: Context
) {
    fun fetch_json_config(useSharedPreference: Boolean) = Unit

    fun get_offline_DNS(isp: String): MutableMap<String, Any> = mutableMapOf("google.com" to "8.8.8.8")

    fun get_doh_url(isp: String): String = "https://dns.google/dns-query"

    fun get_doh_ip(isp: String): String = "8.8.8.8"

    fun get_doh_CF_flag(isp: String): Boolean = false
}

class GFW_sutil {
    fun util_get_string(key: String, default: String = ""): String = default
}

class GFW_txt_crypt {
    fun decode(text: String): String = text
    fun encode(text: String): String = text
}

object wget_module {
    @JvmStatic
    fun auto_routed_fetch_remote_text(url: String?): String = ""
}

object GFW_client_ip {
    @JvmStatic
    fun countryCodeToFlag(code: String?): String = ""

    @JvmStatic
    fun countryCodeToName(code: String?): String = ""
}
