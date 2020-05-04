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
implementation 'com.splyt:splytwidgetsdk:1.1.1'
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
val builder = SWRideParameters.Builder()
        .setUserId('user-id')
        .setPickupLocation(SWLocation(48.864194, 2.343618, "Default"))

val config = SWConfiguration.Builder()
        .setPartnerId("test-partner-id")
        .setSandbox(true)
        .setRequestLocationPermission(true)
        .setDefaultLocation(SWLocation(48.864194, 2.343618, "Default"))
        .setLocale("en-gb")
        .setPrimaryColor("hex color")
        .setRideParameters(builder.build())

SplytWidget.presentWidget(this, WidgetExampleActivity::class.java, config.build()) {
    print(it?.toString())
}
```
