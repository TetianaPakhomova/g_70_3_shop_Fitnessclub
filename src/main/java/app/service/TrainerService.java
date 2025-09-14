package app.service;


import app.domain.Trainer;
import app.exseption.TrainerNotFoundExseption;
import app.exseption.TrainerSaveExseption;
import app.repository.TrainerRepository;

import java.util.List;

public class TrainerService {

    final TrainerRepository repository = new TrainerRepository();
    private static TrainerService instance;

    public static TrainerService getInstance() {
        if (instance == null) instance = new TrainerService();
        return instance;
    }

    public Trainer save(Trainer trainer) {
        if (trainer == null || trainer.getName() == null || trainer.getName().isBlank()) {
            throw new TrainerSaveExseption("Имя тренера не может быть пустым");
        }
        return repository.save(trainer);
    }

    public Trainer save(String name) {
        return save(new Trainer(id, name));
    }

    public Trainer getById(Long id) {
        return (Trainer) repository.findById(id);
    }

    public List<Trainer> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Trainer getByName(String name) {
        return repository.findByName(name);


    }

    public Trainer update(Long id, String newName) {
        Trainer t = getById(id);
        t.setName(newName);
        return repository.save(t);
    }

    public Trainer deactivate(Long id) {
        Trainer t = getById(id);
        t.setActive(false);
        return repository.save(t);
    }

    public Trainer activate(Long id) {
        Trainer t = getById(id);
        t.setActive(true);
        return repository.save(t);
    }

    public Trainer getActiveTrainerById(Long id) {
        Trainer t = getById(id);
        if (!t.isActive()) {
            throw new TrainerNotFoundExseption("Trainer id=" + id + " не активен");
        }
        return t;
    }
}



