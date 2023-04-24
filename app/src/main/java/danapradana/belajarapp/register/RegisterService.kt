package danapradana.belajarapp.register

import danapradana.belajarapp.login.UserData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterService {
    @POST("user/register")
    fun registerUser(@Body user: UserData) : Call<Any>
}