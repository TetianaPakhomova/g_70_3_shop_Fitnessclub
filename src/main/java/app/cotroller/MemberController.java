package app.cotroller;

import app.domain.Member;
import app.service.MemberService;

import java.util.List;

public class MemberController {

    private final MemberService service = MemberService.getInstance();

    public Member save(String name) {
        return service.save(name);
    }

    public Member getById(Long id) {
        return service.getById(id);
    }

    public List<Member> getAll() {
        return service.getAll();
    }

    public void delete(Long id) {
        service.delete(id);
    }

    public Member update(Long id, String newName) {
        return service.update(id, newName);
    }

    public Member deactivate(Long id) {
        return service.deactivate(id);
    }

    public Member activate(Long id) {
        return service.activate(id);
    }
}

