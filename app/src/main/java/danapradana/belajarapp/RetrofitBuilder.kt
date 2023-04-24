package danapradana.belajarapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
     val retro : Retrofit = Retrofit.Builder()
        .baseUrl("http://api-android.dummy.cloudias.my.id")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}