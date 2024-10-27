package ma.ensa.projet.notesmodelview

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import ma.ensa.project.notesmodel.Note
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException



@RunWith(AndroidJUnit4::class)
class NoteDaoTest {

    private lateinit var noteDao: NoteDao
    private lateinit var db: NoteRoomDatabase

    @Before
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext()
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, NoteRoomDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        noteDao = db.wordDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetWord() = runBlocking {
        val note = Note("word")
        noteDao.insert(note)
        val allWords = noteDao.getAlphabetizedWords().first()
        assertEquals(allWords[0].word, note.word)
    }

    @Test
    @Throws(Exception::class)
    fun getAllWords() = runBlocking {
        val note = Note("aaa")
        noteDao.insert(note)
        val note2 = Note("bbb")
        noteDao.insert(note2)
        val allWords = noteDao.getAlphabetizedWords().first()
        assertEquals(allWords[0].word, note.word)
        assertEquals(allWords[1].word, note2.word)
    }

    @Test
    @Throws(Exception::class)
    fun deleteAll() = runBlocking {
        val note = Note("word")
        noteDao.insert(note)
        val note2 = Note("word2")
        noteDao.insert(note2)
        noteDao.deleteAll()
        val allWords = noteDao.getAlphabetizedWords().first()
        assertTrue(allWords.isEmpty())
    }
}
