package test.outside;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class OutsideController {
    @GetMapping("outside")
    public String outsideTest(){
        return "outside test";
    }
}
