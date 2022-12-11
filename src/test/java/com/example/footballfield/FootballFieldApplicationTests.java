package com.example.footballfield;

import htl.steyr.model.Appiontment;
import htl.steyr.model.Field;
import htl.steyr.model.Teams;
import htl.steyr.model.repository.AppointmentRepository;
import htl.steyr.model.repository.FieldRepository;
import htl.steyr.model.repository.TeamsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration
class FootballFieldApplicationTests {


    @Test
    void loadTeams() throws Exception {
        Teams teams = new Teams("Aschach");

        Assertions.assertEquals("Aschach", teams.getName());
    }

    @Test
    void loadField() throws Exception {
        Field field = new Field("Aschach");

        Assertions.assertEquals("Aschach", field.getName());
    }


    @Test
    void loadAppiontment() throws Exception {
        Field field = new Field("Aschach");
        String date = "2022-12-05 14:33:04";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Appiontment appiontment = new Appiontment(formatter.parse(date), field);

        Assertions.assertEquals("Aschach", appiontment.getField().getName());
        Assertions.assertEquals(formatter.parse("2022-12-05 14:33:04"), appiontment.getDate());
    }

}
