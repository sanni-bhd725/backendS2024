package FinalProject.SleepTracker.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SleepRepository extends CrudRepository<Sleep, Long> {

    List<Sleep> findByAppUserUsername(String username);

    List<Sleep> findByDateInput(String dateInput);

}
