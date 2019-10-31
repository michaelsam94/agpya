package michael.com.agpya

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import michael.com.agpya.model.HourlyPrayer


class HourPrayersAdapter(var onItemClick: OnItemClick, var hourPrayers: List<HourlyPrayer>) :
        RecyclerView.Adapter<HourPrayersAdapter.HourPrayerViewHolder>() {

    interface OnItemClick {
        fun onItemClick(prayerId: Int)
    }

    override fun getItemCount(): Int {
        return hourPrayers.size
    }

    override fun onBindViewHolder(holder: HourPrayerViewHolder, position: Int) {
        holder.hourPrayerTitle.text = hourPrayers[position].prayerTitle
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                onItemClick.onItemClick(hourPrayers.get(position)._id)
            }

        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourPrayerViewHolder {
        val layoutInflater: LayoutInflater = parent.context.getSystemService(Context
                .LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val vh = HourPrayerViewHolder(layoutInflater.inflate(R.layout.item_hour_prayer, parent,
                false))
        return vh
    }


    class HourPrayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hourPrayerTitle: TextView = itemView.findViewById(R.id.tv_hour_prayer_title)
    }
}