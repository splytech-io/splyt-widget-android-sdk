# SplytWidgetSDK

The `SplytWidgetSDK` allows you to easily make ride hailing available to users of your app. Using the `SplytWidgetSDK` you can present your users with a clean, simple and logical interface.

For detailed instructions, [please read our documentation](https://developer.splytech.io/widget/android/index.html) or contact Splyt.

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
implementation 'com.splyt:splytwidgetsdk:0.0.1'
```

## How to use the SplytWidgetSDK

The SplytWidgetSDK contains a static class named `SplytWidget`.  To launch the `SplytWidget` you must call the `presentWidget` method.  This method takes 3 parameters.  The first parameter `conte`

### Example

```

``

## Configuring the SplytWidget

When presenting the SplytWidget you are required to pass an instance of `SWConfiguration`. To create the `SWConfiguration` you should use the `SWConfigurationBuilder`.  The `SWConfiguration` model allows you to fine tune the widget for you app.
