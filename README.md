# Lithium Community Android SDK Example  

This reference app provides an example of how to use the Lithium Community Android SDK.
This README assumes that you have Android Studio installed and a working Community instance.

## Getting Started
Getting started with the reference application includes:

* Cloning the Community Android SDK repositories
* Build the AARs for the projects
* Create credentials for your Community integration and add them to the reference applicaiton
* Run the reference applicaiton

**Note:** Be sure to clone and build the SDK projects in the order listed.

1. Clone [li-android-sdk-core](https://github.com/lithiumtech/li-android-sdk-core).
1. In Android Studio, click **Run** to publish to local Maven.
1. Clone [li-android-sdk-ui](https://github.com/lithiumtech/li-android-sdk-ui).
1. In Android Studio, click **Run** to publish to local Maven.
1. Clone [li-android-sdk-example](https://github.com/lithiumtech/li-android-sdk-example).
1. Sign in to your Community and go to **Community Admin > System > API Apps**.
1. Create an app key and secret for your Community integration app following the steps in the [Get Authorization Credentials](https://github.com/lithiumtech/li-android-sdk-core/wiki/Getting-Started-with-the-Community-Android-SDK#get-authorization-credentials) section of Getting Started with the Community Android SDK.
1. In Android Studio, go to the li-android-sdk-exampe project.
1. Add your credentials and the Community URL to `strings.xml`.
    
    ```xml
    <string name="clientId">API App Key Goes Here</string>
    <string name="clientSecret">App Secret Goes Here</string>
    <string name="communityURL">URL to your Community Goes Here</string>
    ```
    
1. Click **Run**.

## License
Except as otherwise noted, the Community Android SDK and the Lithium Community Reference app are licensed under the Apache 2.0 License.

Copyright 2017 Lithium Technologies

## Getting help
Visit the [Current Betas Forum](https://community.lithium.com/t5/Current-betas/bd-p/BetaCurrent) on the Lithium Community to learn about our beta program, ask questions, and talk with other members of the Lithium Developer community.
