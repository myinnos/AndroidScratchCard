# Android Scratchcard
Light Weighted Scratchcard View Library for Android

 ![AndroidScratchCard - Example](https://raw.githubusercontent.com/myinnos/AndroidScratchCard/master/images-gif/androidscratchcard-example.gif)
  
#### Kindly use the following links to use this library:

In build.gradle (Project)
```java
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
And then in the other gradle file(may be your app gradle or your own module library gradle, but never add in both of them to avoid conflict.)
```java
dependencies {
    // AppCompat version
	  implementation 'com.github.myinnos:AndroidScratchCard:v1.0'
}
```          
How to use
-----
**Step 1:** add this to your xml:
```xml
 <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <TextView
            android:id="@+id/textView"
            android:layout_width="240dp"
            android:layout_height="150dp"
            android:layout_centerInParent="true"
            android:text="YOU EARNED 20" />
  
        <in.myinnos.androidscratchcard.ScratchCard
            android:id="@+id/scratchCard"
            android:layout_width="240dp"
            android:layout_height="150dp"
            android:layout_centerInParent="true"/>

    </RelativeLayout>
```
**Step 2:** implement setOnScratchListener to Play with Listener.
```java
private ScratchCard mScratchCard;

.....
    
mScratchCard = (ScratchCard) findViewById(R.id.scratchCard);
mScratchCard.setOnScratchListener(new ScratchCard.OnScratchListener() {
    @Override
    public void onScratch(ScratchCard scratchCard, float visiblePercent) {
         if (visiblePercent > 0.3) {
             mScratchCard.setVisibility(View.GONE);
             Toast.makeText(MainActivity.this, "Content Visible", Toast.LENGTH_SHORT).show();
          }
     }
});
    
```
##### Any Queries? or Feedback, please let me know by opening a [new issue](https://github.com/myinnos/AndroidScratchCard/issues/new)!

## Contact
#### Prabhakar Thota
* :globe_with_meridians: Website: [myinnos.in](http://www.myinnos.in "Prabhakar Thota")
* :email: e-mail: contact@myinnos.in
* :mag_right: LinkedIn: [PrabhakarThota](https://www.linkedin.com/in/prabhakarthota "Prabhakar Thota on LinkedIn")
* :thumbsup: Twitter: [@myinnos](https://twitter.com/myinnos "Prabhakar Thota on twitter")    
* :camera: Instagram: [@prabhakar_t_](https://www.instagram.com/prabhakar_t_/ "Prabhakar Thota on Instagram")   

> If you appreciate my work, consider buying me a cup of :coffee: to keep me recharged :metal: by [PayPal](https://www.paypal.me/fansfolio)

License
-------

    Copyright 2017 MyInnos

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
