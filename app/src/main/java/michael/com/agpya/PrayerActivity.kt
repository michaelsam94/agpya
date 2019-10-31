package michael.com.agpya

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import michael.com.agpya.model.Prayer

class PrayerActivity : AppCompatActivity() {

    companion object {
        val PRAYER_ID = "prayer_id"
    }


    var prayerSpinner: Spinner? = null
    var prayerTextView: TextView? = null
    lateinit var dp: AppDatabase

    var prayerId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prayer)
        dp = (applicationContext as AgpyaApp).dp
        prayerId = intent.getIntExtra(PRAYER_ID, 0)
        title = getHourPrayerTitle(prayerId)

        prayerSpinner = findViewById(R.id.prayer_spinner)
        prayerTextView = findViewById(R.id.prayer_textview)
        prayerTextView?.movementMethod = ScrollingMovementMethod()

        prayerSpinner?.adapter = ArrayAdapter(this, android.R.layout
                .simple_dropdown_item_1line, getPrayersTitles())


        prayerSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                prayerTextView?.text = getPrayers(getPrayersIdOfHourPrayer(prayerId))[0].content
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                prayerTextView?.text = getPrayers(getPrayersIdOfHourPrayer(prayerId))[position].content
            }

        }


    }

    fun getPrayers(prayersIds: List<Int>): List<Prayer> {
        val prayers: MutableList<Prayer> = mutableListOf()
        for (p in prayersIds) {
            prayers.add(dp.prayerDao().getPrayerById(p))
        }
        return prayers
    }

    fun getPrayersIdOfHourPrayer(hourPrayerId: Int): List<Int> {
        val prayerHourPrayer = dp.prayerHourlyPrayerDao().getAllPrayersOfHour(hourPrayerId)
        val prayersIds: MutableList<Int> = mutableListOf()
        for (p in prayerHourPrayer) {
            prayersIds.add(p.prayerId)
        }
        return prayersIds
    }


    fun getPrayersTitles(): List<String> {
        var prayers = getPrayers(getPrayersIdOfHourPrayer(prayerId))
        var prayerTitles: MutableList<String> = mutableListOf()
        for (p: Prayer in prayers) {
            prayerTitles.add(p.title)
        }
        return prayerTitles
    }

    fun getHourPrayerTitle(hourPrayerId: Int): String {
        return dp.hourlyPrayerDao().getHourPrayerById(hourPrayerId).prayerTitle
    }


}
