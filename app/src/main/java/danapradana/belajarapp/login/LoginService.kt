package danapradana.belajarapp.login

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("user/login")
    open fun loginUser(@Body user: LoginReqData): Call<LoginResData>
}