package com.example.contexualactionmenulab4

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toast.*

class MainActivity : AppCompatActivity() {
    lateinit var pic:ImageView
   var actionMode:ActionMode? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pic = findViewById(R.id.pic)


        pic.setOnLongClickListener { view ->
            // Called when the user long-clicks on someView
            when (actionMode) {
                null -> {
                    // Start the CAB using the ActionMode.Callback defined above
                    actionMode = this.startActionMode(actionModeCallback)
                    view.isSelected = true
                    true
                }
                else -> false
            }
        }


    }

    private val actionModeCallback = object : ActionMode.Callback {
        // Called when the action mode is created; startActionMode() was called
        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            // Inflate a menu resource providing context menu items
            val inflater: MenuInflater = mode.menuInflater
            inflater.inflate(R.menu.menu_context_action, menu)
            return true
        }

        // Called each time the action mode is shown. Always called after onCreateActionMode, but
        // may be called multiple times if the mode is invalidated.
        override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
            return false // Return false if nothing is done
        }

        // Called when the user selects a contextual menu item
        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.paint -> {
                    Toast.makeText(this@MainActivity,"Edit menu selected",Toast.LENGTH_SHORT).show()
                    mode.finish() // Action picked, so close the CAB
                    true
                }
                R.id.pin->{
                    Toast.makeText(this@MainActivity,"Pin menu selected",Toast.LENGTH_SHORT).show()
                    mode.finish() // Action picked, so close the CAB
                    true

                }
                R.id.bookmark->{

                    Toast.makeText(this@MainActivity,"Bookmark menu selected",Toast.LENGTH_SHORT).show()
                    mode.finish() // Action picked, so close the CAB
                    true


                }
                else -> false
            }
        }

        // Called when the user exits the action mode
        override fun onDestroyActionMode(mode: ActionMode) {
            actionMode = null
        }
    }





}