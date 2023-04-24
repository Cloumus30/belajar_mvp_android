package danapradana.belajarapp.login


interface LoginContract {

    interface Model {
        fun submitLogin(data: LoginReqData)
        fun getResponse():LoginResData?
    }

    interface Presenter{
        fun submitLogin(email: String, password:String)
        fun successLogin()
        fun onError(message:String?)
    }

    interface View{
        fun initView()
        fun onSuccessLogin()
        fun onError(message:String?)
    }
}