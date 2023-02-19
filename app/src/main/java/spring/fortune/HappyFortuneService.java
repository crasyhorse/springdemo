package spring.fortune;

public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "You are very happy.";
    }
}
