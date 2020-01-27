package com.example.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

public class MainActivity : AppCompatActivity() {

    var round = 0
    var leftround = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttoncounter = findViewById<Button>(R.id.buttoncounter)
        val restart = findViewById<Button>(R.id.reiniciar)
        val count = findViewById<TextView>(R.id.count)
        val congrat_image = findViewById<ImageView>(R.id.congrat_image)

        buttoncounter.setOnClickListener {
            round++
            count.text = "$round"
            if (round == 10){
                Toast.makeText(applicationContext,"10 more rounds to complete the objective", Toast.LENGTH_SHORT).show()
                congrat_image.setImageResource(R.drawable.ic_star_border_black_24dp)
            }

            if (round == 20){
                Toast.makeText(applicationContext,"Congratulaions, you finished the $round rounds!", Toast.LENGTH_SHORT).show()
                congrat_image.setImageResource(R.drawable.ic_star_black_24dp)
            }

            if (round > 20){
                count.text = "You had already finished the goal. Restart if you want to try again. "
                buttoncounter.setOnLongClickListener {
                    Toast.makeText(this, "You had already finished both goals.", Toast.LENGTH_SHORT).show()
                    return@setOnLongClickListener true
                }
            }

            if (round < 10){
                leftround = 10 - round
                buttoncounter.setOnLongClickListener {
                    Toast.makeText(this, "$leftround more rounds to complete the next objective", Toast.LENGTH_SHORT).show()
                    return@setOnLongClickListener true
                }
            }

            if (round <= 20 && round >= 10){
                leftround = 20 - round
                buttoncounter.setOnLongClickListener {
                    Toast.makeText(this, "$leftround more rounds to complete the next objective", Toast.LENGTH_SHORT).show()
                    return@setOnLongClickListener true
                }
            }
        }

        restart.setOnClickListener {
            round = 0
            count.text = "$round"
            congrat_image.setImageDrawable(null)
        }
    }
}


