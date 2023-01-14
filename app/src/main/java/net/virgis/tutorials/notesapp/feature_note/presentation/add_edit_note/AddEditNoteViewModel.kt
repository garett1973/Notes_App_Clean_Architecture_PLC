package net.virgis.tutorials.notesapp.feature_note.presentation.add_edit_note

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import net.virgis.tutorials.notesapp.feature_note.domain.use_case.NoteUseCases
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {

}