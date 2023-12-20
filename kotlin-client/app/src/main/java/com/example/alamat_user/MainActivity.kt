package com.example.alamat_user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alamat_user.adapter.AlamatListAdapter
import com.example.alamat_user.data.AlamatItem
import com.example.alamat_user.databinding.ActivityMainBinding
import com.example.alamat_user.rest.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrieveAlamatt()

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddActivity::class.java))
        }
    }

    private fun alamatItemClicked(alamat: AlamatItem) {
        val id = alamat.id.toString()

        startActivity(
            Intent(this@MainActivity, DetailActivity::class.java)
                .putExtra("idAlamat", id)
        )
    }

    private fun buildAlamatList(alamatt: ArrayList<AlamatItem>) {
        val alamatAdapter = AlamatListAdapter(alamatt) { alamat: AlamatItem ->
            alamatItemClicked(alamat)
        }

        binding.rvAlamatt.adapter = alamatAdapter
        binding.rvAlamatt.layoutManager = LinearLayoutManager(this@MainActivity,
            LinearLayoutManager.VERTICAL, false)
    }

    private fun retrieveAlamatt() {
      @TODO
    }
}