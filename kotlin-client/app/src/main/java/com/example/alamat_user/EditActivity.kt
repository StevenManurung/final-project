package com.example.alamat_user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.alamat_user.data.AlamatDetail
import com.example.alamat_user.data.Response
import com.example.alamat_user.databinding.ActivityEditBinding
import com.example.alamat_user.rest.RetrofitClient
import retrofit2.Call
import retrofit2.Callback

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val alamatData: AlamatDetail? = intent.getParcelableExtra("alamat_detail")

        if (alamatData != null) {
            binding.edtNama.setText(alamatData.nama)
            binding.edtNohp.setText(alamatData.nohp.toString())
            binding.edtProvinsi.setText(alamatData.provinsi)
            binding.edtKota.setText(alamatData.kota)
            binding.edtKecamatan.setText(alamatData.kecamatan)
            binding.edtKodepos.setText(alamatData.kodepos.toString())
            binding.edtNamajalan.setText(alamatData.namajalan)
            binding.edtDetailalamat.setText(alamatData.detailalamat)

            binding.btnUbah.setOnClickListener {
                ubahAlamatDetail(alamatData.id!!)
            }
        } else {
            // Handle the case when alamatData is null
            Toast.makeText(this, "Failed to retrieve address data", Toast.LENGTH_SHORT).show()
            finish()
        }
    }


    private fun ubahAlamatDetail(id: Int) {
        val inputNama = binding.edtNama.text.toString().trim()
        val inputNohp = binding.edtNohp.text.toString().trim()
        val inputProvinsi = binding.edtProvinsi.text.toString().trim()
        val inputKota = binding.edtKota.text.toString().trim()
        val inputKecamatan = binding.edtKecamatan.text.toString().trim()
        val inputKodepos = binding.edtKodepos.text.toString().trim()
        val inputNamajalan = binding.edtNamajalan.text.toString().trim()
        val inputDetailalamat = binding.edtDetailalamat.text.toString().trim()

        //validation data
        if (inputNama.isEmpty()) {
            binding.edtNama.error = "Field is empty"
        }
        if (inputNohp.isEmpty()) {
            binding.edtNohp.error = "Field is empty"
        }
        if (inputProvinsi.isEmpty()) {
            binding.edtProvinsi.error = "Field is empty"
        }
        if (inputKota.isEmpty()) {
            binding.edtKota.error = "Field is empty"
        }
        if (inputKecamatan.isEmpty()) {
            binding.edtKecamatan.error = "Field is empty"
        }
        if (inputKodepos.isEmpty()) {
            binding.edtKodepos.error = "Field is empty"
        }
        if (inputNamajalan.isEmpty()) {
            binding.edtNamajalan.error = "Field is empty"
        }
        if (inputDetailalamat.isEmpty()) {
            binding.edtDetailalamat.error = "Field is empty"
        }

        if (inputNama.isNotEmpty() && inputNohp.isNotEmpty() && inputProvinsi.isNotEmpty() && inputKota.isNotEmpty()
            && inputKecamatan.isNotEmpty() && inputKodepos.isNotEmpty() && inputNamajalan.isNotEmpty() && inputDetailalamat.isNotEmpty()) {
            val newId = id.toString()
            RetrofitClient.instance.ubahAlamatDetail(newId, inputNama, inputNohp, inputProvinsi, inputKota, inputKecamatan
                , inputKodepos, inputNamajalan, inputDetailalamat)
                .enqueue(object: Callback<Response> {
                    override fun onResponse(
                        call: Call<Response>,
                        response: retrofit2.Response<Response>
                    ) {
                        if (response.code() == 200) {
                            val resp = response.body()

                            if (resp!!.error) Toast.makeText(this@EditActivity, resp.message + ", please try again later", Toast.LENGTH_LONG).show()

                            else {
                                Toast.makeText(this@EditActivity, resp.message, Toast.LENGTH_SHORT).show()

                                startActivity(Intent(this@EditActivity, MainActivity::class.java))

                                this@EditActivity.finish()
                            }
                        } else {
                            Toast.makeText(this@EditActivity, "Something wrong on server", Toast.LENGTH_LONG).show()
                            Log.d("UBAH ALAMAT (${response.code()})", response.body().toString())
                        }
                    }

                    override fun onFailure(call: Call<Response>, t: Throwable) {
                        Toast.makeText(this@EditActivity, "Something wrong on server...", Toast.LENGTH_LONG).show()
                        Log.d("GAGAL MENDAPATKAN ALAMAT", t.toString())
                    }
                })
        } else {
            Toast.makeText(this@EditActivity, "Fail editing alamat data, field(s) is empty!", Toast.LENGTH_LONG).show()
        }
    }
}