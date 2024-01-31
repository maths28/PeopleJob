package fr.mb.peoplejob.repository;

import fr.mb.peoplejob.repository.model.PeopleDB;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends CrudRepository<PeopleDB, Long> {

    public List<PeopleDB> findByOrderByFirstNameAscLastNameAsc();

    @Query("select job.people from JobDB job where job.companyName = :companyName")
    public List<PeopleDB> findAllByCompanyName(String companyName);

}
