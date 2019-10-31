package michael.com.agpya

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import michael.com.agpya.model.HourlyPrayer


class MainActivity : AppCompatActivity(), HourPrayersAdapter.OnItemClick {
    override fun onItemClick(prayerId: Int) {
        val i = Intent(this@MainActivity, PrayerActivity::class.java)
        i.putExtra(PrayerActivity.PRAYER_ID, prayerId)
        startActivity(i)
    }


    var rvHourPrayers: RecyclerView? = null
    var hourlyPrayerAdapter: HourPrayersAdapter? = null
    lateinit var dp: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dp = (applicationContext as AgpyaApp).dp
        rvHourPrayers = findViewById(R.id.rv_hour_prayers)

        initHourlyAdapter()


    }


    fun getAllHourlyPrayers(): List<HourlyPrayer> {
        return dp.hourlyPrayerDao().getAllHourlyPrayers()
    }

    fun initHourlyAdapter() {
        hourlyPrayerAdapter = HourPrayersAdapter(this, getAllHourlyPrayers())
        rvHourPrayers?.adapter = hourlyPrayerAdapter
        rvHourPrayers?.layoutManager = LinearLayoutManager(this)
    }


}
