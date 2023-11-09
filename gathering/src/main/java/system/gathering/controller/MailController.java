package system.gathering.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import system.gathering.service.mail.MailService;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MailController {

    @Autowired
    MailService mailService;

    @GetMapping("/fuck")
    public String asdasd(){
        log.info("dfdfdfdfdfdd");
        return "sign-up-form";
    }

    @PostMapping("/fuck")
    @ResponseBody
    public void asdad(){
        log.info("asdfasdf");
    }
}
