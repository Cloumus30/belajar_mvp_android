package danapradana.belajarapp.register

import android.util.Log
import com.google.gson.Gson
import danapradana.belajarapp.ErrorData
import danapradana.belajarapp.RetrofitBuilder
import danapradana.belajarapp.login.UserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterModel( _presenter: RegisterPresenter ) {
    private val retro = RetrofitBuilder().retro.create(RegisterService::class.java)
    private val presenter = _presenter

    fun submitRegister(data: UserData){
        val regis = this.retro.registerUser(data)
        regis.enqueue(object: Callback<Any>{
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                val gson = Gson()
                if(response.isSuccessful){
                    Log.i("api", "Success Regis")
                    presenter.onSuccessRegister("Success Register, Please Login")
                }else{
                    val errorBody = gson.fromJson<ErrorData>(response.errorBody()?.string(),ErrorData::class.java)
                    Log.e("api", errorBody.errors[0])
                    //response.errorBody()?.let { Log.e("api", it.string()) }
                    presenter.onError(errorBody.errors[0])
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                t.message?.let {
                    Log.e("api", it)
                    presenter.onError(it)
                }

            }

        })
    }

}