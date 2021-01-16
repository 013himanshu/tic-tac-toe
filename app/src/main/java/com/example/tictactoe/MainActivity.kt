package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var board: Array<Array<Button>>
    private var player = true
    private var turn_count = 0
    private var board_status = Array(3) {IntArray(3)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        //Run app only in dark mode...
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        binding.apply {
            board = arrayOf(
                    arrayOf(button00, button01, button02),
                    arrayOf(button10, button11, button12),
                    arrayOf(button20, button21, button22)
            )
        }

        for(i in board) {
            for(button in i) {
                button.setOnClickListener(this)
            }
        }

        binding.reset.setOnClickListener {

        }


    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.button00 -> {

            }
            R.id.button01 -> {

            }
            R.id.button02 -> {

            }
            R.id.button10 -> {

            }
            R.id.button11 -> {

            }
            R.id.button12 -> {

            }
            R.id.button20 -> {

            }
            R.id.button21 -> {

            }
            R.id.button22 -> {

            }
        }
    }
}