package com.example.alamat_user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.alamat_user.data.AlamatDetail
import com.example.alamat_user.databinding.ActivityDetailBinding
import com.example.alamat_user.rest.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    lateinit var list: AlamatDetail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id: String = intent.getStringExtra("idAlamat").toString()

        retrieveAlamatDetail(id)

        binding.btnUbah.setOnClickListener {
            startActivity(
                Intent(this@DetailActivity, EditActivity::class.java)
                    .putExtra("alamat_detail", list)
            )
        }

        binding.btnHapus.setOnClickListener {
            deleteAlamat(id)
        }
    }

    // Membuat fungsi untuk mengambil detail dari data alamat
    private fun retrieveAlamatDetail(id: String) {
      @TODO

      //Bagian vita
    }


    // Membuat fungsi menghapus alamat dengan mengambil id
    private fun deleteAlamat(id: String) {
       @TODO

       //Bagian vita
    }
}