package your_package.domain.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Thingy {
    @Id
    private int id;

    @NotEmpty
    private String name;

    private Thingy() { /* for hibernate */ }

    public Thingy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
