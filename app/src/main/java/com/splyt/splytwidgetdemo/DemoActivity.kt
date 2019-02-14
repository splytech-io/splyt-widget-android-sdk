package com.splyt.splytwidgetdemo

import com.splyt.splytwidgetsdk.activities.SWWidgetActivity
import com.splyt.splytwidgetsdk.models.SWBooking
import com.splyt.splytwidgetsdk.models.SWUser

class DemoActivity: SWWidgetActivity() {

    override fun splytWidgetAddPaymentMethod(user: SWUser) {
        // Take your user to an add payment screen.
    }

    override fun splytWidgetRaiseBookingIssue(booking: SWBooking) {
        // Take your user to a booking issue screen.
    }

    override fun splytWidgetRequestAccessToken(callback: (token: String) -> Unit) {
        // Return a token
        callback("test-token")
    }

    override fun splytWidgetUserNotRegistered() {
        // Take your use to a registration section.
    }

    override fun splytWidgetAuthorizationFailed() {
        // Close the widget or inform your user an error has occurred.
    }
}