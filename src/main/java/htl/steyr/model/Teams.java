package htl.steyr.model;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "teams")
public class Teams {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "teams", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Appiontment> appiontment;

    public Teams() {
    }

    public Teams(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Appiontment> getAppiontment() {
        return appiontment;
    }

    public void setAppiontment(Set<Appiontment> appiontment) {
        this.appiontment = appiontment;
    }
}
