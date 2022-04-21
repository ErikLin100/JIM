package HH.palvelinohjelmointi.WorkoutNotes.web;


import HH.palvelinohjelmointi.WorkoutNotes.domain.NoteRepository;

import HH.palvelinohjelmointi.WorkoutNotes.domain.LevelRepository;
import HH.palvelinohjelmointi.WorkoutNotes.domain.Note;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin

public class WorkoutNotesController {
	
	@Autowired
	NoteRepository repository; 
	
	@Autowired
	LevelRepository lrepository; 
	
	
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	@RequestMapping(value = "/notelist", method = RequestMethod.GET)
	public String noteList(Model model, HttpServletRequest request) {
			 
			model.addAttribute("notes", repository.findAll());
			
			Locale currentLocale = request.getLocale();
			String countryCode = currentLocale.getCountry();
			String countryName = currentLocale.getDisplayCountry();
			String langCode = currentLocale.getLanguage();
			String langName = currentLocale.getDisplayLanguage();
			
			System.out.println(countryCode + ": " + countryName );
			System.out.println(langCode + ": " + langName);
			
			System.out.println("============");
			String[] languages = Locale.getISOLanguages();
			
			for (String language : languages) {
				Locale locale = new Locale(language);
				System.out.println(language + ": " + locale.getDisplayLanguage());
			}
			
			
			
			return "notelist"; 
								
		}
	
    @RequestMapping(value="/notes", method = RequestMethod.GET)
    public @ResponseBody List<Note> noteListRest() {	
        return (List<Note>) repository.findAll();
    }    


    @RequestMapping(value="/notes/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Note> findNoteRest(@PathVariable("id") Long noteId) {	
    	return repository.findById(noteId);
    }      
    
    
    @RequestMapping(value="/notes", method = RequestMethod.POST)
    public @ResponseBody Note saveNoteRest(@RequestBody Note note) {	
    	return repository.save(note);
    }
	
	
	@RequestMapping(value = "/newnote", method = RequestMethod.GET)
	public String addNote(Model model) {
		model.addAttribute("note", new Note());
		model.addAttribute("levels", lrepository.findAll());
		return "addnote";
	}

	
	@RequestMapping(value = "/savenote", method = RequestMethod.POST)
	public String saveNote(@ModelAttribute Note note) {
		
		repository.save(note);
		return "redirect:/notelist";
	}

	
	@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/deletenote/{id}", method = RequestMethod.GET)
    public String deleteNote(@PathVariable("id") Long noteId, Model model) {
    	repository.deleteById(noteId);
        return "redirect:../notelist";
    }  
}
	

