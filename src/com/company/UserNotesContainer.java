package com.company;

import java.util.ArrayList;

public class UserNotesContainer implements IUserNotesContainer {

    private ArrayList<UserNote> notes = new ArrayList<UserNote>(0);

    public UserNotesContainer(){ }

    public UserNotesContainer(ArrayList<UserNote> notes){
        this.notes.addAll(notes);
    }

    private boolean CheckArrBorders(int id){
        return id >= 0 && id < notes.size();
    }

    @Override
    public ArrayList<UserNote> GetNotes() {
        return notes;
    }

    public UserNote GetNoteByID(int id){
        if(CheckArrBorders(id)){
            return notes.get(id);
        }
        else{
            return null;
        }
    }

    @Override
    public void AddNote(UserNote note) {
        notes.add(note);
    }

    public void DeleteNote(int id){
        if(CheckArrBorders(id))
        {
            notes.remove(id);
        }
    }
}
