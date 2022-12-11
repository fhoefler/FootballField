package htl.steyr.model.repository;

import htl.steyr.model.Field;
import htl.steyr.model.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FieldRepository extends JpaRepository<Field, Long> {

    @Query("SELECT f From Field f where f.name = ?1")
    Field findFieldByName(String name);

    @Query("SELECT f.name From Field f")
    String[] getNameofFields();
}
