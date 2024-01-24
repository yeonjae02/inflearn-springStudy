package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원 저장
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}


/*
* Optional
* 자바 8에 들어간 기능으로 뒤에서 추가 설명
* null을 반환할 때 감싸서 반환
* */