package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("greatings")
public class HelloController {

    @GetMapping("hi")
     public String hi(){
         return "hello";
     }

}
