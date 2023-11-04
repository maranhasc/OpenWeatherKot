package net.azarquiel.recyclerviewpajaros.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import net.azarquiel.weather.R
import net.azarquiel.weather.model.Dia

/**
 * Created by pacopulido on 9/10/18.
 */
class CustomAdapter(val context: Context,
                    val layout: Int
                    ) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var dataList: List<Dia> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewlayout = layoutInflater.inflate(layout, parent, false)
        return ViewHolder(viewlayout, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    internal fun setDias(dias: List<Dia>) {
        this.dataList = dias
        notifyDataSetChanged()
    }


    class ViewHolder(viewlayout: View, val context: Context) : RecyclerView.ViewHolder(viewlayout) {
        fun bind(dataItem: Dia){
            // itemview es el item de diseño
            // al que hay que poner los datos del objeto dataItem
            val ivrowdia = itemView.findViewById(R.id.ivrowdia) as ImageView
            val tvrowfecha = itemView.findViewById(R.id.tvrowfecha) as TextView
            val tvrowpop = itemView.findViewById(R.id.tvrowpop) as TextView
            val tvrowprono = itemView.findViewById(R.id.tvrowprono) as TextView
            val tvrowtemp = itemView.findViewById(R.id.tvrowtemp) as TextView


            tvrowpop.text = "${dataItem.pop}%"
            tvrowfecha.text = "${dataItem.dt_txt}"
            tvrowprono.text = "${dataItem.pronoico.get(0).description}"
            tvrowtemp.text = "${dataItem.temperaturas.tem_min}-${dataItem.temperaturas.tem_max}"


            // foto de internet a traves de Picasso
            Picasso.get().load("http://openweathermap.org/img/wn/${dataItem.pronoico.get(0).icon}@4x.png").into(ivrowdia)


            itemView.tag = dataItem


        }

    }
}