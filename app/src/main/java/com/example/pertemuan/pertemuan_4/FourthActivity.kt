package com.example.pertemuan.pertemuan_4

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pertemuan.MainActivity
import com.example.pertemuan.R
import com.example.pertemuan.databinding.ActivityFourthBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class FourthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar dengan tombol Back
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = getString(R.string.title_detail)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        // Ambil data intent jika ada
        val productName = intent.getStringExtra("product_name") ?: "Lay's Barbecue Flavored"
        val productPrice = intent.getStringExtra("product_price") ?: "Rp 12.500"

        binding.tvProductName.text = productName
        binding.tvProductPrice.text = "$productPrice / bungkus"

        // Button Kembali ke Beranda
        binding.btnKembali.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }

        // Button Snackbar Promo
        binding.btnShowSnackbar.setOnClickListener {
            Snackbar.make(it, "Diskon 20% untuk pembelian 3 bungkus Lay's rasa apa saja!", Snackbar.LENGTH_LONG)
                .setAction("Klaim Promo") {
                    Toast.makeText(this, "Promo berhasil diklaim!", Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        // Button Order Confirmation Dialog
        binding.btnShowAlertDialog.setOnClickListener {
            val nama = binding.etNamaPemesan.text.toString()
            val jumlah = binding.etJumlahBungkus.text.toString()

            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi Pemesanan Lay\'s")
                .setMessage("Apakah Anda yakin ingin memesan $jumlah bungkus $productName atas nama $nama?")
                .setPositiveButton("Ya, Pesan") { dialog, _ ->
                    dialog.dismiss()
                    Toast.makeText(this, "Pesanan $productName berhasil dibuat!", Toast.LENGTH_LONG).show()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}