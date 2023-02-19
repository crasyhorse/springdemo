package spring.fortune;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

  @Override
  public String getFortune() {
    String[] fortuneList = new String[] {
      "It's your lucky day!",
      "Another happy day.",
      "The best day ever.",
    };
    Random rnd = new Random();

    return fortuneList[rnd.nextInt(2)];
  }
}
