package com.company;

import java.util.ArrayList;

public interface IUserNotesContainer {
    ArrayList<UserNote> GetNotes();
    void AddNote(UserNote note);
}
