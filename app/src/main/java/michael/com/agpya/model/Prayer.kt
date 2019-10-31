package michael.com.agpya.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "prayers")
data class Prayer(@PrimaryKey(autoGenerate = true) val _id: Int = 0,
                  @ColumnInfo(name = "title") val title: String,
                  @ColumnInfo(name = "content") val content: String)
