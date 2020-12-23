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
            Log.d("AsimDebug","Main Screen Clicked")
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

        binding.appsLeft.setOnClickListener {
            isLeft = true
            binding.appsLeftExtesionOut.visibility = View.VISIBLE
            openedViewLeft = binding.appsLeftExtesionOut
            openedViewLeft.animate().translationX(0f)
        }

        binding.screenCastLeft.setOnClickListener {
            isLeft = true
            binding.screenCastLeftExtensionOut.visibility = View.VISIBLE
            openedViewLeft = binding.screenCastLeftExtensionOut
            openedViewLeft.animate().translationX(0f)
        }

        binding.leftShortMenuItem1.setOnClickListener {
            isLeft = true
            binding.leftQuickMenu.visibility = View.VISIBLE
            openedViewLeft = binding.leftQuickMenu
            openedViewLeft.animate().translationX(0f)
        }

        //RIGHT ONES #################################

        binding.appsRight.setOnClickListener {
            isLeft = false
            openedViewRight = binding.appsRightExtesionOut
            binding.appsRightExtesionOut.visibility = View.VISIBLE
            openedViewRight.animate().translationX(0f)
        }

        binding.screenCastRight.setOnClickListener {
            isLeft = false
            openedViewRight = binding.screenCastRightExtensionOut
            binding.screenCastRightExtensionOut.visibility = View.VISIBLE
            openedViewRight.animate().translationX(0f)
        }

        binding.rightShortMenuItem1.setOnClickListener {
            isLeft = false
            binding.rightQuickMenu.visibility = View.VISIBLE
            openedViewRight = binding.rightQuickMenu
            openedViewRight.animate().translationX(0f)
        }

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