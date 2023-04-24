package danapradana.belajarapp.api

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import danapradana.belajarapp.R
import org.w3c.dom.Text

class ListPostAdapter(val context :  Context, val postData : List<PostDataItem>) : BaseAdapter() {
    override fun getCount(): Int {
        return postData.size
    }

    override fun getItem(position: Int): PostDataItem {
        return postData.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // inflate the layout for each list row
        var convertView: View? = convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
            inflate(R.layout.list_post_custom, parent, false)
        }

        val item : PostDataItem = getItem(position)

        val titlePostTextView = convertView?.findViewById(R.id.postTitleTextView) as TextView
        val idPostTextView = convertView?.findViewById<TextView>(R.id.idPostTextView) as TextView
        val bodyPostTextView = convertView?.findViewById<TextView>(R.id.bodyPostTextView)

        titlePostTextView.text = item.title
        idPostTextView.text = item.id.toString()
        bodyPostTextView?.text = item.body

        return convertView
    }

}