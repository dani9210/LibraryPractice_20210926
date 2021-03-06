package com.example.librarypractice_20210926

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val imageURL = "http://newsimg.hankookilbo.com/cms/articlerelease/2020/01/29/202001291565712283_1.jpg"


//        인터넷주소에 있는 이미지를-> actionImg에 보여주기 (Glide) ->인터넷다운 (데이터요금 사용) -> 권한필요

        Glide.with(this).load(imageURL).into(actionImg)


         callBtn.setOnClickListener {


//            권한 획득 여부에 따른 행동 방안 정리.

            val pl = object : PermissionListener  {


                override fun onPermissionGranted() {

//                    권한이 OK되었을때 할 일
//                    실제로 전화를 걸자.

                    //            Intent(4) 바로 전화 연결 -> cAll 액션

                    val myUri = Uri.parse("tel:010-5555-6666")
                    val myIntent = Intent( Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)




                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {


//                    권한이 거절되었을때. => 보통 토스트

                    Toast.makeText(this@MainActivity, "권한이 거절되어 전화 연결이 불가합니다.", Toast.LENGTH_SHORT).show()

                }


            }

//                    pl에 적혀있는 가이드를 들고 => 실제 권한 확인

            TedPermission.create()
                .setPermissionListener(pl)
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()









        }





        profileImg.setOnClickListener{


//            다른화면으로 이동 =>  사진 크게 보기


            val myIntent = Intent(this, ViewPhotoActivity::class.java)
            startActivity(myIntent)



        }


    }
}