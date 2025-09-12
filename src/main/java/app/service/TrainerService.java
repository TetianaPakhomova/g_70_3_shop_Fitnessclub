package app.service;



import app.domain.Trainer;
import app.exseption.TrainerNotFoundExseption;
import app.exseption.TrainerSaveExseption;
import app.repository.TrainerRepository;

import java.util.List;

public class TrainerService {

    private final TrainerRepository repository = new TrainerRepository();
    private static TrainerService instance;

    private TrainerService() {

    }

    public static TrainerService getInstance() {
        if (instance == null) {
            instance = new TrainerService();

        }
        return instance;
    }

    public Trainer save(Trainer trainer) {
        if (trainer == null) {
            throw new TrainerSaveExseption("Пользователь не может быть пустым");

        }
        String name = trainer.getName();
        if (name == null || name.trim().isEmpty()) {
            throw new TrainerSaveExseption("Имя не должно быть пустым");
        }
        trainer.setActive(true);
        ;
        return repository.save(trainer);

    }

    public List<Trainer> getAllActiveMember() {
        return repository.findAll()
                .stream()
                .filter(Trainer::isActive)
                .toList();


    }

    public Trainer getActiveMemberById(Long id) {
        Trainer trainer= (Trainer) repository.findById(id);

        if (trainer == null || !trainer.isActive()) {
            throw new TrainerNotFoundExseption(id);

        }
        return trainer;
    }

    public void deleteById(Long id) {
        Trainer trainer = getActiveMemberById(id);
        trainer.setActive(false);
    }

    public void deleteByName(String name) {
        getAllActiveMember()
                .stream()
                .filter(x -> x.getName().equals(name))
                .forEach(x -> x.setActive(false));

    }

    public void restoreById(Long id) {

        Trainer trainer = (Trainer) repository.findById(id);

        if (trainer == null) {
            throw new TrainerNotFoundExseption(id);

        }
        trainer.setActive((true));
    }


    public void restoreByName(String name) throws MemberRestorsExseption, TrainerRestoreExseption {
        Trainer trainer = null;
        if (trainer == null || name.trim().isEmpty()) {
            throw new TrainerRestoreExseption("Имя не может быть пустым");


        }
        Trainer trainer1 = repository.findByName(name);
        trainer1.setActive(true);
    }


}



