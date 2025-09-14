package app.cotroller;

import app.domain.Trainer;
import app.service.TrainerService;

import java.util.List;
import java.util.Optional;

public class TrainerController {

    private final TrainerService service = TrainerService.getInstance();

    public Optional<Trainer> save(String name) {
        return service.save(name);
    }

    public Optional<Trainer> save(Long id, String name) {
        return service.save(new Trainer(id, name));
    }

    public Optional<Trainer> getById(Long id) {
        return service.getById(id);
    }

    public List<Trainer> getAll() {
        return service.getAll();
    }

    public void delete(Long id) {
        service.delete(id);
    }

    public Optional<Trainer> update(Long id, String newName) {
        return service.update(id, newName);
    }

    public Optional<Trainer> deactivate(Long id) {
        return service.deactivate(id);
    }

    public Optional<Trainer> activate(Long id) {
        return service.activate(id);
    }
}





