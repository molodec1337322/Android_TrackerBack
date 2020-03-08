package com.company;

public class UserNote implements IUserNote
{
    private String header;
    private String text;

    public UserNote(){}

    public UserNote(String header, String text) {
        this.header = header;
        this.text = text;
    }

    @Override
    public String GetHeader() {
        return header;
    }

    @Override
    public String GetText() {
        return text;
    }
}
