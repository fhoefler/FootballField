package htl.steyr.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "field")
public class Field {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "field", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Appiontment> appiontment;

    public Field() {
    }

    public Field(String name) {
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
