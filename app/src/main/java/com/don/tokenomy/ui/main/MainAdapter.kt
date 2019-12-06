package com.don.tokenomy.ui.main

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.don.tokenomy.R
import com.don.tokenomy.data.remote.MdlMarket

/**
 * Created by gideon on 06,December,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */

class MainAdapter(val activity: Activity) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val listMovie = ArrayList<MdlMarket>()


    fun setData(items: List<MdlMarket>) {

        listMovie.addAll(items)
        notifyDataSetChanged()
    }


    fun clearList() {
        listMovie.clear()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(activity)
        return MovieViewHolder(inflater.inflate(R.layout.item_list_token, parent, false))

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as MovieViewHolder
        holder.bind(listMovie[position])

        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(holder.itemView.context.resources.getColor(R.color.colorWhite))
        } else {
            holder.itemView.setBackgroundColor(holder.itemView.context.resources.getColor(R.color.colorLightGrey))
        }
    }


    override fun getItemCount() = listMovie.size

    class MovieViewHolder internal constructor(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
        private val tvMarket: TextView = itemView.findViewById(R.id.tvMarket)
        private val tvLastPrice: TextView = itemView.findViewById(R.id.tvLastPrice)
        private val tvTwoFour: TextView = itemView.findViewById(R.id.tvTwoFour)
        private val tvPercent: TextView = itemView.findViewById(R.id.tvPercent)
        private val ivPercentUp: ImageView = itemView.findViewById(R.id.ivPercentUp)
        private val ivPercentDown: ImageView = itemView.findViewById(R.id.ivPercentDown)
        private val ll: LinearLayout = itemView.findViewById(R.id.ll)


        fun bind(model: MdlMarket) {
            tvMarket.text = model.market
            tvLastPrice.text = model.lastPrice
            tvPercent.text = model.percentage.toString()

            if (model.percentage <= -0f) {
//                ivPercent.background = itemView.context.getDrawable(R.drawable.ic_down_arrow_red)
                ivPercentDown.visibility = View.VISIBLE
                ivPercentUp.visibility = View.GONE
            }

            if (model.percentage == 0f) {
                ivPercentDown.visibility = View.VISIBLE
                ivPercentUp.visibility = View.GONE
                ivPercentDown.visibility = View.INVISIBLE

            }

            if (model.percentage > 0f) {
                ivPercentDown.visibility = View.GONE
                ivPercentUp.visibility = View.VISIBLE
            }


            ll.setOnClickListener {
                //                val intent = Intent(itemView.context, DetailActivity::class.java)
//                intent.putExtra(DetailActivity.EXTRA_IMDB, movie)
//                itemView.context.startActivity(intent)
            }

        }
    }


}
