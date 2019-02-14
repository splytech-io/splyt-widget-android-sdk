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

        val user       = SWUser()
        user.id        = "12345"
        user.firstName = "Test"
        user.lastName  = "User"
        user.phone     =  "+441732123456"
        user.email     = "test.user@test.com"

        val paymentCard = SWPaymentCard("123", SWCardType.Visa, "12345", "04", "21")

        val builder = SWRideParameters.Builder()
                .setUser(user)
                .setPickupLocation(SWLocation(48.864194, 2.343618, "Default"))
                .setPaymentCards(arrayOf(paymentCard))
                .setClientBookingId("your internal booking id")
                .setFlightNumber("example flight number")

        val config = SWConfiguration.Builder()
                .setPartnerId("your-partner-id")
                .setSandbox(true)
                .setRequestLocationPermission(true)
                .setRequestNotificationPermission(true)
                .setDefaultLocation(SWLocation(48.864194, 2.343618, "Default"))
                .setCurrencyCode("GBP")
                .setLocale("en-gb")
                .setBrandColors(SWColors("#d8171d", "#ffffff", "#ddd"))
                .setRideParameters(builder.build())

        SplytWidget.presentWidget(this, DemoActivity::class.java, config.build()) {
            print(it?.toString())
        }
    }

    fun fetchUserBooking() {
        val user       = SWUser()
        user.id        = "12345"
        user.firstName = "Test"
        user.lastName  = "User"
        user.phone     =  "+441732123456"
        user.email     = "test.user@test.com"

        SplytWidget.fetchActiveBooking(user, "example-token") {
            booking, error ->
        }
    }
}
