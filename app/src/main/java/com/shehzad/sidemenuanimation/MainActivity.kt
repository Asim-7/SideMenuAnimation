package com.shehzad.sidemenuanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        binding.mainConstraintView.setOnClickListener {

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
        binding.openLeftMenu.setOnClickListener {
            isLeft = true
            if (binding.leftQuickMenu.visibility == View.VISIBLE) {
                //do nothing
            } else {
                //binding.leftQuickMenu.visibility = View.VISIBLE
                binding.leftShortMenu.visibility = View.VISIBLE
                binding.rightQuickMenu.visibility = View.GONE
                binding.rightShortMenu.visibility = View.GONE
            }
        }

        binding.openRightMenu.setOnClickListener {
            isLeft = false
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

        binding.appsLeft.setOnClickListener {
            isLeft = true
            if (openedViewLeft == binding.leftQuickMenu) {
                //First Time in
                binding.appsLeftExtesion.visibility = View.INVISIBLE
                openedViewLeft = binding.appsLeftExtesion
                openedViewLeft.animate().translationX(-600f)
                binding.appsLeftExtesion.visibility = View.VISIBLE
                openedViewLeft.animate().translationX(0f)
            } else {
                binding.appsLeftExtesion.visibility = View.VISIBLE
                openedViewLeft = binding.appsLeftExtesion
                openedViewLeft.animate().translationX(0f)
            }
        }

        binding.screenCastLeft.setOnClickListener {
            isLeft = true
            if (openedViewLeft == binding.leftQuickMenu) {
                //First Time in
                binding.screenCastLeftExtension.visibility = View.INVISIBLE
                openedViewLeft = binding.screenCastLeftExtension
                openedViewLeft.animate().translationX(-600f)
                binding.screenCastLeftExtension.visibility = View.VISIBLE
                openedViewLeft.animate().translationX(0f)
            } else {
                binding.screenCastLeftExtension.visibility = View.VISIBLE
                openedViewLeft = binding.screenCastLeftExtension
                openedViewLeft.animate().translationX(0f)
            }
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
            if (openedViewRight == binding.rightQuickMenu) {
                //First Time in
                binding.appsRightExtesion.visibility = View.INVISIBLE
                openedViewRight = binding.appsRightExtesion
                openedViewRight.animate().translationX(+600f)
                binding.appsRightExtesion.visibility = View.VISIBLE
                openedViewRight.animate().translationX(0f)
            } else {
                binding.appsRightExtesion.visibility = View.VISIBLE
                openedViewRight = binding.appsRightExtesion
                openedViewRight.animate().translationX(0f)
            }
        }

        binding.screenCastRight.setOnClickListener {
            isLeft = false
            if (openedViewRight == binding.rightQuickMenu) {
                //First Time in
                binding.screenCastRightExtension.visibility = View.INVISIBLE
                openedViewRight = binding.screenCastRightExtension
                openedViewRight.animate().translationX(+600f)
                binding.screenCastRightExtension.visibility = View.VISIBLE
                openedViewRight.animate().translationX(0f)
            } else {
                binding.screenCastRightExtension.visibility = View.VISIBLE
                openedViewRight = binding.screenCastRightExtension
                openedViewRight.animate().translationX(0f)
            }
        }

        binding.rightShortMenuItem1.setOnClickListener {
            isLeft = false
            binding.rightQuickMenu.visibility = View.VISIBLE
            openedViewRight = binding.rightQuickMenu
            openedViewRight.animate().translationX(0f)
        }

    }
}