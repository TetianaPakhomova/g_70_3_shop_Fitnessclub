package app.cotroller;

import app.domain.Member;
import app.service.MemberService;

import java.util.List;

public class MemberController {
    private final MemberService service = new MemberService();
    private Long id;

    // Сохранить пользователя в базе данных

    public Member save(String name) {
        Member member1 = new Member(name);
        Member member = null;
        return service.save(member);

    }
    // Вернуть всех пользователей

    public List<Member> getAll() {
        return service.getAllActiveMember();

    }

    // вернуть одного пользователя
    public Member getById(Long id) {
        return service.getActiveMemberById(id);

    }

    // изменить одного пользователя
    public void update(Long id, String newName) {
        service.update(id, newName);


    }

    //Удалить пользователя
    public void deleteById(Long id) {
        this.id = id;
        service.deleteById(id);
    }
    // удалить пользователя из базы данных по его имени

    public void deleteByName(String name) {
        service.deleteByName(name);
    }

    //восстановить удаленного пользователя
    public void restoreById(Long id) {
        service.restoreById(id);
    }


}