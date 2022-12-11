package htl.steyr.web;


import htl.steyr.model.Appiontment;
import htl.steyr.model.Field;
import htl.steyr.model.Teams;
import htl.steyr.model.repository.AppointmentRepository;
import htl.steyr.model.repository.FieldRepository;
import htl.steyr.model.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/appiontment")
public class TimeEntryRestController {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    FieldRepository fieldRepository;

    @Autowired
    TeamsRepository teamsRepository;

    @GetMapping("/appiontment/open")
    public Appiontment[] openappiontments()  {

        return appointmentRepository.getOpenAppiontments("false");
    }

    @PostMapping("/create")
    boolean createSchoolClass(@RequestParam(value = "name", required = false) String name) {

            Teams sc = new Teams();
            sc.setName(name);
            teamsRepository.save(sc);
            return true;

    }

}


