package HH.palvelinohjelmointi.WorkoutNotes;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import HH.palvelinohjelmointi.WorkoutNotes.web.WorkoutNotesController;

//@RunWith(SpringRunner.class) // JUnit4
@ExtendWith(SpringExtension.class)   // JUnit5 eli Jupiter
@SpringBootTest
public class WorkoutNotesApplicationTests {

	@Autowired
	private WorkoutNotesController WorkoutNotesController;
	
	@Test
	public void contextLoads() {
		assertThat(WorkoutNotesController).isNotNull();
	}

}