package htl.steyr.web;


import htl.steyr.model.Appiontment;
import htl.steyr.model.Field;
import htl.steyr.model.Teams;
import htl.steyr.model.repository.AppointmentRepository;
import htl.steyr.model.repository.FieldRepository;
import htl.steyr.model.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;


@RestController
public class TimeEntryRestController {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    FieldRepository fieldRepository;

    @Autowired
    TeamsRepository teamsRepository;

    @GetMapping("/appiontment/free")
    public String[] freeappiontments() {
        Appiontment[] appiontments = appointmentRepository.getFreeAppiontments("false");
        String[] appiontment = new String[appiontments.length];
        for (int i = 0; appiontments.length > i; ++i) {
            appiontment[i] = appiontments[i].getField().getName() + "-" + appiontments[i].getDate();
        }

        return appiontment;
    }

    @GetMapping("/appiontment")
    public String[] appiontments() {
        Appiontment[] appiontments = appointmentRepository.getAppiontments();
        String[] appiontment = new String[appiontments.length];
        for (int i = 0; appiontments.length > i; ++i) {
            if (appiontments[i].isReserved()) {
                appiontment[i] = appiontments[i].getField().getName() + "-" + appiontments[i].getDate() + " reserviert";
            } else {
                appiontment[i] = appiontments[i].getField().getName() + "-" + appiontments[i].getDate() + " nicht reserviert";
            }
        }

        return appiontment;
    }

    @GetMapping("/appiontment/reserved")
    public String[] reservedappiontments() {
        Appiontment[] appiontments = appointmentRepository.getReservedAppiontments("true");
        String[] appiontment = new String[appiontments.length];
        for (int i = 0; appiontments.length > i; ++i) {
            appiontment[i] = appiontments[i].getField().getName() + "-" + appiontments[i].getDate();
        }

        return appiontment;
    }

    @PostMapping("/createTeam")
    boolean createTeam(@RequestParam String name) {
        if (name.isEmpty() || name.isBlank()) {
            return false;
        } else {
            Teams teams = new Teams();
            teams.setName(name);
            teamsRepository.save(teams);
            return true;
        }
    }

    @GetMapping("/teams")
    public String[] teams() {
        String[] teams = teamsRepository.getNameof();

        return teams;
    }

    @GetMapping("/fields")
    public String[] fiels() {
        String[] fields = fieldRepository.getNameofFields();

        return fields;
    }

    @PostMapping("/createField")
    boolean createField(@RequestParam String name) {
        if (name.isEmpty() || name.isBlank()) {
            return false;
        } else {
            Field field = new Field();
            field.setName(name);
            fieldRepository.save(field);
            return true;
        }
    }

    @PostMapping("/createAppiontment")
    boolean createAppiontment(@RequestParam String fieldname, @RequestParam String date) {

        Appiontment appiontment = new Appiontment();
        Field field;
        field = appointmentRepository.getFieldByName(fieldname);
        appiontment.setField(field);
        appiontment.setDate(Date.valueOf(date));
        appointmentRepository.save(appiontment);
        return true;

    }
}


