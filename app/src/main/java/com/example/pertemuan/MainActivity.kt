package com.example.pertemuan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pertemuan.databinding.ActivityMainBinding
import com.example.pertemuan.pertemuan_4.FourthActivity
import com.example.pertemuan.pertemuan_5.FifthActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)

            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)

            startActivity(intent)
        }

        binding.button.setOnClickListener {
            val i = Intent(this@MainActivity, FifthActivity::class.java)
            startActivity(i)
        }
    }
}