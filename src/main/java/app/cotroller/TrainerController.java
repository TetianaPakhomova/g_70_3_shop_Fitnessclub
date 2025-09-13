package app.cotroller;

import app.domain.Trainer;
import app.service.TrainerService;

import java.util.List;

public class TrainerController {

    private final TrainerService service = TrainerService.getInstance();

    //Сохранить тренера в базе данных и автоматически он являеться активным
    public Trainer save(Long id, String name) {
        Trainer trainer = new Trainer(name, id);
        return service.save(trainer);

    }

    // Возвращаем всех тренеров из базы данных
    public List<Trainer> getAll() {
        return service.getActiveTrainers();

    }

    // Вернуть одного тренера по его идентификатору
    public Trainer getById(Long id) {
        return service.getActiveTrainerById();

    }

    //Изменить одного тренера по его идентификатору
    public void update(Long id, double newTrainer) {
        service.update(id, newTrainer);

    }

    public void deleteById(Long id) {
    }

    public void deleteByTitle(String name) {
    }

    public void restoreById(Long id) {
    }

    public String getTrainersName() {

        return " ";
    }

    public String getTrainersTotalCost() {
        return " ";
    }

    public String getTrainersAveragePrice() {
        return null;
    }
}


