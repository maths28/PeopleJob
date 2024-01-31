package fr.mb.peoplejob.model.people;

import fr.mb.peoplejob.model.job.JobResource;

import java.time.LocalDate;
import java.util.List;

public class PeopleListResource {

    private Long id;
    private String firstName;
    private String lastName;
    private Long age;

    private List<JobResource> jobs;

    public PeopleListResource() {
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

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public List<JobResource> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobResource> jobs) {
        this.jobs = jobs;
    }
}
