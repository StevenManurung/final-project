package com.example.alamat_user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.alamat_user.data.Response
import com.example.alamat_user.databinding.ActivityAddBinding
import com.example.alamat_user.rest.RetrofitClient
import retrofit2.Call
import retrofit2.Callback


class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            addAlamatData()
        }
    }

    private fun addAlamatData() {
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
            RetrofitClient.instance.addAlamatDetail(inputNama, inputNohp, inputProvinsi, inputKota, inputKecamatan,
                inputKodepos, inputNamajalan, inputDetailalamat)
                .enqueue(object: Callback<Response> {
                    override fun onResponse(
                        call: Call<Response>,
                        response: retrofit2.Response<Response>
                    ) {
                        if (response.code() == 200) {
                            val resp = response.body()
                            if (resp!!.error) Toast.makeText(this@AddActivity, resp.message + ", please try again later", Toast.LENGTH_LONG).show()

                            else {
                                Toast.makeText(this@AddActivity, resp.message, Toast.LENGTH_SHORT).show()

                                startActivity(Intent(this@AddActivity, MainActivity::class.java))

                                this@AddActivity.finish()
                            }
                        } else {
                            Toast.makeText(this@AddActivity, "Something wrong on server", Toast.LENGTH_LONG).show()
                            Log.d("ADD ALAMAT (${response.code()})", response.body().toString())
                        }
                    }

                    override fun onFailure(call: Call<Response>, t: Throwable) {
                        Toast.makeText(this@AddActivity, "Something wrong on server...", Toast.LENGTH_LONG).show()
                        Log.d("ADD ADDRESS FAIL", t.toString())
                    }
                })
        } else {
            Toast.makeText(this@AddActivity, "Fail adding address data, field(s) is empty!", Toast.LENGTH_LONG).show()
        }
    }
}