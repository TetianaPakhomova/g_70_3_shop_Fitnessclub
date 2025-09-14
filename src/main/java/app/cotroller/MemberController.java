package app.cotroller;

import app.domain.Member;
import app.service.MemberService;

import java.util.List;
import java.util.Optional;

public class MemberController {

    private final MemberService service = MemberService.getInstance();

    public Optional<Member> save(String name) {
        return service.save(name);
    }

    public Optional<Member> getById(Long id) {
        return service.getById(id);
    }

    public List<Member> getAll() {
        return service.getAll();
    }

    public void delete(Long id) {
        service.delete(id);
    }

    public Optional<Member> update(Long id, String newName) {
        return service.update(id, newName);
    }

    public Optional<Member> deactivate(Long id) {
        return service.deactivate(id);
    }

    public Optional<Member> activate(Long id) {
        return service.activate(id);
    }
}


