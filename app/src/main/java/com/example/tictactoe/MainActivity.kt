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

        initializeBoardStatus()

        binding.reset.setOnClickListener {
            turn_count = 0
            player = true
            initializeBoardStatus()
        }


    }

    private fun initializeBoardStatus() {
        for (i: Int in 0..2) {
            for (j: Int in 0..2) {
                board_status[0][0] == -1
                board[i][j].isEnabled = true
                board[i][j].text = ""
            }
        }
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.button00 -> {
                updateValue(row = 0, col = 0, player = player)
            }
            R.id.button01 -> {
                updateValue(row = 0, col = 1, player = player)
            }
            R.id.button02 -> {
                updateValue(row = 0, col = 2, player = player)
            }
            R.id.button10 -> {
                updateValue(row = 1, col = 0, player = player)
            }
            R.id.button11 -> {
                updateValue(row = 1, col = 1, player = player)
            }
            R.id.button12 -> {
                updateValue(row = 1, col = 2, player = player)
            }
            R.id.button20 -> {
                updateValue(row = 2, col = 0, player = player)
            }
            R.id.button21 -> {
                updateValue(row = 2, col = 1, player = player)
            }
            R.id.button22 -> {
                updateValue(row = 2, col = 2, player = player)
            }
        }
        turn_count++
        player = !player

        if (player) {
            updateDisplay("Player X Turn!")
        }
        else {
            updateDisplay("Player 0 Turn!")
        }

        if (turn_count == 9) {
            updateDisplay("Game Draw")
        }
    }

    private fun updateDisplay(s: String) {
        binding.turnOf.text = s
    }

    private fun updateValue(row: Int, col: Int, player: Boolean) {

        val text: String = if (player) "X" else "0"
        val value: Int = if (player) 1 else 0
        board[row][col].apply {
            isEnabled = false
            setText(text)
        }
        board_status[row][col] = value
    }
}