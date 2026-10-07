package com.example.pertemuan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pertemuan.databinding.ActivityMainBinding
import com.example.pertemuan.pertemuan_4.FourthActivity
import com.example.pertemuan.pertemuan_5.FifthActivity
import com.example.pertemuan.pertemuan_5.WebViewActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set Toolbar tanpa tombol back untuk Halaman Awal
        setSupportActionBar(binding.toolbar)

        // 1. Tombol ke Katalog Varian Lay's (FifthActivity)
        binding.btnToCatalog.setOnClickListener {
            val intent = Intent(this, FifthActivity::class.java)
            startActivity(intent)
        }

        // 2. Tombol ke Detail & Pemesanan Lay's (FourthActivity)
        binding.btnToOrder.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("product_name", "Lay's Barbecue Flavored")
            intent.putExtra("product_price", "Rp 12.500")
            startActivity(intent)
        }

        // 3. Tombol ke Website Resmi Lay's (WebViewActivity)
        binding.btnToWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }
    }
}