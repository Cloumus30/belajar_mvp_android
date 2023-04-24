package danapradana.belajarapp.api

interface ApiContract {
    interface Model{
        fun listPostData()
        fun getPostData() : List<PostDataItem>?
    }

    interface Presenter{
        fun getListPost()
    }

    interface View{
        fun initView()
        fun updateView()
    }
}