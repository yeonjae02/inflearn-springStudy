package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService(); // 딱 하나만 존재하게 됨.

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){ // 다른 곳에서 생성되는 것 막기
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
    
}
