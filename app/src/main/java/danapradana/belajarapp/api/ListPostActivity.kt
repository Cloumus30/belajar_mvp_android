package danapradana.belajarapp.api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import danapradana.belajarapp.R

class ListPostActivity : AppCompatActivity(), ApiContract.View {

    private lateinit var postListView : ListView
    private lateinit var presenter: PostPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_post)
        setTitle("List Post")

        this.presenter = PostPresenter(this)
        this.initView()

    }

    override fun initView() {
        this.postListView = findViewById(R.id.postListView)
        this.presenter.getListPost()
    }

    override fun updateView() {
        val data = presenter.showListPost()
        val adapter = data?.let { ListPostAdapter(this, it) }
        this.postListView.adapter = adapter

        this.postListView.setOnItemClickListener{ parent, view, position, id ->
            val element = adapter?.getItem(position)
            val intent = Intent(this, DetailPostActivity::class.java)
            intent.putExtra("post", element )
            startActivity(intent)
        }
    }
}