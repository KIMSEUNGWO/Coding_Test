package 해시코드재정의;

public class Member {

    private final long id;
    private final String name;

    public Member(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member member) {
            return this.id == member.id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}
