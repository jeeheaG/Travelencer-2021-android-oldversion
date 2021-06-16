package com.example.travelencer_android_2021.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.travelencer_android_2021.R
import com.example.travelencer_android_2021.model.ModelFeedSights
import kotlinx.android.synthetic.main.list_item_feed_food.view.*

class FeedSightsAdapter : RecyclerView.Adapter<FeedSightsAdapter.ViewHolder>() {
    // ModelFeedSights 배열
    var items = ArrayList<ModelFeedSights>()

    // 뷰홀더 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedSightsAdapter.ViewHolder {
        // list_item_feed_sights.xml 파일과 연결
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_feed_sights, parent, false)

        return ViewHolder(itemView).apply {
            itemView.setOnClickListener {
                Toast.makeText(parent.context, "${items[position].name}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // position 번째 아이템 설정하기
    override fun onBindViewHolder(holder: FeedSightsAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

    // 아이템 갯수 리턴
    override fun getItemCount() = items.size

    // ModelFeedFood 클래스에 데이터 넣어주기
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setItem(item: ModelFeedSights) {
            itemView.tvName.text = item.name
            itemView.tvLocation.text = item.location
        }
    }
}