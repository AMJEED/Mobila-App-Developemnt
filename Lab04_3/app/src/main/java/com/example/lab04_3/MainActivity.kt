package com.example.lab04_3

import android.media.MediaPlayer
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    var music:Boolean = false
    var myttsIsready:Boolean = false
    lateinit var tts :TextToSpeech

    lateinit var mediaPlayer:MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mediaPlayer = MediaPlayer.create(this, R.raw.music)
      tts = TextToSpeech(this,TextToSpeech.OnInitListener { myttsIsready = true },null)





    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater :MenuInflater = menuInflater
        inflater.inflate(R.menu.action_menu,menu)



        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       return when(item.itemId){
           R.id.speak->{

               if(myttsIsready){
                   var text = findViewById<TextView>(R.id.sentence).text.toString()
                   val loc = Locale("hin", "IND")
                   tts.language = loc
                   tts.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")

               }

               return true
           }
           R.id.music->{
               if(music == false) {
                   music = true


                   mediaPlayer.start()
               }else
               {
                   mediaPlayer.stop()
                   music  = false

               }
               return true

           }
           else->{
               return super.onContextItemSelected(item)
           }





       }




    }



}








