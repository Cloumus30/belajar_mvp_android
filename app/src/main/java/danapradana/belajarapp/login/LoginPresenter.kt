package danapradana.belajarapp.login

import android.widget.EditText
import android.widget.Toast

class LoginPresenter(_view:LoginActivity) : LoginContract.Presenter {
    private val view = _view
    private val model = LoginModel(this)

    override fun submitLogin(email: String, password:String) {
        val data = LoginReqData(email, password)
        this.model.submitLogin(data)
    }

    override fun successLogin() {
        this.view.onSuccessLogin()
    }

    override fun onError(message:String?){
        this.view.onError(message)
    }
}