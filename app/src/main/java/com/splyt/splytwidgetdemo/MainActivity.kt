package com.splyt.splytwidgetdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.splyt.splytwidgetsdk.SWCardType
import com.splyt.splytwidgetsdk.SplytWidget
import com.splyt.splytwidgetsdk.models.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val builder = SWRideParameters.Builder()
                .setUserId("test-user-id")
                .setPickupLocation(SWLocation(48.864194, 2.343618))
                .setClientBookingId("your internal booking id")
                .setFlightNumber("example flight number")

        val config = SWConfiguration.Builder()
                .setPartnerId("your-splyt-partner-id")
                .setSandbox(true)
                .setRequestLocationPermission(true)
                .setDefaultLocation(SWLocation(48.864194, 2.343618))
                .setLocale("en-gb")
                .setPrimaryColor("#13d0e9")
                .setRideParameters(builder.build())

        SplytWidget.presentWidget(this, DemoActivity::class.java, config.build()) {
            print(it?.toString())
        }
    }
}
