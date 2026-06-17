package go

import android.content.Context

object Seq {
    private var context: Context? = null

    fun setContext(value: Context?) {
        context = value
    }
}
