package danapradana.belajarapp.api

class PostPresenter(_view: ApiContract.View) : ApiContract.Presenter {

    private val model = PostModel(this)
    private val view = _view

    override fun getListPost() {
        model.listPostData()
    }

    fun updateListPostData(){
        this.view.updateView()
    }

    fun showListPost() : List<PostDataItem>?{
        return model.getPostData()
    }
}