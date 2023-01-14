package net.virgis.tutorials.notesapp.feature_note.domain.use_case

import net.virgis.tutorials.notesapp.feature_note.domain.model.Note
import net.virgis.tutorials.notesapp.feature_note.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}