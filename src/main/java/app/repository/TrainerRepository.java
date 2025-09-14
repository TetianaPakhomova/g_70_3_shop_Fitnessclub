package app.repository;

import app.domain.Trainer;

import java.util.*;

public class TrainerRepository {

    private final Map<Trainer, Trainer> database = new HashMap<Trainer, Trainer>();
    private long maxId = 0;

    public Optional<Trainer> save(Optional<Trainer> trainer) {
        if (trainer.get() == null) trainer.get();
        Trainer t = null;
        database.put(trainer.get(), t);
        return trainer;
    }

    public Optional<Trainer> findById(Long id) {
        return Optional.ofNullable(database.get(id));
    }

    public Optional<Trainer> findByName(String name) {
        return database.values().stream()
                .filter(t -> Objects.equals(t.getName(), name))
                .findFirst();
    }

    public List<Trainer> findAll() {
        return new ArrayList<>(database.values());
    }

    public void deleteById(Long id) {
        database.remove(id);
    }
}
