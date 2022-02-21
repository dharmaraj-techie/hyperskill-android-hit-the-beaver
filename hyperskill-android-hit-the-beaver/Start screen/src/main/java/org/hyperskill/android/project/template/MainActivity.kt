package org.hyperskill.hit.the.beaver

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_button.setOnClickListener {
            start_button.visibility = View.INVISIBLE
            edit_text.visibility = View.VISIBLE
            next_button.visibility = View.VISIBLE
        }
    }
}