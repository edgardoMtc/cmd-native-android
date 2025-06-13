package com.example.cmd_native

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.text.*


class MainActivity : AppCompatActivity() {
    private lateinit var rdFromKm: RadioButton
    private lateinit var rdFromMiles: RadioButton
    private lateinit var textValue: EditText
    private lateinit var textResult: EditText
    private lateinit var appContext: Context
    // private var testAdUnitPath: String = "/21775744923/example/adaptive-banner"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rdFromKm = findViewById(R.id.rbKm)
        rdFromMiles = findViewById(R.id.rbMiles)
        textValue = findViewById(R.id.textValue)
        textResult = findViewById(R.id.textResult)


    }

    fun handleClick(view: View) {
        when (view.id) {
            (R.id.buttonConvert) -> {
               val value = textValue.text.toString()
                if (value.isEmpty()) {
                    val context = appContext.applicationContext
                    val errorText = "Error: Empty value!"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(context, errorText, duration)
                    toast.show()

                } else {
                    val result: String = if (rdFromKm.isChecked) {
                        kmToMiles(value)
                    } else {
                        milesToKM(value)
                    }
                    textResult.setText(result)
                }
            }

            (R.id.buttonReset) -> {
                rdFromKm.isChecked = false
                rdFromMiles.isChecked = false
                textValue.text.clear()
                textResult.text.clear()
            }
        }
    }

    private fun milesToKM(miles: String): String {
        val mValue = miles.toDouble()
        val kmValue = mValue * 1.609
        return kmValue.toString()
    }

    private fun kmToMiles(km: String): String {
        val kValue = km.toDouble()
        val mValue = kValue / 1.609
        return mValue.toString()
    }
//    private fun loadBanner() {
//        // [START create_ad_view]
//        // Create a new ad view.
//        val adView = AdManagerAdView(this)
//        adView.adUnitId = "/21775744923/example/adaptive-banner"
//        // [START set_ad_size]
//        // Request an anchored adaptive banner with a width of 360.
//        adView.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, 360))
//        // [END set_ad_size]
//        this.adView = adView
//
//        // Replace ad container with new ad view.
//        binding.adViewContainer.removeAllViews()
//        binding.adViewContainer.addView(adView)
//        // [END create_ad_view]
//
//        // [START load_ad]
//        val adRequest = AdManagerAdRequest.Builder().build()
//        adView.loadAd(adRequest)
//        // [END load_ad]
//    }
//
//    private fun initializeMobileAdsSdk() {
//        if (isMobileAdsInitializeCalled.getAndSet(true)) {
//            return
//        }
//
//        // Set your test devices.
//        MobileAds.setRequestConfiguration(
//            RequestConfiguration.Builder().setTestDeviceIds(listOf(TEST_DEVICE_HASHED_ID)).build()
//        )
//
//        // [START initialize_sdk]
//        CoroutineScope(Dispatchers.IO).launch {
//            // Initialize the Google Mobile Ads SDK on a background thread.
//            MobileAds.initialize(this@MyActivity) {}
//            // [START_EXCLUDE silent]
//            runOnUiThread {
//                // Load an ad on the main thread.
//                loadBanner()
//            }
//            // [END_EXCLUDE]
//        }
//        // [END initialize_sdk]
//    }

//    private fun loadBanner () {
//        // Create a new ad view.
//        val adView = AdManagerAdView(this)
//        adView.adUnitId = AD_UNIT_ID
//        // Request an anchored adaptive banner with a width of 360.
//        adView.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, 360))
//        this.adView = adView
//
//        // Replace ad container with new ad view.
//        binding.adViewContainer.removeAllViews()
//        binding.adViewContainer.addView(adView)
//    }
}

