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

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration
class FootballFieldApplicationTests {


    @Test
    void newTeams() {
        Teams teams = new Teams("Aschach");

        Assertions.assertEquals("Aschach", teams.getName());
    }

    @Test
    void loadTeams() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:4306/field";
        String user = "field";
        String password = "field";
        String name = "";
        try {
            con = DriverManager.getConnection(url, user, password);

            Statement statement = con.createStatement();
            ResultSet resultOrder = statement.executeQuery("SELECT * FROM teams t where t.id = 2");

            while (resultOrder.next()) {
                name = resultOrder.getString("name");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals("X", name);
    }

    @Test
    void newField() {
        Field field = new Field("Aschach");

        Assertions.assertEquals("Aschach", field.getName());
    }
    @Test
    void loadField() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:4306/field";
        String user = "field";
        String password = "field";
        String name = "";
        try {
            con = DriverManager.getConnection(url, user, password);

            Statement statement = con.createStatement();
            ResultSet resultOrder = statement.executeQuery("SELECT * FROM field f where f.id = 1");

            while (resultOrder.next()) {
                name = resultOrder.getString("name");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals("Aschach", name);
    }

    @Test
    void newAppiontment() throws Exception {
        Field field = new Field("Aschach");
        String date = "2022-12-05 14:33:04";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Appiontment appiontment = new Appiontment(formatter.parse(date), field);

        Assertions.assertEquals("Aschach", appiontment.getField().getName());
        Assertions.assertEquals(formatter.parse("2022-12-05 14:33:04"), appiontment.getDate());
    }

}
