package com.example.devner.myapplication;

public class Note
{
    private Double noteId;
    private String notePayload;

    public Note(Double noteId, String notePayload)
    {
        this.noteId = noteId;
        this.notePayload = notePayload;
    }

    public Double getNoteId()
    {
        return noteId;
    }

    public void setNoteId(final Double noteId)
    {
        this.noteId = noteId;
    }

    public String getNotePayload()
    {
        return notePayload;
    }

    public void setNotePayload(final String notePayload)
    {
        this.notePayload = notePayload;
    }
}