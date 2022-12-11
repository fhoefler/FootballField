package com.example.footballfield;

import htl.steyr.model.Appiontment;
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
import java.sql.DriverManager;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration
class FootballFieldApplicationTests {




    @Test
    void loadTeams() throws Exception {
            Teams teams = new Teams("Aschach");

            Assertions.assertEquals("Aschach", teams.getName());
        }

}
