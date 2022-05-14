package com.info.appintro

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.info.appintro.databinding.IntroSlide1Binding
import android.Manifest
import com.github.appintro.*

class Into : AppIntro2() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val customLayout = AppIntroCustomLayoutFragment.newInstance(R.layout.intro_slide1)
        addSlide(customLayout)


        addSlide(AppIntroFragment.createInstance(
            title = "Slide 1",
            description = "welcome to the slide 1",
            titleColorRes = R.color.black,
            descriptionColorRes = R.color.black,
            imageDrawable = R.drawable.ic_slide1,
            backgroundDrawable = R.drawable.back_slide1,
        ))


        addSlide(AppIntroFragment.createInstance(
            title = "Slide 2",
            description = "welcome to the slide 2",
            titleColorRes = R.color.black,
            descriptionColorRes = R.color.black,
            imageDrawable = R.drawable.ic_slide2,
            backgroundDrawable = R.drawable.back_slide2,
        ))

        addSlide(AppIntroFragment.createInstance(
            title = "Slide 3",
            titleColorRes = R.color.black,
            descriptionColorRes = R.color.black,
            description = "welcome to the slide 3",
            imageDrawable = R.drawable.ic_slide3,
            backgroundDrawable = R.drawable.back_slide3,
        ))

        addSlide(AppIntroFragment.createInstance(
            title = "Slide 4",
            description = "welcome to the slide 4",
            titleColorRes = R.color.black,
            descriptionColorRes = R.color.black,
            imageDrawable = R.drawable.ic_slide4,
            backgroundDrawable = R.drawable.back_slide4,
        ))


        

        // transformer
        setTransformer(AppIntroPageTransformerType.Zoom)


        // indicator color (selected and unselected indicator color)
        setIndicatorColor(Color.BLUE,Color.GRAY)

//        setColorSkipButton(Color.BLACK)
//        setColorDoneText(Color.BLACK)

        // Switch from Dotted Indicator to Progress Indicator
        setProgressIndicator()

        setPermissions()

        // this function will display
        setImmersiveMode()

    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)

        navigateToMain()
    }


    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)

        navigateToMain()

    }

    override fun onUserDeniedPermission(permissionName: String) {
        // User pressed "Deny" on the permission dialog
    }

    override fun onUserDisabledPermission(permissionName: String) {
        // User pressed "Deny" + "Don't ask again" on the permission dialog
    }


    private fun navigateToMain() {
        val intent = Intent(this,MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish() // this function will destroy the current activity.
    }



    private fun setPermissions(){
        askForPermissions( // you can set a list of permissions
            permissions = arrayOf(
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ),
            slideNumber = 3, // you can set the slide number which the permissions are requested there.
            required = true)
    }

}