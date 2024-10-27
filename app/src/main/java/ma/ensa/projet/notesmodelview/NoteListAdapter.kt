
package ma.ensa.projet.notesmodelview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ma.ensa.project.notesmodel.Note

class NoteListAdapter : ListAdapter<Note, NoteListAdapter.NoteViewHolder>(NOTES_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):NoteViewHolder {
        return NoteViewHolder.create(parent)
    }
    fun getNoteAtPosition(position: Int): Note {
        return getItem(position)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.note)
    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val noteItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            noteItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): NoteViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return NoteViewHolder(view)
            }
        }
    }

    companion object {
        private val NOTES_COMPARATOR = object : DiffUtil.ItemCallback<Note>() {
            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem.note == newItem.note
            }
        }
    }
}
