package app.repository;

import app.domain.Trainer;

import java.util.*;

public class TrainerRepository {

    private final Map<Long, Trainer> database = new HashMap<>();
    private long maxId = 0;

    public Trainer save(Trainer trainer) {
        if (trainer.getId() == null) trainer.setId(++maxId);
        database.put(trainer.getId(), trainer);
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
