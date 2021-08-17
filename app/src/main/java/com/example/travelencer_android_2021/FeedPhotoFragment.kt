package com.example.travelencer_android_2021

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.travelencer_android_2021.adapter.FeedPhototAdapter
import com.example.travelencer_android_2021.databinding.FragmentFeedPhotoBinding
import com.example.travelencer_android_2021.model.ModelFeedPhoto

// 여행 피드 - 사진 탭
class FeedPhotoFragment : Fragment() {
    private lateinit var binding : FragmentFeedPhotoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentFeedPhotoBinding.inflate(inflater, container, false)

        // 격자 레이아웃 생성
        binding.rcFeedPhoto.layoutManager = GridLayoutManager(activity, 3)
        // 어댑터 달기
        val feedPhototAdapter = FeedPhototAdapter()
        binding.rcFeedPhoto.adapter = feedPhototAdapter

        feedPhototAdapter.items.add(ModelFeedPhoto("data:image/jpeg;base64,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", "1"))
        feedPhototAdapter.items.add(ModelFeedPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-HiTYyq5rKMN4A_z2V24u1P3xrw3x8s-H6Ppbe21K7CCgdxSvBFzOF-0OUVnig08TVds&usqp=CAU", "2"))
        feedPhototAdapter.items.add(ModelFeedPhoto("https://pbs.twimg.com/profile_images/1107050488476819457/zn7BJ9Q6.jpg", "3"))
        feedPhototAdapter.items.add(ModelFeedPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbWtUpuVhoPd4eSzs1Q6eXT7SkrtQ6eo93Dw&usqp=CAU", "4"))
        feedPhototAdapter.items.add(ModelFeedPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbWtUpuVhoPd4eSzs1Q6eXT7SkrtQ6eo93Dw&usqp=CAU", "5"))
        feedPhototAdapter.items.add(ModelFeedPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbWtUpuVhoPd4eSzs1Q6eXT7SkrtQ6eo93Dw&usqp=CAU", "6"))
        feedPhototAdapter.items.add(ModelFeedPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbWtUpuVhoPd4eSzs1Q6eXT7SkrtQ6eo93Dw&usqp=CAU", "7"))
        feedPhototAdapter.items.add(ModelFeedPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbWtUpuVhoPd4eSzs1Q6eXT7SkrtQ6eo93Dw&usqp=CAU", "8"))
        feedPhototAdapter.items.add(ModelFeedPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbWtUpuVhoPd4eSzs1Q6eXT7SkrtQ6eo93Dw&usqp=CAU", "9"))
        feedPhototAdapter.items.add(ModelFeedPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbWtUpuVhoPd4eSzs1Q6eXT7SkrtQ6eo93Dw&usqp=CAU", "10"))

        return binding.root
    }
}