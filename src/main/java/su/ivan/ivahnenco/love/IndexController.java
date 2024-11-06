package su.ivan.ivahnenco.love;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class IndexController {
    private static String RIGHTANSWER = "вечер";

    @GetMapping("/")
    public String indexGet(Model model) {
        model.addAttribute("form", new Form());
        model.addAttribute("condition", new Condition(false));  
        return "index";
    }

    @PostMapping("/")
    public String indexPost(@ModelAttribute Form form, Model model) {
        if (form.getAnswer().compareToIgnoreCase(RIGHTANSWER) == 0)  {
            return "answer";
        }
        model.addAttribute("form", new Form());
        model.addAttribute("condition", new Condition(true));
        return "index";
    }
    
    
}
