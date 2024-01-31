package fr.mb.peoplejob.model.job;

import fr.mb.peoplejob.model.people.PeopleResource;

import java.time.LocalDate;

public class JobResource {
    private long id;
    private String companyName;
    private String jobName;
    private LocalDate startDate;
    private LocalDate endDate;
    private PeopleResource people;

    public JobResource(long id, String companyName, String jobName, LocalDate startDate, LocalDate endDate, PeopleResource people) {
        this.id = id;
        this.companyName = companyName;
        this.jobName = jobName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.people = people;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
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

    public PeopleResource getPeople() {
        return people;
    }

    public void setPeople(PeopleResource people) {
        this.people = people;
    }
}
