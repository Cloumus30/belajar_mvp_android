package danapradana.belajarapp.api

import android.util.Log
import danapradana.belajarapp.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostModel(_presenter : PostPresenter) : ApiContract.Model {
    private val retrofitService: PostService = RetrofitBuilder().retro.create(PostService::class.java)
    private var listPost : List<PostDataItem>? = null
    private val presenter: PostPresenter = _presenter

    override fun listPostData() {
        val service = retrofitService.listPost()
        service.enqueue(object : Callback<List<PostDataItem>>{
            override fun onResponse(
                call: Call<List<PostDataItem>>,
                response: Response<List<PostDataItem>>
            ) {
                if(response.isSuccessful){
                    listPost = response.body()
                    presenter.updateListPostData()
                }
            }

            override fun onFailure(call: Call<List<PostDataItem>>, t: Throwable) {
                Log.e("api", t.message!!)
            }
        })
    }

    override fun getPostData(): List<PostDataItem>? {
        return this.listPost
    }
}