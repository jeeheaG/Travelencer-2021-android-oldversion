package com.example.travelencer_android_2021.data

// 설정 변경

// 보낼 데이터(사진은 따로)
data class SettingChangeData (val UID : Int, val name : String, val info : String)
// 받을 데이터
data class SettingChangeResponse (val code : Int, val message : String)