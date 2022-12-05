package htl.steyr.model.repository;

import htl.steyr.model.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeamsRepository extends JpaRepository<Teams, Long> {

    @Query("SELECT t From Teams t where t.name = ?1")
    Teams getTeamsById(String name);

    @Query("SELECT t.name From Teams t")
    Teams getNameofTeam();
}
