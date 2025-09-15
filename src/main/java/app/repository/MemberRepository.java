package app.repository;

import app.domain.Member;

import java.util.*;

public class MemberRepository {

    private final Map<Member, Member> database = new HashMap<Member, Member>();
    private long maxId = 0;

    public Optional<Member> save(Member member) {
        if (member.get() == null) member.get();
        Member Member = null;
        database.put(member.get(), Member);
        return Optional.of(member);
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





