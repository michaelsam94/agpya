package michael.com.agpya.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "hourly_prayers")
data class HourlyPrayer(@PrimaryKey(autoGenerate = true) val _id: Int = 0,
                        @ColumnInfo(name = "prayer_title") val prayerTitle: String)