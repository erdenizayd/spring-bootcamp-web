package yte.intern.springweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CoursesController {
    @RequestMapping("/courses/{coursesNumber}")
    public void testFunction(@PathVariable Long coursesNumber,
                             @RequestParam String name,
                             @RequestParam String instructor) {
        System.out.println(coursesNumber + " " + name + " " + instructor);
    }
}
