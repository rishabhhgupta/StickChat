package com.promiseek.StickChat.Add.Fragment.TenorGifs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.promiseek.StickChat.R
import com.example.example.ApiResults
import com.promiseek.StickChat.Add.GetSelectedItemFromFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class GifsFragment(var getSelectedItemFromFragment: GetSelectedItemFromFragment) : Fragment(), LastIndex {
    lateinit var ApiResults: ApiCalled;
    lateinit var gifsRecyclerView:RecyclerView
    lateinit var centerProgresbar:ProgressBar
    lateinit var bottomProgressBar:ProgressBar
    lateinit var next: String
    lateinit var gifsAdapter:GifsAdapter
     companion object{




         }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://tenor.googleapis.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        ApiResults = retrofit.create(ApiCalled::class.java)
        getFeaturedGifs("")



    }

    fun getFeaturedGifs(next: String){
        val getFeatured: Call<ApiResults> = ApiResults.getFeatured(getString(R.string.Api_id), "stickchat", "10", next);
        getFeatured.enqueue(object :Callback<ApiResults>{
            override fun onResponse(call: Call<ApiResults>, response: Response<ApiResults>) {
                val adapterArrayList = ArrayList<AdapterPogo>()
                response.body()!!.results.forEach {

                    val adapterPogo =AdapterPogo();
                    adapterPogo.previewGifs = it.mediaFormats!!.nanogif!!.url.toString()
                    adapterPogo.actualGifs = it.mediaFormats!!.tinygif!!.url.toString()

                    adapterArrayList.add(adapterPogo)
                }
                this@GifsFragment.next = response.body()!!.next.toString()
                centerProgresbar.visibility = GONE
                bottomProgressBar.visibility = GONE
                gifsAdapter.addItems(adapterArrayList)





            }


            override fun onFailure(call: Call<ApiResults>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                Log.i("myFeaturedGifss", t.toString())
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view:View = inflater.inflate(R.layout.fragment_template, container, false)
        gifsRecyclerView = view.findViewById<RecyclerView>(R.id.GifsRecyclerView)
        centerProgresbar = view.findViewById<ProgressBar>(R.id.centerProgresbar)
        bottomProgressBar = view.findViewById<ProgressBar>(R.id.bottomProgressBar)
        
        gifsRecyclerView.setHasFixedSize(false)
        gifsRecyclerView.setLayoutManager(GridLayoutManager(context, 2))
        gifsAdapter = GifsAdapter(requireContext(),this, getSelectedItemFromFragment )
        gifsRecyclerView.adapter = gifsAdapter

        return view

    }

    override fun get() {
        bottomProgressBar.visibility = VISIBLE
        getFeaturedGifs(next)
    }








}