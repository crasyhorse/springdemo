package spring.fortune;

import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
    String[] fortuneList;

    @PostConstruct
    public void doMyStartupStuff() {
        ClassPathResource resource = new ClassPathResource("fortunes.txt");
        try {
            File file = resource.getFile();
            try (
                BufferedReader reader = new BufferedReader(new FileReader(file));
            ) {
                fortuneList = reader.lines()
                    .collect(Collectors.joining())
                    .split(",");

                System.out.println(Arrays.asList(fortuneList));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFortune() {
        Random rnd = new Random();

        return fortuneList[rnd.nextInt(fortuneList.length)];
    }
}
