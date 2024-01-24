package hello.hellospring.domain;

public class Member {

    private Long id; // 사용자가 만든 아이디가 아니라 시스템용
    private String name;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
