package danapradana.belajarapp.register

import android.view.View
import danapradana.belajarapp.login.UserData

class RegisterPresenter (_view : RegisterActivity) {
    private val view = _view
    private val model = RegisterModel(this)

    fun submitRegister(data: UserData){
        model.submitRegister(data)
    }

    fun onSuccessRegister(message:String){
        this.view.onSuccess(message)
    }

    fun onError(message: String){
        this.view.onFailed(message)
    }
}