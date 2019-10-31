package michael.com.agpya

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import michael.com.agpya.model.HourlyPrayer
import michael.com.agpya.model.Prayer
import michael.com.agpya.model.PrayerHourlyPrayer


@Database(entities = [Prayer::class, HourlyPrayer::class, PrayerHourlyPrayer::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "kholagy"
                ).allowMainThreadQueries().createFromAsset("agpya.db").build()
                INSTANCE = instance
                return instance
            }
        }
    }

    abstract fun prayerDao(): PrayerDao

    abstract fun hourlyPrayerDao(): HourlyPrayerDao

    abstract fun prayerHourlyPrayerDao(): PrayerHourlyPrayerDao
}