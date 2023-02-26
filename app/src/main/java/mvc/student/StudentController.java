package mvc.student;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @Value("#{favoriteLanguages}")
    private Map<String, String> favoriteLanguages;

    @Value("#{operatingSystems}")
    private Map<String, String> operatingSystems;

    @RequestMapping("/show")
    public String show(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("countryOptions", countryOptions);
        model.addAttribute("favoriteLanguages", favoriteLanguages);
        model.addAttribute("operatingSystems", operatingSystems);

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        return "student-confirmation";
    }
}
