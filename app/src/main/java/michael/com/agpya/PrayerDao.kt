package michael.com.agpya

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import michael.com.agpya.model.Prayer


@Dao
interface PrayerDao {


    @Insert
    fun insertPrayer(prayer: Prayer)

    @Query("select * from prayers")
    fun getAllPrayers(): List<Prayer>

    @Query("select * from prayers where _id= :prayerId")
    fun getPrayerById(prayerId: Int): Prayer


}