package danapradana.belajarapp.login

import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import danapradana.belajarapp.ErrorData
import danapradana.belajarapp.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginModel(_presenter:LoginPresenter) : LoginContract.Model {

    private val loginService: LoginService = RetrofitBuilder().retro.create(LoginService::class.java)
    private val presenter = _presenter
    private lateinit var responseBody : LoginResData

    override fun submitLogin(data: LoginReqData) {
        val loginServ = this.loginService.loginUser(data)
        loginServ.enqueue(object : Callback<LoginResData>{
            override fun onResponse(call: Call<LoginResData>, response: Response<LoginResData>) {
                val gson = Gson()
                if(response.isSuccessful){
                    response.body()?.let { responseBody = it }
                    Log.i("success", responseBody.toString())
                    presenter.successLogin()
                }else{
                    val errorBody = gson.fromJson<ErrorData>(response.errorBody()?.string(),ErrorData::class.java)
                    presenter.onError(errorBody.errors[0])
                }


            }

            override fun onFailure(call: Call<LoginResData>, t: Throwable) {
                t.message?.let { Log.e("error", it) }
            }

        })
    }

    override fun getResponse(): LoginResData {
        return responseBody
    }

}