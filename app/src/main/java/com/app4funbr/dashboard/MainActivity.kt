package com.app4funbr.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var mAdapter: RecyclerAdapter? = null
    var mAdapter2: RecyclerAdapter2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecycler()
        criarMock()
        criarMock2()
    }

    private fun setupRecycler() {

        // Configurando o gerenciador de layout para ser uma lista.
        // Configurando o gerenciador de layout para ser uma lista horizontal.
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val layoutManager2 = LinearLayoutManager(this)

        mRecyclerView.layoutManager = layoutManager
        mRecyclerView2.layoutManager = layoutManager2

        // Adiciona o adapter que irá anexar os objetos à lista.
        // Está sendo criado com lista vazia, pois será preenchida posteriormente.
        mAdapter = RecyclerAdapter(ArrayList(0))
        mAdapter2 = RecyclerAdapter2(ArrayList(0))

        mRecyclerView.setAdapter(mAdapter)
        mRecyclerView2.setAdapter(mAdapter2)
        mRecyclerView2.isNestedScrollingEnabled = false

    }

    fun criarMock() {
        var cidade = Cidade()
        cidade.cidade = "Paris"
        cidade.pais = "França"
        cidade.urlFoto = "https://i2.wp.com/lufthansacc.com/wp-content/uploads/2018/05/paris-torre-eiffel-franca.jpg?fit=1920%2C800&ssl=1"
        mAdapter?.updateList(cidade)

        cidade = Cidade()
        cidade.cidade = "Tailândia"
        cidade.pais = "Bangkok"
        cidade.urlFoto = "https://www.intrepidtravel.com/sites/intrepid/files/styles/low-quality/public/elements/product/hero/thailand_sukhothai_historical-park-1100.jpg"
        mAdapter?.updateList(cidade)

        cidade = Cidade()
        cidade.cidade = "Australia"
        cidade.pais = "Melbourne"
        cidade.urlFoto = "https://www.visitmelbourne.com/-/media/images/melbourne/destinations/melbourne-park_mel_r_supplied-082_1150x863.jpg?h=600&iar=1&mh=600&mw=800&w=800&ts=20170206470129&hash=130DD71D109FF4701085F90BA3CE0771"
        mAdapter?.updateList(cidade)
    }

    fun criarMock2() {
        var cidade = Cidade()
        cidade.cidade = "Berlin"
        cidade.pais = "Alemanha"
        cidade.urlFoto = "https://www.visitberlin.de/system/files/styles/visitberlin_bleed_header_visitberlin_mobile_1x/private/image/regierungsviertel01_DL_PPT_0.jpg?h=77a3658e&itok=vNPB4omE"
        mAdapter2?.updateList(cidade)

        cidade = Cidade()
        cidade.cidade = "Montereal"
        cidade.pais = "Canada"
        cidade.urlFoto = "https://static1.mansionglobal.com/production/media/article-images/4cb6c7f5bc93d9f345164373934f2589/large_GettyImages-177873190.jpg"
        mAdapter2?.updateList(cidade)

        cidade = Cidade()
        cidade.cidade = "Rio de Janeiro"
        cidade.pais = "Brasil"
        cidade.urlFoto = "https://i0.wp.com/www.vidadeturista.com/wp-content/uploads/2016/07/vista-rio-de-janeiro-rj.jpg?resize=800%2C445&ssl=1"
        mAdapter2?.updateList(cidade)
    }
}
