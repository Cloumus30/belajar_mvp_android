package danapradana.belajarapp.login

data class LoginResData(
    val access_token: String,
    val name: String,
    val user: UserData,
    val errors: List<Any>
)