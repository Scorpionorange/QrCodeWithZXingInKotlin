package com.example.qrcodewithzxinginkotlin

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var codeBmp:Bitmap? = null
    private var input:String? = null
    private var timeStamp:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initString()
        generate.setOnClickListener { testingOutput.text = input }
        autoTimeStamp.setOnClickListener { testingOutput.text = timeStamp }
    }

    fun initString(){
        input = content.text.toString()
        timeStamp = getNow()
    }

    fun getNow():String{
        if(android.os.Build.VERSION.SDK_INT >= 24){
            return SimpleDateFormat("yyyyMMddHHmm").format(Date())
        }
        else{
            var tms = Calendar.getInstance()
            return tms.get(Calendar.YEAR).toString()+
                    tms.get(Calendar.MONTH).toString()+
                    tms.get(Calendar.DAY_OF_MONTH).toString()+
                    tms.get(Calendar.HOUR_OF_DAY).toString()+
                    tms.get(Calendar.MINUTE)
        }
    }

    fun createQRImage(content: String?): Bitmap? {
        return codeBmp
    }
}
