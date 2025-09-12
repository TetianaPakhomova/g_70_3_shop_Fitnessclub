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

    MemberService() {

    }

    public static MemberService getInstance() {
        if (instance == null) {
            instance = new MemberService();

        }
        return instance;
    }

    public Member save(Member member) {
        if (member == null) {
            throw new MemberSaveExseption("Пользователь не может быть пустым");

        }
        String name = member.getName();
        if (name == null || name.trim().isEmpty()) {
            throw new MemberSaveExseption("Имя не должно быть пустым");
        }
        member.setActive(true);
        return repository.save(member);

    }

    public List<Member> getAllActiveMember() {
        return repository.findAll()
                .stream()
                .filter(Member::isActive)
                .toList();


    }

    public Member getActiveMemberById(Long id) {
        Member member = repository.findById(id);

        if (member == null || !member.isActive()) {
            throw new MemberNotFoundExseption(id);

        }
        return member;
    }

    public void deleteById(Long id) {
        Member member = getActiveMemberById(id);
        member.setActive(false);
    }

    public void deleteByName(String name) {
        getAllActiveMember()
                .stream()
                .filter(x -> x.getName().equals(name))
                .forEach(x -> x.setActive(false));

    }

    public void restoreById(Long id) {

        Member member = repository.findById(id);

        if (member == null) {
            throw new MemberNotFoundExseption(id);

        }
        member.setActive((true));
    }


    public void restoreByName(String name) throws MemberRestorsExseption {
        Member member = null;
        if (member == null || name.trim().isEmpty()) {
            throw new MemberRestoreExseption(" ");


        }
        Member member1 = repository.findByName(name);
        member.setActive(true);
    }


}





