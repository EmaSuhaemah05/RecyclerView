@file:Suppress("PackageName")

package com.EmaSuhaemah.recyclerview

import android.app.Dialog
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.EmaSuhaemah.recyclerview.adapter.AdapterTeamBola
import com.EmaSuhaemah.recyclerview.databinding.ActivityMainBinding
import com.EmaSuhaemah.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("David de Gea Quintana",R.drawable.david,"Kiper", "1,92 m", "Madrid", "7 November 1990"))
        listPemain.add(Pemain("José Diogo Dalot Teixeira",R.drawable.diogo,"Bek Kanan", "1,84 m", "Braga", "18 Maret 1999"))
        listPemain.add(Pemain("Luke Shaw",R.drawable.luke,"Bek Kiri", "1,78 m", "Kingston", "12 Jul 1995"))
        listPemain.add(Pemain("Jacob Harry Maguire",R.drawable.hary,"Bek Tengah", "1,94 m", "Sheffield", "5 Maret 1993"))
        listPemain.add(Pemain("Donny van de Beek",R.drawable.donny,"Gelandang Tengah", "1,84 m", "Nijkerkerveen", "18 Apr 1997"))

        binding.list.adapter = AdapterTeamBola(this, listPemain,object : AdapterTeamBola.OnClikListener{
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)
                    val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)
                    image.setImageResource(item?.foto ?: 0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tgllahir.text = "${item?.tgllahir}"
                    tempatlahir.text = "${item?.Tempatlahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }
        })
    }
}