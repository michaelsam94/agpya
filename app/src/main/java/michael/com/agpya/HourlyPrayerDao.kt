package michael.com.agpya

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import michael.com.agpya.model.HourlyPrayer


@Dao
interface HourlyPrayerDao {

    @Query("SELECT * FROM hourly_prayers")
    fun getAllHourlyPrayers(): List<HourlyPrayer>

    @Query("select * from hourly_prayers where _id= :hourPrayerId")
    fun getHourPrayerById(hourPrayerId: Int): HourlyPrayer

    @Insert
    fun insertHourlyPrayer(hourlyPrayer: HourlyPrayer)


}