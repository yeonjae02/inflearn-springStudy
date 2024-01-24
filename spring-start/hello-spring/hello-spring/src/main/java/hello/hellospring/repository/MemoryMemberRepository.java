package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    // 동시성 문제 고려하지 않음.
    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L; // 키 값 생성

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        // null이더라도 감싸서 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // 하나 찾아 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
        // 실무에서는 리스트 많이 사용
    }

    public void clearStore(){
        store.clear();
    }
}
