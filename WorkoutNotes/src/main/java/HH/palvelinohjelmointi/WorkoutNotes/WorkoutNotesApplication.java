package HH.palvelinohjelmointi.WorkoutNotes;

import java.util.Locale;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import HH.palvelinohjelmointi.WorkoutNotes.domain.Level;
import HH.palvelinohjelmointi.WorkoutNotes.domain.LevelRepository;
import HH.palvelinohjelmointi.WorkoutNotes.domain.Note;
import HH.palvelinohjelmointi.WorkoutNotes.domain.NoteRepository;
import HH.palvelinohjelmointi.WorkoutNotes.domain.User;
import HH.palvelinohjelmointi.WorkoutNotes.domain.UserRepository;

@SpringBootApplication
public class WorkoutNotesApplication {
	private static final Logger log = LoggerFactory.getLogger(WorkoutNotesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WorkoutNotesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(NoteRepository nrepository, LevelRepository lrepository, UserRepository urepository) 
	{return (args) -> {
		
		log.info("tallennetaan muutama kategoria ja kirjoja");
		
		Level level1 = new Level("Easy");
		lrepository.save(level1);
		Level level2 = new Level("Medium");
		lrepository.save(level2);
		Level level3 = new Level("Hard");
		lrepository.save(level3);
		
		
		nrepository.save(new Note ("Legs", "Unohdin kuulokkeet kotii :(", 14, level2));
		nrepository.save(new Note ("Arms", "Loukkasin varpaan :(", 14, level3));
		
		User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
		urepository.save(user1);
		urepository.save(user2);
		
		
		log.info("fetch all notes");
		for (Note note : nrepository.findAll()) {
			log.info(note.toString());
		}
	
		
	};
	
	
	
	

	}

	}
	
	
	





