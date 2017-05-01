# Lithium Community Android SDK Example  

This reference app provides an example of how to use the Lithium Community Android SDK.
This README assumes that you have Android Studio installed and a working Community instance.

## Getting Started

1. Clone [li-android-sdk-example](https://github.com/lithiumtech/li-android-sdk-example).
1. Sign in to your Community and go to **Community Admin > System > API Apps**.
1. Create an app key and secret for your Community integration app following the steps in the [Get Authorization Credentials](https://github.com/lithiumtech/li-android-sdk-core/wiki/Getting-Started-with-the-Community-Android-SDK#get-authentication-credentials) section of Getting Started with the Community Android SDK.
1. In Android Studio, go to the li-android-sdk-exampe project.
1. Add your credentials and the Community URL to `strings.xml`.

    ```xml
    <string name="clientId">PLACE YOUR COMMUNITY CLIENT ID HERE</string>
    <string name="clientSecret">PLACE YOUR COMMUNITY CLIENT SECRET HERE</string>
    <string name="communityURL">PLACE YOUR COMMUNITY URL HERE</string>
    <string name="communityTenantId">PLACE COMMUNITY TENANT ID HERE</string>
    <string name="apiProxyHostname">PLACE API PROXY HOSTNAME HERE</string>
    ```
1. If using push notifications, follow the instructions in [Connecting Firebase Cloud Messaging](https://github.com/lithiumtech/li-android-sdk-core/wiki/Connecting-Firebase-Cloud-Messaging) to add your push notification server key to Community Admin.    
1. In Android Studio, click **Run**.

## License
Except as otherwise noted, the Community Android SDK and the Lithium Community Reference app are licensed under the Apache 2.0 License.

Copyright 2017 Lithium Technologies

## Getting help
Visit the [Current Betas Forum](https://community.lithium.com/t5/Current-betas/bd-p/BetaCurrent) on the Lithium Community to learn about our beta program, ask questions, and talk with other members of the Lithium Developer community.
