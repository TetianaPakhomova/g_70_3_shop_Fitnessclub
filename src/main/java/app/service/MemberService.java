package app.service;

import app.domain.Member;
import app.exseption.MemberNotFoundExseption;
import app.exseption.MemberRestoreExseption;
import app.exseption.MemberSaveExseption;
import app.repository.MemberRepository;

import java.util.List;

public class MemberService {

    private final MemberRepository repository = new MemberRepository();
    private static MemberService instance;

    public static MemberService getInstance() {
        if (instance == null) instance = new MemberService();
        return instance;
    }

    public Member save(Member member) {
        if (member == null || member.getName() == null || member.getName().isBlank()) {
            throw new MemberSaveExseption("Имя участника не может быть пустым");
        }
        return repository.save(member);
    }

    public Member save(String name) {
        return save(new Member(name));
    }

    public Member getById(Long id) {
        return repository.findById(id);

    }

    public List<Member> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Member getByName(String name) {
        return repository.findByName(name);

    }

    public Member update(Long id, String newName) {
        Member m = getById(id);
        m.setName(newName);
        return repository.save(m);
    }

    public Member deactivate(Long id) {
        Member m = getById(id);
        m.setActive(false);
        return repository.save(m);
    }

    public Member activate(Long id) {
        Member m = getById(id);
        m.setActive(true);
        return repository.save(m);
    }
}





