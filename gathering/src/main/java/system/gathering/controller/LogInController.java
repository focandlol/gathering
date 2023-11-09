package system.gathering.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import system.gathering.SessionConst;

import system.gathering.config.SessionConfig;
import system.gathering.object.LoginUser;
import system.gathering.object.User;
import system.gathering.service.LogIn;

import java.lang.reflect.Member;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RequiredArgsConstructor
@Controller
public class LogInController {
    private final LogIn login;

    @GetMapping("/login")
    public String logInForm(@ModelAttribute LoginUser user){
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginUser user, BindingResult
            bindingResult, @RequestParam(defaultValue = "/") String redirectURL, HttpServletRequest request,
                        RedirectAttributes redirectAttributes) {
        User loginUser;
        String id = request.getParameter("userId");

       log.info("id = {}",id);
        if (bindingResult.hasErrors()) {
            return "loginForm";
        }

        try {
            loginUser = login.logIn(user.getUserId(), user.getPassword());
        } catch(EmptyResultDataAccessException e){
            loginUser = null;
        }

        //log.info("login? {}", loginMember);
        if (loginUser == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "loginForm";
        }
        //로그인 성공 처리
        //세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
        SessionConfig.getSessionidCheck(SessionConst.LOGIN_MEMBER, id);
            HttpSession session = request.getSession();
            //세션에 로그인 회원 정보 보관
            session.setAttribute(SessionConst.LOGIN_MEMBER, loginUser);

       if(redirectURL.equals("/")){
            return "redirect:/home";
        }
        return "redirect:" + redirectURL ;
        //return "redirect:/user/" + user.getUserId();
    }

    @GetMapping("/logout")
    public String logout2(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        return "redirect:/";
    }
    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        return "redirect:/";
    }
}
