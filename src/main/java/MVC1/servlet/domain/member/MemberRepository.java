package MVC1.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//지금 예제에서는 동시성 문제가 고려되어 있지 않다.
//실무에서는 ConcurrentHashMap, AtomicLong 등의 사용을 고려해 봐야 한다.
public class MemberRepository {
    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;

    //싱글톤으로 만들기.
    private static final MemberRepository instance = new MemberRepository();
    public static MemberRepository getInstance(){
        return instance;
    }
    private MemberRepository(){}

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll(){
        //왜 새로운 어레이리스트에 담아주냐?
        //반환되는 어레이에서 조작을 해도 기본값을 변경하고 싶지 않아서
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
