package com.splyt.splytwidgetdemo

import com.splyt.splytwidgetsdk.activities.SWWidgetActivity
import com.splyt.splytwidgetsdk.models.SWBooking

class DemoActivity: SWWidgetActivity() {

    override fun splytWidgetAddPaymentMethod() {
        // Take your user to an add payment screen.
    }

    override fun splytWidgetRaiseBookingIssue(booking: SWBooking) {
        // Take your user to a booking issue screen.
    }

    override fun splytWidgetRequestAccessToken(callback: (token: String) -> Unit) {
        // Return a token
        callback("test-token")
    }
}