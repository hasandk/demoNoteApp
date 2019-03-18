package com.dagbog.demo.models;

public class Note {
    private int noteId;
    private String name;
    private String indhold;

    public Note() {
    }

    public Note(int noteId, String name, String indhold) {
        this.noteId = noteId;
        this.name = name;
        this.indhold = indhold;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndhold() {
        return indhold;
    }

    public void setIndhold(String indhold) {
        this.indhold = indhold;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", name='" + name + '\'' +
                ", indhold='" + indhold + '\'' +
                '}';
    }
}
