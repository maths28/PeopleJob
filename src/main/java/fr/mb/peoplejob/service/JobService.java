package fr.mb.peoplejob.service;


import fr.mb.peoplejob.exception.PeopleJobException;
import fr.mb.peoplejob.model.job.JobResource;
import fr.mb.peoplejob.model.job.JobSaveRequest;
import fr.mb.peoplejob.repository.JobRepository;
import fr.mb.peoplejob.repository.PeopleRepository;
import fr.mb.peoplejob.repository.model.PeopleDB;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobService {

    private JobRepository jobRepository;

    private PeopleRepository peopleRepository;

    public JobService(JobRepository jobRepository, PeopleRepository peopleRepository) {
        this.jobRepository = jobRepository;
        this.peopleRepository = peopleRepository;
    }

    public JobResource saveJob(JobSaveRequest jobSaveRequest, Long peopleId) throws PeopleJobException{
        PeopleDB peopleDB = peopleRepository.findById(peopleId).orElseThrow(() -> new PeopleJobException("La personne n'est pas connue"));
        return this.jobRepository.save(jobSaveRequest.toJobDB(peopleDB)).toJobResource();
    }

}
