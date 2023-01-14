package net.virgis.tutorials.notesapp.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.virgis.tutorials.notesapp.feature_note.data.data_source.NoteDatabase
import net.virgis.tutorials.notesapp.feature_note.data.repository.NoteRepositoryImpl
import net.virgis.tutorials.notesapp.feature_note.domain.repository.NoteRepository
import net.virgis.tutorials.notesapp.feature_note.domain.use_case.AddNote
import net.virgis.tutorials.notesapp.feature_note.domain.use_case.DeleteNote
import net.virgis.tutorials.notesapp.feature_note.domain.use_case.GetNotes
import net.virgis.tutorials.notesapp.feature_note.domain.use_case.NoteUseCases
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
    }
}