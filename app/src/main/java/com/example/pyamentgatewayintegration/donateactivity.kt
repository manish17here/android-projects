package com.example.pyamentgatewayintegration

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject

 class donateactivity : AppCompatActivity() ,PaymentResultListener  {

    lateinit var editamount: EditText
    lateinit var donatenow2: Button
    lateinit var paymentStatus:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donateactivity)

         donatenow2 = findViewById<Button>(R.id.donate_now2)
        editamount= findViewById(R.id.donateedittext)
        paymentStatus=findViewById(R.id.pay_status)
        donatenow2.setOnClickListener{
            paymentProcess(editamount.text.toString().trim().toInt())

        }
        Checkout.preload(this@donateactivity)
    }

     private fun paymentProcess(amount: Int) {
         val checkout=Checkout()
         checkout.setKeyID("rzp_test_t69pX3JiMX42wO")

         try {
             val options=JSONObject()
             options.put("name","Sparks Foundation")
             options.put("Description","Help it up")
             options.put("image", "https://internship.thesparksfoundation.info/assests/img/logo.png")
             options.put("theme.color", "#528FF0")
             options.put("currency","INR")
             options.put("amount","${amount*100}")

             val retryObj=JSONObject()
             retryObj.put("enabled",true)
             retryObj.put("max_count",4)
             retryObj.put("retry", retryObj)

             val prefill = JSONObject()
             prefill.put("email","manishmdeshpande17@gmail.com")
             prefill.put("contact","9518398433")

             checkout.open(this@donateactivity,options)

         }
         catch (e:Exception  ){
             Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()

         }

     }

     override fun onPaymentSuccess(p0: String?) {
         paymentStatus.text=p0
         paymentStatus.setTextColor(Color.GREEN)

     }

     override fun onPaymentError(p0: Int, p1: String?) {
         paymentStatus.text=p1
         paymentStatus.setTextColor(Color.RED)

     }

 }



