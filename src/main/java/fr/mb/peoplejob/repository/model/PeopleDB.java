package fr.mb.peoplejob.repository.model;

import fr.mb.peoplejob.model.people.PeopleResource;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class PeopleDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "people")
    private List<JobDB> jobs;

    public PeopleDB(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public List<JobDB> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobDB> jobs) {
        this.jobs = jobs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PeopleDB() {
    }

    public PeopleResource toPeopleResource(){
        return new PeopleResource(this.id, this.firstName, this.lastName, this.dateOfBirth);
    }

}
