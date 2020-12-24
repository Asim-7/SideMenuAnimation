package com.shehzad.sidemenuanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.shehzad.sidemenuanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var openedViewLeft: View
    private lateinit var openedViewRight: View
    private var isLeft = true
    private lateinit var closedView: View
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)
        openedViewLeft = binding.leftQuickMenu
        openedViewRight = binding.rightQuickMenu
        closedView = binding.rightQuickMenu

        //Move right ones by default
        moveRightViews()

        //Main Screen
        binding.mainConstraintView.setOnClickListener {
            Log.d("AsimDebug", "Main Screen Clicked")
            if (openedViewLeft == binding.leftQuickMenu) {
                openedViewLeft.animate().translationX(-600f)
            } else if (isLeft) {
                closedView = openedViewLeft
                openedViewLeft.animate().translationX(-600f)
            }

            if (openedViewRight == binding.rightQuickMenu) {
                openedViewRight.animate().translationX(+600f)
            } else if (!isLeft) {
                closedView = openedViewRight
                openedViewRight.animate().translationX(+600f)
            }
        }

        //Button
        binding.openLeftMenu.setOnClickListener {
            isLeft = true
            openedViewRight.visibility = View.GONE
            moveLeftViews()
            //openedViewRight.animate().translationX(+600f)
            if (binding.leftQuickMenu.visibility == View.VISIBLE) {
                //do nothing
            } else {
                //binding.leftQuickMenu.visibility = View.VISIBLE
                binding.leftShortMenu.visibility = View.VISIBLE
                binding.rightQuickMenu.visibility = View.GONE
                binding.rightShortMenu.visibility = View.GONE
            }
        }

        //Button
        binding.openRightMenu.setOnClickListener {
            isLeft = false
            openedViewLeft.visibility = View.GONE
            moveRightViews()
            //openedViewLeft.animate().translationX(-600f)
            if (binding.rightQuickMenu.visibility == View.VISIBLE) {
                //do nothing
            } else {
                //animation
                binding.leftQuickMenu.visibility = View.GONE
                binding.leftShortMenu.visibility = View.GONE
                //binding.rightQuickMenu.visibility = View.VISIBLE
                binding.rightShortMenu.visibility = View.VISIBLE
            }
        }

        //LEFT ONES #################################
        binding.appsLeft.setOnClickListener { showLeftMenuItem(binding.appsLeftExtesionOut) }
        binding.screenCastLeft.setOnClickListener { showLeftMenuItem(binding.screenCastLeftExtensionOut) }
        binding.leftShortMenuItem1.setOnClickListener { showLeftMenuItem(binding.leftQuickMenu) }

        //RIGHT ONES #################################
        binding.appsRight.setOnClickListener { showRightMenuItem(binding.appsRightExtesionOut) }
        binding.screenCastRight.setOnClickListener { showRightMenuItem(binding.screenCastRightExtensionOut) }
        binding.rightShortMenuItem1.setOnClickListener { showRightMenuItem(binding.rightQuickMenu) }

    }

    private fun showLeftMenuItem(view: View) {
        isLeft = true
        openedViewLeft = view
        openedViewLeft.visibility = View.VISIBLE
        openedViewLeft.animate().translationX(0f)
    }

    private fun showRightMenuItem(view: View) {
        isLeft = false
        openedViewRight = view
        openedViewRight.visibility = View.VISIBLE
        openedViewRight.animate().translationX(0f)
    }

    private fun moveLeftViews() {
        binding.appsLeftExtesionOut.visibility = View.INVISIBLE
        binding.appsLeftExtesionOut.animate().translationX(-600f)

        binding.screenCastLeftExtensionOut.visibility = View.INVISIBLE
        binding.screenCastLeftExtensionOut.animate().translationX(-600f)

        binding.leftQuickMenu.visibility = View.INVISIBLE
        binding.leftQuickMenu.animate().translationX(-600f)
    }

    private fun moveRightViews() {
        binding.appsRightExtesionOut.visibility = View.INVISIBLE
        binding.appsRightExtesionOut.animate().translationX(+600f)

        binding.screenCastRightExtensionOut.visibility = View.INVISIBLE
        binding.screenCastRightExtensionOut.animate().translationX(+600f)

        binding.rightQuickMenu.visibility = View.INVISIBLE
        binding.rightQuickMenu.animate().translationX(+600f)
    }

}