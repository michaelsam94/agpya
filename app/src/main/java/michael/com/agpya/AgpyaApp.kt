package michael.com.agpya

import android.app.Application


class AgpyaApp : Application() {

    lateinit var dp: AppDatabase

    override fun onCreate() {
        super.onCreate()
        dp = AppDatabase.getDatabase(this)

    }
}