package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    // 다른 리포지토리로 테스트되는 것이니 이렇게 하지 말고 MemberService에서 생성자를 만듦.
    //MemoryMemberRepository memberRepository = new MemoryMemberRepository();


    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);

    }

    @AfterEach
    public void afterEach() {
        // 테스트는 순서가 보장되지 않음. -> 순서 의존적으로 코드 작성하면 안 됨.
        // 테스트 한 번 실행 후 데이터를 clean하게 해야 함.
        // 테스트가 한 번 실행될 때마다 레포지토리를 지워줌.
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() { // 한글로 해도 됨.
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        // given
        Member member1 =new Member();
        member1.setName("spring");

        Member member2 =new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        /*
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다1.");
        }
        */

        // then

    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {
    }
}