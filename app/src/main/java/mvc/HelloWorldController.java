package mvc;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/show")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/process")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/process2")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        String studentName = request.getParameter("studentName");
        studentName = String.format("Yo! %s", studentName.toUpperCase());

        model.addAttribute("message", studentName);

        return "helloworld";
    }

    @RequestMapping("/process3")
    public String processForm3(
        @RequestParam("studentName") String studentName,
        Model model
    ) {
        studentName = String.format("Hey, yo! %s", studentName.toUpperCase());

        model.addAttribute("message", studentName);

        return "helloworld";
    }
}
