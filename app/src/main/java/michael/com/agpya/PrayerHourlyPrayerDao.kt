package michael.com.agpya

import androidx.room.Dao
import androidx.room.Query
import michael.com.agpya.model.PrayerHourlyPrayer


@Dao
interface PrayerHourlyPrayerDao {
    @Query("select * from prayerHourlyPrayer")
    fun getAllPrayerHourlyPrayer(): List<PrayerHourlyPrayer>

    @Query("select * from prayerHourlyPrayer where hourlyPrayerId = :hourPrayerId")
    fun getAllPrayersOfHour(hourPrayerId: Int): List<PrayerHourlyPrayer>


}