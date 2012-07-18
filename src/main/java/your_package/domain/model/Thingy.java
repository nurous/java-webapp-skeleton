package your_package.domain.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Thingy {
    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty
    private String name;

    private Thingy() { /* for hibernate */ }

    public Thingy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
