package HH.palvelinohjelmointi.WorkoutNotes.web;


import HH.palvelinohjelmointi.WorkoutNotes.domain.Level;

import HH.palvelinohjelmointi.WorkoutNotes.domain.LevelRepository;
import HH.palvelinohjelmointi.WorkoutNotes.domain.NoteRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

public class LevelController {
	
	@Autowired
	NoteRepository nrepository;
	
	@Autowired
	LevelRepository lrepository; 
	
	
	@RequestMapping(value = "/levellist", method = RequestMethod.GET)
	public String getLevels(Model model) {
			List<Level> level =  (List<Level>) lrepository.findAll(); 
			model.addAttribute("level", level); 
			return "levellist"; 
								
		}
	@RequestMapping(value = "/newlevel", method = RequestMethod.GET)
	public String getaddNewLevel(Model model) {
		model.addAttribute("level", new Level());
		return "newlevelform";
	}

	
	@RequestMapping(value = "/savelevel", method = RequestMethod.POST)
	public String saveLevel(@ModelAttribute Level level) {
		
		lrepository.save(level);
		return "redirect:/levellist";
	}
	@RequestMapping(value = "/deletelevel/{id}", method = RequestMethod.GET)
	public String deleteLevel(@PathVariable("id") Long levelid) {
		lrepository.deleteById(levelid);
		return "redirect:../levellist";
	}
	
    @RequestMapping(value="/levels", method = RequestMethod.GET)
    public @ResponseBody List<Level> getLevelsRest() {	
        return (List<Level>) lrepository.findAll();
    }    

	
    @RequestMapping(value="/levels/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Level> findLevelRest(@PathVariable("id") Long lId) {	
    	return lrepository.findById(lId);
    } 
    
    
    @RequestMapping(value="/levels", method = RequestMethod.POST)
    public @ResponseBody Level saveNoteRest(@RequestBody Level level) {	
    	return lrepository.save(level);
    }
}

