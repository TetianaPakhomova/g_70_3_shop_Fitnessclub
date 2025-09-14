package app.domain;

import java.util.Objects;

public class Trainer {
    private Long id;
    private String name;
    private boolean active;

    public Trainer(Long id, String name) {
        this.name = name;
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trainer)) return false;
        Trainer trainer = (Trainer) o;
        return active == trainer.active &&
                Objects.equals(id, trainer.id) &&
                Objects.equals(name, trainer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, active);
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                '}';
    }

    public Trainer orElseThrow(Object object) {
        return null;
    }
}
