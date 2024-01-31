package fr.mb.peoplejob.service;

import fr.mb.peoplejob.exception.PeopleJobException;
import fr.mb.peoplejob.model.people.PeopleListResource;
import fr.mb.peoplejob.model.people.PeopleResource;
import fr.mb.peoplejob.model.people.PeopleSaveRequest;
import fr.mb.peoplejob.repository.PeopleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class PeopleService {

    private PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository){
        this.peopleRepository = peopleRepository;
    }

    public PeopleResource savePeople(PeopleSaveRequest peopleSaveRequest) throws Exception{
        if(ChronoUnit.YEARS.between(peopleSaveRequest.getDateOfBirth(), LocalDate.now()) > 150){
            throw new PeopleJobException("L'age de la personne dépasse 150 ans");
        }
        return peopleRepository.save(peopleSaveRequest.toPeopleDB()).toPeopleResource();
    }

    public List<PeopleListResource> findAll(){
        return this.peopleRepository.findByOrderByFirstNameAscLastNameAsc().stream().map((peopleDB -> {
            PeopleListResource peopleListResource = new PeopleListResource();
            peopleListResource.setId(peopleDB.getId());
            peopleListResource.setFirstName(peopleDB.getFirstName());
            peopleListResource.setLastName(peopleDB.getLastName());
            peopleListResource.setAge(ChronoUnit.YEARS.between(peopleDB.getDateOfBirth(), LocalDate.now()));
            peopleListResource.setJobs(peopleDB.getJobs().stream().filter((jobDB ->
                    !jobDB.getStartDate().isAfter(LocalDate.now()) && (jobDB.getEndDate() == null || !jobDB.getEndDate().isBefore(LocalDate.now())))
            ).map(jobDB ->  jobDB.toJobResource()).toList());
            return peopleListResource;
        })).toList();
    }

    public List<PeopleResource> findAllByCompanyName(String companyName){
        return this.peopleRepository.findAllByCompanyName(companyName).stream().map((peopleDB -> peopleDB.toPeopleResource())).toList();
    }

}
