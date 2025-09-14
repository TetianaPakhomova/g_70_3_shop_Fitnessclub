package app.service;


import app.domain.Trainer;
import app.exseption.TrainerNotFoundExseption;
import app.exseption.TrainerSaveExseption;
import app.repository.TrainerRepository;

import java.util.List;
import java.util.Optional;

public class TrainerService {

    final TrainerRepository repository = new TrainerRepository();
    private static TrainerService instance;

    public static TrainerService getInstance() {
        if (instance == null) instance = new TrainerService();
        return instance;
    }

    public Optional<Trainer> save(Trainer trainer) {
        if (trainer == null || trainer.getName() == null || trainer.getName().isBlank()) {
            throw new TrainerSaveExseption("Имя тренера не может быть пустым");
        }
        return repository.save(Optional.of(trainer));
    }

    public Optional<Trainer> save(String name) {
        Long id = 0L;
        return save(new Trainer(id, name));
    }

    public Optional<Trainer> getById(Long id) {
        return repository.findById(id);
    }

    public List<Trainer> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<Trainer> getByName(String name) {
        return repository.findByName(name);


    }

    public Optional<Trainer> update(Long id, String newName) {
        Optional<Trainer> t = getById(id);
        t.stream();
        return repository.save(t);
    }

    public Optional<Trainer> deactivate(Long id) {
        Optional<Trainer> t = getById(id);
        t.getClass();
        return repository.save(t);
    }

    public Optional<Trainer> activate(Long id) {
        Optional<Trainer> t = getById(id);
        t.getClass();
        return repository.save(t);
    }

    public Optional<Trainer> getActiveTrainerById(boolean id) {
        if (Boolean.parseBoolean(getActiveTrainerById(id).toString())) {
            throw new TrainerNotFoundExseption("Trainer id не активен");
        }
        Optional<Trainer> t = Optional.empty();
        return t;
    }
}



