package danapradana.belajarapp.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import danapradana.belajarapp.R

class DetailPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_post)
        
        var data = intent.extras?.get("post") as PostDataItem
        Log.i("coba", data.id.toString())
    }
}