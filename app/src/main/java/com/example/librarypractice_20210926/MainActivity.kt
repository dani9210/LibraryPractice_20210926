package com.example.librarypractice_20210926

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callBtn.setOnClickListener {



//            Intent(4) 바로 전화 연결 -> cAll 액션

            val myUri = Uri.parse("tel:010-5555-6666")
            val myintent = Intent( Intent.ACTION_CALL, myUri)




        }



        profileImg.setOnClickListener{


//            다른화면으로 이동 =>  사진 크게 보기


            val myIntent = Intent(this, ViewPhotoActivity::class.java)
            startActivity(myIntent)



        }


    }
}