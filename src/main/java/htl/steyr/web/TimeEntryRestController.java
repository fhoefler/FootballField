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

    @GetMapping("/appiontment/free")
    public String[] freeappiontments()  {
        Appiontment[] appiontments = appointmentRepository.getFreeAppiontments("false");
        String[] appiontment = new String[appiontments.length];
        for(int i = 0; appiontments.length > i; ++i) {
            appiontment[i] = appiontments[i].getField().getName() + "-" + appiontments[i].getDate();
        }

        return appiontment;
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

    @GetMapping("/fields")
    public String[] fiels()  {
        String[] fields = fieldRepository.getNameofFields();

        return fields;
    }

}


