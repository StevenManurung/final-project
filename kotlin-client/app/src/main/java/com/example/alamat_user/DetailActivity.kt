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

    private fun retrieveAlamatDetail(id: String) {
        RetrofitClient.instance.getAlamatDetail(id)
            .enqueue(object: Callback<AlamatDetail> {
                override fun onResponse(call: Call<AlamatDetail>, response: Response<AlamatDetail>) {
                    if (response.code() == 200) {
                        list = response.body()!!
                        Log.d("GET ALAMAT DETAIL", list.toString())

                        binding.tvNama.text = list.nama
                        binding.tvNohp.text = list.nohp.toString()
                        binding.tvProvinsi.text = list.provinsi
                        binding.tvKota.text = list.kota
                        binding.tvKecamatan.text = list.kecamatan
                        binding.tvKodepos.text = list.kodepos.toString()
                        binding.tvNamajalan.text = list.namajalan
                        binding.tvDetailalamat.text = list.detailalamat

                    } else {
                        Toast.makeText(this@DetailActivity, "Fail fetching from database response is not 200", Toast.LENGTH_LONG).show()
                        Log.d("GET ALAMAT ITEMS FAIL ${response.code()}", response.body().toString())
                    }
                }

                override fun onFailure(call: Call<AlamatDetail>, t: Throwable) {
                    Toast.makeText(this@DetailActivity, "Fail fetching from database onFailure", Toast.LENGTH_LONG).show()
                    Log.d("GET ALAMAT ITEMS FAIL", t.toString())
                }
            })
    }

    private fun deleteAlamat(id: String) {
        RetrofitClient.instance.deleteAlamatDetail(id)
            .enqueue(object: Callback<com.example.alamat_user.data.Response> {
                override fun onResponse(
                    call: Call<com.example.alamat_user.data.Response>,
                    response: Response<com.example.alamat_user.data.Response>
                ) {
                    if (response.code() == 200) {
                        val resp = response.body()
                        if (resp!!.error) Toast.makeText(this@DetailActivity, resp.message + ", please try again later", Toast.LENGTH_LONG).show()
                        else {
                            Toast.makeText(this@DetailActivity, resp.message, Toast.LENGTH_SHORT).show()

                            startActivity(Intent(this@DetailActivity, MainActivity::class.java))

                            this@DetailActivity.finish()
                        }
                    } else {
                        Toast.makeText(this@DetailActivity, "Something wrong on server", Toast.LENGTH_LONG).show()
                        Log.d("DELETE ALAMAT (${response.code()})", response.body().toString())
                    }
                }

                override fun onFailure(call: Call<com.example.alamat_user.data.Response>, t: Throwable) {
                    Toast.makeText(this@DetailActivity, "Something wrong on server...", Toast.LENGTH_LONG).show()
                    Log.d("DELETE ADDRESS FAIL", t.toString())
                }
            })
    }
}