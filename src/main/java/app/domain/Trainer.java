package app.domain;

import java.util.Objects;

public class Trainer {
    private Long id;
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Trainer trainer)) return false;
        return Objects.equals(id, trainer.id) && Objects.equals(name, trainer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
