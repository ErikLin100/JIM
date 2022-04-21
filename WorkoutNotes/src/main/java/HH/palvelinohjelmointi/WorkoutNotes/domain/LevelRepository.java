package HH.palvelinohjelmointi.WorkoutNotes.domain;

import java.util.List;


import org.springframework.data.repository.CrudRepository;




public interface LevelRepository extends CrudRepository<Level, Long>{
		
	List<Level> findByName(String name);
	
		
}