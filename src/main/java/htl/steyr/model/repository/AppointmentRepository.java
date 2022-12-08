package htl.steyr.model.repository;

import htl.steyr.model.Appiontment;
import htl.steyr.model.Field;
import htl.steyr.model.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppointmentRepository extends JpaRepository<Appiontment, Long> {


    @Query("SELECT t From Teams t where t.name = ?1")
    Teams getTeamById(String name);


    @Query("SELECT f From Field f where f.name = ?1")
    Field getFieldById(String name);


    @Query("SELECT a From Appiontment a where a.reserved = true")
    Appiontment[] getReservedAppiontments(String status);

    @Query("SELECT a From Appiontment a where a.reserved = false")
    Appiontment[] getOpenAppiontments(String status);
}
