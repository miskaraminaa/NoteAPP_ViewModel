package ma.ensa.project.notesmodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "note_table")
data class Note(@PrimaryKey @ColumnInfo(name = "note") val note: String)
