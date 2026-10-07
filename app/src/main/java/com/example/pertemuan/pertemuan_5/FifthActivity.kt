package com.example.pertemuan.pertemuan_5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pertemuan.R
import com.example.pertemuan.databinding.ActivityFifthBinding
import com.example.pertemuan.pertemuan_4.FourthActivity

class FifthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Setup Toolbar dengan tombol Back
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = getString(R.string.title_catalog)
            subtitle = getString(R.string.subtitle_catalog)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        // Link ke WebView Halaman Lay's
        binding.btnWebView.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }

        // Tombol Pemesanan untuk tiap varian
        binding.btnOrderClassic.setOnClickListener {
            openOrderDetail("Lay's Classic Salted", "Rp 11.000")
        }

        binding.btnOrderBbq.setOnClickListener {
            openOrderDetail("Lay's Barbecue Flavored", "Rp 12.500")
        }

        binding.btnOrderSourCream.setOnClickListener {
            openOrderDetail("Lay's Sour Cream & Onion", "Rp 12.000")
        }
    }

    private fun openOrderDetail(flavorName: String, price: String) {
        val intent = Intent(this, FourthActivity::class.java).apply {
            putExtra("product_name", flavorName)
            putExtra("product_price", price)
        }
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            R.id.action_search -> {
                Toast.makeText(this, "Cari Varian Lay\'s", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_settings -> {
                Toast.makeText(this, "Pengaturan App", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}