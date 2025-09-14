package app.repository;

import app.domain.Member;

import java.util.*;

public class MemberRepository {

    private final Map<Long, Member> database = new HashMap<>();
    private long maxId = 0;

    public Member save(Member member) {
        if (member.getId() == null) member.setId(++maxId);
        database.put(member.getId(), member);
        return member;
    }

    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(database.get(id));
    }

    public List<Member> findAll() {
        return new ArrayList<>(database.values());
    }

    public void deleteById(Long id) {
        database.remove(id);
    }

    public Optional<Member> findByName(String name) {
        return database.values().stream()
                .filter(m -> Objects.equals(m.getName(), name))
                .findFirst();
    }
}





