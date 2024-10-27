package ma.ensa.projet.notesmodelview

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import ma.ensa.project.notesmodel.Note

class NoteRepository(private val noteDao: NoteDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allNotes: Flow<List<Note>> = noteDao.getAlphabetizedNotes()

    @WorkerThread
    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

    @WorkerThread
    suspend fun delete(note: Note) {
        noteDao.deleteNote(note)
    }
}
