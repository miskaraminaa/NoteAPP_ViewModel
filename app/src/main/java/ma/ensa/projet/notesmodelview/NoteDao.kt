package ma.ensa.projet.notesmodelview

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ma.ensa.project.notesmodel.Note


@Dao
interface  NoteDao {

    @Query("SELECT * FROM note_table ORDER BY note ASC")
    fun getAlphabetizedNotes(): Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Query("DELETE FROM note_table")
    suspend fun deleteAll()


    @Delete
    suspend fun deleteNote(note: Note)



}
