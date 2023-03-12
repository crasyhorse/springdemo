package jacksonDemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            Student student = mapper.readValue(
                new File("data/sample-full.json"),
                Student.class
            );

            System.out.println(
                String.format("First name: %s", student.getFirstName())
            );
            System.out.println(
                String.format("Last name: %s", student.getLastName())
            );

            Address address = student.getAddress();

            System.out.println(
                String.format("Street: %s", address.getStreet())
            );
            System.out.println(String.format("City: %s", address.getCity()));
            System.out.println(String.format("ZIP: %s", address.getZip()));
            System.out.println(String.format("State: %s", address.getState()));
            System.out.println(
                String.format("Country: %s", address.getCountry())
            );

            Arrays.stream(student.getLanguages()).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
