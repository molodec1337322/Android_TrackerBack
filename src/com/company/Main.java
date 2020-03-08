package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        IUserNotesContainer notesContainer = new UserNotesContainer();

        UserNote note_1 = new UserNote("Задача 1", "Селать что-то");
        UserNote note_2 = new UserNote("Задача 2", "Селать то-то");
        UserNote note_3 = new UserNote("Задача 3", "Селать что-то то");

        notesContainer.AddNote(note_1);
        notesContainer.AddNote(note_2);
        notesContainer.AddNote(note_3);

        IDataFileSerializer serializer = new DataSerializer("dsafas.json");
        serializer.SaveNotes(notesContainer);

        UserNotesContainer notesContainer_1 = serializer.LoadNotes();
        int id = 2;
        System.out.print(notesContainer_1.GetNoteByID(id).GetHeader() + ": " + notesContainer_1.GetNoteByID(id).GetText());

        UserNote note_4 = new UserNote("Задача 4", "Селать что-то то asfda");
        notesContainer_1.AddNote(note_4);
        serializer.SaveNotes(notesContainer_1);

        id = 3;
        UserNotesContainer notesContainer_2 = serializer.LoadNotes();
        System.out.print(notesContainer_1.GetNoteByID(id).GetHeader() + ": " + notesContainer_1.GetNoteByID(id).GetText());
    }
}
