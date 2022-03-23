package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // null일 경우를 위한 처리
        System.out.println("id : " +store.get(id));
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 자바 8 람다 표현식
        return store.values().stream() // store 루프를 돌면서
                .filter(member -> member.getName().equals(name)) // member 안에 있는 객체 name 과 매게변수 name 과 같은것이
                .findAny(); // 하나라도 있으면 return
    }

    @Override
    public List<Member> findAll() {
        // story안에 있는 member 객체 반환
        return new ArrayList<>(store.values());
    }
}
