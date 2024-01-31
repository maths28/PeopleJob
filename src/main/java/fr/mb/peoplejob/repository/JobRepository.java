package fr.mb.peoplejob.repository;

import fr.mb.peoplejob.repository.model.JobDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface JobRepository extends CrudRepository<JobDB, Long> {

}
