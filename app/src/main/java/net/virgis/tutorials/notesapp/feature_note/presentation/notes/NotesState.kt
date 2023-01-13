package net.virgis.tutorials.notesapp.feature_note.presentation.notes


import net.virgis.tutorials.notesapp.feature_note.domain.model.Note
import net.virgis.tutorials.notesapp.feature_note.domain.util.NoteOrder
import net.virgis.tutorials.notesapp.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
