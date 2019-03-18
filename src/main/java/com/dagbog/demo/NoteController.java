package com.dagbog.demo;

import com.dagbog.demo.models.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class NoteController {
    private List<Note> notes = new ArrayList<>();
    Logger log = Logger.getLogger(NoteController.class.getName());


    @GetMapping("/")
    public String index(Model model){
        log.info("index er blevet kaldet.");
        model.addAttribute("Notes", notes);

    return "index";
    }

    @PostMapping("opretNote")
    public String addNote (Note note){
        note.setNoteId(notes.size());
        System.out.println("har modtaget note" + note);
        //log.info("adding to list is called");
        notes.add(note);
        return "redirect:/";
    }

    @GetMapping("editNote/{noteId}")
    public String editNote (@PathVariable("noteId") int noteId, Model model){
        Note note = new Note();
        for (Note n : notes){
            if (n.getNoteId()==noteId){
                note=n;
            }
        }
        model.addAttribute("note", note);

        return "editNote";
    }

    @PutMapping("editNote")
    public String editNote (@ModelAttribute Note note, Model model){
        for (Note n : notes){
            if(n.getNoteId()==note.getNoteId()){
                n.setName(note.getName());
                n.setIndhold(note.getIndhold());
            }
        }


        return "redirect:/";
    }
}

