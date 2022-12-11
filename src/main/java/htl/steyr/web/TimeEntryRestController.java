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

    @GetMapping("/create")
    boolean createSchoolClass(@RequestParam(value = "name") String name) {
        if (name.isEmpty() || name.isBlank()) {
            return false;
        } else {
            Teams sc = new Teams();
            sc.setName(name);
            teamsRepository.save(sc);
            return true;
        }
    }

    @GetMapping("/teams")
    public String[] teams()  {
        String[] teams = teamsRepository.getNameof();

        return teams;
    }

}


