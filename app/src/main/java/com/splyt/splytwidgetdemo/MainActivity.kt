package com.splyt.splytwidgetdemo

import android.app.Activity
import android.os.Bundle
import com.splyt.splytwidgetsdk.SplytWidget
import com.splyt.splytwidgetsdk.models.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val builder = SWRideParameters.Builder()
                .setUserId("test-user-id")
                .setPickupLocation(SWLocation(48.864194, 2.343618)) // Optional
                .setClientBookingId("your internal booking id") // Optional
                .setFlightNumber("example flight number") // Optional

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
