package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    lateinit var displayword: TextView

    lateinit var input: EditText
    var dict = arrayOf(
        "google",
        "computer",
        "mango",
        "strawbarry",
        "table",
        "desk",
        "ocean",
        "umberalla",
        "sand",
        "lemon"
    )
    var rand1: Int = Random.nextInt(10)
    var randWord = dict[rand1]
    var length = randWord.length
    var guess_left = 6
    var guessword = "?".repeat(length)
    lateinit var img: ImageView
    lateinit var btn: Button
    lateinit var display:TextView
    var guessChar:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        display = findViewById(R.id.display)
        displayword = findViewById<TextView>(R.id.wordGuess)
        input = findViewById(R.id.input)
        img = findViewById(R.id.imageView)
        btn = findViewById(R.id.button)
        displayword.text = guessword


    }

    fun guess(view: View) {
        var inpt = input.text.toString()
        var vlue: Char = input.text.toString()[0]


        var flag: Boolean = false

        if (inpt.length > 1) {
            Toast.makeText(this, "Only One Letter could be gussed!!", Toast.LENGTH_SHORT).show()


        } else {


            if (guessword.equals(randWord)) {
                Toast.makeText(this, "You Won the Game !!", Toast.LENGTH_SHORT).show()
                btn.isEnabled = false


            } else {
                guessChar+=vlue
                for (i in 0 until randWord.length) {

                    if (randWord[i] === vlue) {
                        guessword = guessword.substring(0, i) + vlue + guessword.substring(i + 1)
                        displayword.text = guessword
                        flag = true
                        display.text = "You have guessed the letters:\n" + guessChar +"\n Click new to guess new word!!"
                    }

                }
                if (!flag) {
                    if (guess_left > 0) {
                        guess_left -= 1
                        if (guess_left == 5) {

                            img.setImageResource(R.drawable.one)

                        }
                        if (guess_left == 4) {

                            img.setImageResource(R.drawable.two)

                        }
                        if (guess_left == 3) {

                            img.setImageResource(R.drawable.three)

                        }
                        if (guess_left == 2) {

                            img.setImageResource(R.drawable.four)

                        }
                        if (guess_left == 1) {

                            img.setImageResource(R.drawable.five)

                        }
                    } else {

                        btn.isEnabled = false
                        Toast.makeText(this, "Game over", Toast.LENGTH_SHORT).show()


                    }


                }
            }


        }
    }

    fun new(view:View){
        guessChar = ""
        rand1 = Random.nextInt(10)
        randWord = dict[rand1]
        length = randWord.length
        guess_left = 6
        guessword="?".repeat(length)
        displayword.text = guessword


    }





}
