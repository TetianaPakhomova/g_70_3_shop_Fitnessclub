package app.service;

import app.domain.Member;
import app.exseption.MemberNotFoundExseption;
import app.exseption.MemberSaveExseption;
import app.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository repository = new MemberRepository();
    private static MemberService instance;

    public static MemberService getInstance() {
        if (instance == null) instance = new MemberService();
        return instance;
    }

    public Optional<Member> save(Member member) {
        if (member == null || member.getName() == null || member.getName().isBlank()) {
            throw new MemberSaveExseption("Имя участника не может быть пустым");
        }
        return repository.save(member);
    }

    public Optional<Member> save(String name) {
        return save(new Member(name));
    }

    public Member getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundExseption("Member id=" + id + " не найден"));
    }

    public List<Member> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Member getByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new MemberNotFoundExseption("Member name=" + name + " не найден"));
    }

    public Optional<Member> update(Long id, String newName) {
        Member m = getById(id);
        m.setName(newName);
        return repository.save(m);
    }

    public Optional<Member> deactivate(Long id) {
        Member m = getById(id);
        m.setActive(false);
        return repository.save(m);
    }

    public Optional<Member> activate(Long id) {
        Member m = getById(id);
        m.setActive(true);
        return repository.save(m);
    }
}






