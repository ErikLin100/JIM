package HH.palvelinohjelmointi.WorkoutNotes;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import HH.palvelinohjelmointi.WorkoutNotes.domain.Level;
import HH.palvelinohjelmointi.WorkoutNotes.domain.Note;
import HH.palvelinohjelmointi.WorkoutNotes.domain.NoteRepository;

@RunWith(SpringRunner.class)  //JUnit4
@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class NoteRepositoryTest {

    @Autowired
    
    private NoteRepository repository;

    @Test  // testataan NoteRepositoryn findByLastWeek()-metodin toimivuutta
    public void findByWeekShouldReturnNote() {
        List<Note> notes = repository.findByWeek(14);
        
        assertThat(notes).hasSize(2);
        assertThat(notes.get(0).getWeek()).isEqualTo(14);
    }
    
    @Test // testataan NoteRepositoryn save()-metodin toimivuutta
    public void createNewNote() {
    	Note note = new Note("chest", "test", 14, new Level("JUNITTEST"));
    	repository.save(note);
    	assertThat(note.getId()).isNotNull();
    }    

}