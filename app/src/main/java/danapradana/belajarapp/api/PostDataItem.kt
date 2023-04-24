package danapradana.belajarapp.api

data class PostDataItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
):java.io.Serializable