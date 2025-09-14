package app.repository;

import app.domain.Trainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainerRepository {

    private final Map<Long, Trainer> database = new HashMap<>();
    private long maxId;

    public Trainer save(Trainer trainer) {
        trainer.setId(++maxId);
        database.put(maxId, trainer);
        return trainer;


    }
    public List<Trainer> findAll(){
        return new ArrayList<>(database.values());
    }
    public void deleteById(Long id) {
        database.remove(id);

    }

    public Object findById(Long id) {
        return null;
    }

    public Trainer findByName(String name) {
        return null;
    }
}
