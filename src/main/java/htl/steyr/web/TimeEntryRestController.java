package htl.steyr.web;


import htl.steyr.model.Appiontment;
import htl.steyr.model.repository.AppointmentRepository;
import htl.steyr.model.repository.FieldRepository;
import htl.steyr.model.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TimeEntryRestController {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    FieldRepository fieldRepository;

    @Autowired
    TeamsRepository teamsRepository;

    @RequestMapping("/appiontment/open")
    void openappiontments()  {


        //return appointmentRepository.getOpenAppiontments("false");




    }
}
