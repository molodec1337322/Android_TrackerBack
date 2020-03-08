package com.company;

import java.io.IOException;
import java.util.ArrayList;

public interface IDataFileSerializer {
    public UserNotesContainer LoadNotes() throws IOException;
    public void SaveNotes(IUserNotesContainer notes) throws IOException;
}
