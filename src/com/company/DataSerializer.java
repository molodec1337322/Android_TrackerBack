package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Scanner;

public class DataSerializer implements IDataFileSerializer {

    private File jsonFile;
    private Gson gson = new GsonBuilder().create();

    public DataSerializer(String filename) throws IOException {
        jsonFile = new File (new File(".").getAbsolutePath() + filename);
        CheckIsFileCreated();
    }

    private void CheckIsFileCreated() throws IOException {
        if(!jsonFile.exists()){
            jsonFile.createNewFile();
        }
    }

    @Override
    public UserNotesContainer LoadNotes() throws IOException {
        CheckIsFileCreated();
        StringBuilder sb = new StringBuilder();

        FileReader out = new FileReader(jsonFile);
        try (out) {
            Scanner scan = new Scanner(out);
            while (scan.hasNextLine()) {
                sb.append(scan.nextLine());
                sb.append("\n");
            }
        }

        return gson.fromJson(sb.toString(), UserNotesContainer.class);
    }

    @Override
    public void SaveNotes(IUserNotesContainer notes) throws IOException{
        Runnable r = () -> {
            String json = gson.toJson(notes);
            try {
                CheckIsFileCreated();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (PrintWriter in = new PrintWriter(jsonFile)) {
                in.println(json);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        };
    }
}
