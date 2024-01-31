package fr.mb.peoplejob.repository.model;

import fr.mb.peoplejob.model.job.JobResource;
import fr.mb.peoplejob.model.people.PeopleResource;
import fr.mb.peoplejob.repository.JobRepository;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class JobDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String companyName;
    private String jobName;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    private PeopleDB people;

    public JobDB() {
    }

    public JobDB(String companyName, String jobName, LocalDate startDate, LocalDate endDate, PeopleDB people) {
        this.companyName = companyName;
        this.jobName = jobName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.people = people;
    }

    public JobResource toJobResource(){
        return new JobResource(this.id, this.companyName, this.jobName, this.startDate, this.endDate, this.people.toPeopleResource());
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
