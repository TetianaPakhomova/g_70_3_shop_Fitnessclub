package app.cotroller;

import app.domain.Trainer;
import app.service.TrainerService;

import java.util.List;

public class TrainerController {

    private final TrainerService service = TrainerService.getInstance();

    public Trainer save(String name) {
        return service.save(name);
    }

    public Trainer save(Long id, String name) {
        return service.save(new Trainer(id, name));
    }

    public Trainer getById(Long id) {
        return service.getById(id);
    }

    public List<Trainer> getAll() {
        return service.getAll();
    }

    public void delete(Long id) {
        service.delete(id);
    }

    public Trainer update(Long id, String newName) {
        return service.update(id, newName);
    }

    public Trainer deactivate(Long id) {
        return service.deactivate(id);
    }

    public Trainer activate(Long id) {
        return service.activate(id);
    }
}





