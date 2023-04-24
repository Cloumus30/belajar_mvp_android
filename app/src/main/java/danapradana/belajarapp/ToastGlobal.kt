package danapradana.belajarapp

import android.content.Context
import android.view.Gravity
import com.pranavpandey.android.dynamic.toasts.DynamicToast

class ToastGlobal(private val context: Context, private val message:String?) {

    init {
        DynamicToast.Config.getInstance().setTextSize(20)
    }

    fun success(){
        val toast = DynamicToast.makeSuccess(this.context, this.message)
        toast.setGravity(Gravity.TOP, 0, 20)
        toast.show()
    }

    fun failed(){
        val toast = DynamicToast.makeError(this.context, this.message)
        toast.setGravity(Gravity.TOP, 0, 20)
        toast.show()
    }

    fun successWithDelay(delayTime: Int){

    }
}