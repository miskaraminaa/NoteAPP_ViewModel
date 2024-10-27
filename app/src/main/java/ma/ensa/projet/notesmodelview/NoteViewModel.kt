import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ma.ensa.project.notesmodel.Note
import ma.ensa.projet.notesmodelview.NoteRepository

class NoteViewModel(
    private val repository: NoteRepository,// gère l'accès aux données des notes.
    private val savedStateHandle: SavedStateHandle // Une instance de SavedStateHandle, utilisée pour stocker des données qui doivent survivre aux changements de configuration
) : ViewModel() {


        // expose toutes les notes sous forme de LiveData. Lorsque les notes changent dans le repository,
    // cette LiveData est mise à jour et notifie l'interface utilisateur.
    val allNotes: LiveData<List<Note>> = repository.allNotes.asLiveData()

    // Clé pour sauvegarder le contenu d'une note temporaire
    private val NOTE_CONTENT_KEY = "note_content_key"

//Cette propriété expose le contenu de la note sous forme de LiveData.
// Il utilise la clé définie précédemment pour accéder à la valeur dans savedStateHandle
    val noteContent: LiveData<String?> = savedStateHandle.getLiveData(NOTE_CONTENT_KEY)

    fun setNoteContent(content: String) {
        savedStateHandle[NOTE_CONTENT_KEY] = content
    }

    fun insert(note: Note) = viewModelScope.launch {
        repository.insert(note)
    }

    fun deleteNote(note: Note) = viewModelScope.launch {
        repository.delete(note)
    }
}

class NoteViewModelFactory(private val repository: NoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NoteViewModel(repository, SavedStateHandle()) as T // Création de NoteViewModel avec SavedStateHandle
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
