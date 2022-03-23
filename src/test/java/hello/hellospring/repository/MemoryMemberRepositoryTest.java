package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemberRepository repo = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("String");

        repo.save(member);
        System.out.println(member.getId());
        Member result = repo.findById(member.getId()).get();

        // assertThat = 콘솔화면에 출력하지 않고 빠르게 결과를 알고싶을때 사용 하는 함수
        // member가 result와 같은지 확인할 때 사용 함수
        assertThat(member).isEqualTo(result);
        // assertThat(member).isEqualTo(null);

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("kimboram1");
        repo.save(member1);

        Member member2 = new Member();
        member2.setName("kimboram2");
        repo.save(member2);

        Member result = repo.findByName("kimboram1").get();
        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("boram1");
        repo.save(member1);

        Member member2 = new Member();
        member2.setName("boram2");
        repo.save(member2);

        ArrayList<Member> result = (ArrayList<Member>) repo.findAll();
        System.out.println(result);
//        assertThat(re)


    }

}
