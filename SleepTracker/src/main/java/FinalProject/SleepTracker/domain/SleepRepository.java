package FinalProject.SleepTracker.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SleepRepository extends CrudRepository<Sleep, Long> {

    List<Sleep> findByAppUserUsername(String username);

    List<Sleep> findByDateInput(String dateInput);

}
