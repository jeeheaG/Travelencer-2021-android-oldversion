package com.example.travelencer_android_2021.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.travelencer_android_2021.R
import kotlinx.android.synthetic.main.list_item_feed_course_detail.view.*

class FeedCourseDetailAdapter() : RecyclerView.Adapter<FeedCourseDetailAdapter.ViewHolder>() {
    var courseName = ArrayList<String>()
//    var areaName  = ArrayList<String>()
//    var date  = ArrayList<String>()

    // 뷰홀더 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedCourseDetailAdapter.ViewHolder {
        // list_item_feed_course_detail.xml 파일과 연결
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_feed_course_detail, parent, false)

        return ViewHolder(itemView).apply {
            itemView.setOnClickListener {
                Toast.makeText(parent.context, "${courseName[position].toString()}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // position 번째 아이템 설정하기
    override fun onBindViewHolder(holder: FeedCourseDetailAdapter.ViewHolder, position: Int) {
        holder.setItem(position)
    }

    // 아이템 갯수 리턴
    override fun getItemCount() = courseName.size

    // 데이터 넣어주기
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setItem(position: Int) {
            itemView.tvCourseName.text = courseName[position]
//            itemView.tvAreaName.text = areaName[position]
//            itemView.tvCourseName.text = date[position]

            // 맨 첫 번째, 맨 마지막 아이템은 선 지우기
            if (position == 0) itemView.imgFirst.visibility = View.INVISIBLE
            else if (position == itemCount-1) itemView.imgLast.visibility = View.INVISIBLE
        }
    }
}