# SplytWidgetSDK

The `SplytWidgetSDK` allows you to easily make ride hailing available to users of your app. Using the `SplytWidgetSDK` you can present your users with a clean, simple and logical booking interface.

For detailed instructions [please read our documentation](https://developer.splytech.io/widget/) as well as the [SDK class reference](https://developer.splytech.io/widget/android/index.html). Otherwise, please get in touch with us at [widget@splyech.io](mailto:widget@splytech.io).

## Installing

Before installing the SplytWidgetSDK, you will need your **PartnerId**.  If you haven't received this, please contact Splyt who will be happy to provide this for you.  

The SplytWidgetSDK is most easily installed using Maven.  To use Maven, please add a link to our project.

```
allprojects {
    repositories {
        maven { url 'https://dl.bintray.com/splyttechnologies/maven' }
    }
}
```

Then add in your apps build.gradle, add a link to our package.

```
implementation 'com.splyt:splytwidgetsdk:1.0.4'
```

## How to use the SplytWidgetSDK

In order to add the widget to your application you should create an activity which is a direct subclass of `SWWidgetActivity`.  `SWWidgetActivity` is a abstract class, which requires you to implement a set of abstract methods.  These are used to allow communication between the widget and your app. You should never start this activity directly, as it will not launch.  Please use the `presentWidget` method explained below.

The SplytWidgetSDK contains a static class named `SplytWidget`.  To launch the `SplytWidget` you must call the `presentWidget` method.  This method takes 3 parameters.  The first parameter is a context, used to start an activity.  The second parameter is a class reference to your subclass of `SWWidgetActivity`.  The next parameter is an instance of `SWConfiguration`.  The last parameter is a callback, which will receive an error indicating any validation or configuration issues with your implementation.

### Example

```
SplytWidget.presentWidget(this, DemoActivity::class.java, config.build()) {
    print(it?.toString())
}
```

## Configuring the SplytWidget

When presenting the SplytWidget you are required to pass an instance of `SWConfiguration`. To create the `SWConfiguration` you should use the `SWConfigurationBuilder`.  The `SWConfiguration` model allows you to fine tune the widget for you app.

### Example

```
val user = SWUser()
user.id        = "12345"
user.firstName = "Test"
user.lastName  = "User"
user.phone     =  "+441732123456"
user.email     = "test.user@test.com"

val paymentMethod = SWCustomPaymentMethod("123", "12345")
var paymentCard = SWPaymentCard("123", SWCardType.Visa, "1234", "01", "20")

val builder = SWRideParameters.Builder()
        .setUser(user)
        .setPickupLocation(SWLocation(48.864194, 2.343618, "Default"))
        .setCustomPaymentMethods(arrayOf(paymentMethod))
        .setPaymentCards(arrayOf(paymentCard))

val config = SWConfiguration.Builder()
        .setPartnerId("test-partner-id")
        .setSandbox(true)
        .setRequestLocationPermission(true)
        .setRequestNotificationPermission(true)
        .setDefaultLocation(SWLocation(48.864194, 2.343618, "Default"))
        .setCurrencyCode("GBP")
        .setLocale("en-gb")
        .setBrandColors(SWColors("#d8171d", "#ffffff", "#ddd"))
        .setRideParameters(builder.build())

SplytWidget.presentWidget(this, WidgetExampleActivity::class.java, config.build()) {
    print(it?.toString())
}
```

## Check if a user has an active booking

Pleas note this feature is coming soon.

You may wish to check if a user has a booking in progress.  This can be useful for building UI in your app.  To check whether the user has a booking you can call the following method.

### Example

```
val user = SWUser()
user.id        = "12345"
user.firstName = "Test"
user.lastName  = "User"
user.phone     =  "+441732123456"
user.email     = "test.user@test.com"

SplytWidget.fetchActiveBooking(user, "example-token") {
    booking, error ->
}
```

You will need to pass an instance of `SWUser` which contains the id of the user in question.  An accessToken is also required.  The completion handler will return an optional booking or error.
