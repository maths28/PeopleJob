package fr.mb.peoplejob.controller;

import fr.mb.peoplejob.model.people.PeopleListResource;
import fr.mb.peoplejob.model.people.PeopleResource;
import fr.mb.peoplejob.model.people.PeopleSaveRequest;
import fr.mb.peoplejob.service.PeopleService;
import org.springframework.web.bind.annotation.*;

import javax.xml.parsers.SAXParser;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @PostMapping
    public PeopleResource savePeople(@RequestBody PeopleSaveRequest peopleSaveRequest) throws Exception{
        return this.peopleService.savePeople(peopleSaveRequest);
    }

    @GetMapping("/all")
    public List<PeopleListResource> findAll(){
        return this.peopleService.findAll();
    }

    @GetMapping
    public List<PeopleResource> findAllByCompanyName(@RequestParam String companyName){
        return this.peopleService.findAllByCompanyName(companyName);
    }
}
