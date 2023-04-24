package danapradana.belajarapp.counter.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import danapradana.belajarapp.R
import danapradana.belajarapp.api.ListPostActivity
import danapradana.belajarapp.counter.contract.CounterContract
import danapradana.belajarapp.counter.presenter.CounterPresenter

class MainActivity : AppCompatActivity(), CounterContract.View {
    private lateinit var countTextView : TextView
    private lateinit var countButton: Button
    private lateinit var listPostButton: Button
    private lateinit var presenter: CounterContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.presenter = CounterPresenter(this)
        initView()
    }

    override fun initView() {
        this.countTextView = findViewById(R.id.countTextView)
        this.countButton = findViewById(R.id.countButton)
        this.listPostButton = findViewById(R.id.listPostButton)

        countButton.setOnClickListener{
            this.presenter.countUp()
        }

        listPostButton.setOnClickListener{
            val intent = Intent(this,ListPostActivity::class.java)
            startActivity(intent)
        }

        this.countTextView.text = presenter.getCount()
    }

    override fun updateView() {
        this.countTextView.text = presenter.getCount()
    }
}