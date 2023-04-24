package danapradana.belajarapp.api

import retrofit2.Call
import retrofit2.http.GET

interface PostService {
    @GET("posts")
    fun listPost(): Call<List<PostDataItem>>

}