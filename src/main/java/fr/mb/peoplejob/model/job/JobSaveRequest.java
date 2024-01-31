package fr.mb.peoplejob.model.job;

import fr.mb.peoplejob.repository.model.JobDB;
import fr.mb.peoplejob.repository.model.PeopleDB;

import java.time.LocalDate;

public class JobSaveRequest {

    private String companyName;
    private String jobName;
    private LocalDate startDate;
    private LocalDate endDate;

    public JobSaveRequest(String companyName, String jobName, LocalDate startDate, LocalDate endDate) {
        this.companyName = companyName;
        this.jobName = jobName;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public JobDB toJobDB(PeopleDB people){
        return new JobDB(this.companyName, this.jobName, this.startDate, this.endDate, people);
    }

}
