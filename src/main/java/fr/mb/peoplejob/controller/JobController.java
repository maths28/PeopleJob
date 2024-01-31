package fr.mb.peoplejob.controller;

import fr.mb.peoplejob.model.job.JobResource;
import fr.mb.peoplejob.model.job.JobSaveRequest;
import fr.mb.peoplejob.model.people.PeopleResource;
import fr.mb.peoplejob.model.people.PeopleSaveRequest;
import fr.mb.peoplejob.service.JobService;
import fr.mb.peoplejob.service.PeopleService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/people/{id}/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public JobResource saveJob(@RequestBody JobSaveRequest jobSaveRequest, @PathVariable("id") Long peopleId) throws Exception{
        return this.jobService.saveJob(jobSaveRequest, peopleId);
    }
}
