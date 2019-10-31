package michael.com.agpya.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "prayerHourlyPrayer")
/*foreignKeys = arrayOf(
       ForeignKey(entity = HourlyPrayer::class, parentColumns = arrayOf("_id"), childColumns = arrayOf("hourlyPrayerId")),
       ForeignKey(entity = Prayer::class, parentColumns = arrayOf("_id"), childColumns = arrayOf("prayerId"))))*/
data class PrayerHourlyPrayer(
        @PrimaryKey(autoGenerate = true) val _id: Int,
        @ColumnInfo(name = "hourlyPrayerId") val hourlyPrayerId: Int,
        @ColumnInfo(name = "prayerId") val prayerId: Int)