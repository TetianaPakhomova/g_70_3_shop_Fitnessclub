package app.service;

import app.domain.Member;
import app.exseption.MemberNotFoundExseption;
import app.exseption.MemberRestoreExseption;
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
        return repository.save(Optional.of(member));
    }



    public Member getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new MemberNotFoundExseption(id));


    }

    public List<Member> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<Member> getByName(String name) {
        return repository.findByName(name);

    }

    public Optional<Member> update(Long id, String newName) {
        Optional<Member> m = Optional.ofNullable(getById(id));
        m.stream();
        return repository.save(m);
    }

    public Optional<Member> deactivate(Long id) {
        Optional<Member> m = Optional.ofNullable(getById(id));
        m.getClass();
        return repository.save(m);
    }

    public Optional<Member> activate(Long id) {
        Optional<Member> m = Optional.ofNullable(getById(id));
        m.getClass();
        return repository.save(m);
    }
}






