package system.gathering.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import system.gathering.File.FileStore;
import system.gathering.SessionConst;
import system.gathering.object.LtForum;
import system.gathering.object.LtParticipant;
import system.gathering.object.Maildto;
import system.gathering.object.User;
import system.gathering.object.club.Club;
import system.gathering.object.club.ClubParticipant;
import system.gathering.repository.user.JdbcUserRepository;
import system.gathering.service.SignUp;
import system.gathering.service.club.ClubService;
import system.gathering.service.ltForum.LtForumService;
import system.gathering.service.mail.MailService;
import system.gathering.validator.CheckEmailValidator;
import system.gathering.validator.CheckIdValidator;
import system.gathering.validator.CheckNickValidator;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final CheckIdValidator checkIdValidator;
    private final CheckNickValidator checkNickValidator;
    private final CheckEmailValidator checkEmailValidator;
    private final SignUp signUp;
    private final LtForumService ltForumService;
    private final ClubService clubService;
    private final FileStore fileStore;
    private final MailService mailService;



    @InitBinder
    public void valiatorBinder(WebDataBinder binder){
        binder.addValidators(checkIdValidator);
        binder.addValidators(checkNickValidator);
    }

    @GetMapping("/signUp")
    public String newUser(@ModelAttribute User user,@ModelAttribute Maildto maildto) {
        return "sign-up-form";
    }

    @PostMapping("/signUp")
    public String saveUser(@Validated @ModelAttribute User user, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes, Model model, @ModelAttribute Maildto maildto) {


        log.info("dsfsfsdfssf");
        log.info("maildto={}",maildto);

        /*try {
           User user1 = signUp.find(user.getUserId());
            log.info("sadsadsadsdad={}",user1);
        } catch(EmptyResultDataAccessException e){

                if (bindingResult.hasErrors()) {
                    log.info("bindingResult ={}", bindingResult);
                    return "sign-up-form";
                }

            if(user.getUserId() != "") {
                User saveUser = signUp.save(user);
                String userId = saveUser.getUserId();
                redirectAttributes.addAttribute("userId", userId);

                return "redirect:/user/{userId}";
            }
        }
        log.info("dsfsafsdf={}",signUp.find(user.getUserId()).getUserId());
        if(user.getUserId() != ""){
        bindingResult.rejectValue("userId", "duplicate", "아이디 중복");
        log.info("bindingresult={}",bindingResult);

            return "sign-up-form";
        }*/

        log.info("user = {}",user);
        if (bindingResult.hasErrors()) {
            log.info("bindingResult ={}", bindingResult);
            return "sign-up-form";
        }
        if(!maildto.getIschecked().equals("checked")){
            return "sign-up-form";
        }
        //user.setGrade(500);
        User saveUser = signUp.jpaSave(user);
        log.info("저장 완료!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String userId = saveUser.getUserId();
        //redirectAttributes.addAttribute("userId", userId);
        return "redirect:/login";

    }
    //@PostMapping(value = "/signUp", params="email")
    @PostMapping("/sign")
    @ResponseBody
    public String asdad(@RequestParam(name = "email") String email) throws Exception {
        log.info("asdfasdf");
        if(signUp.checkEmailDuplication(email)){
            return null;
        }
        String code = mailService.sendSimpleMessage(email);
        System.out.println("인증코드 : " + code);
        String s = email + "|" + code;
        return s;
    }

    @GetMapping("/user/{userId}")
    public String findUser(@PathVariable String userId, Model model, HttpServletRequest request){
        log.info("userid={}",userId);
        User user = signUp.find(userId);

        HttpSession session = request.getSession(false);

        User loginUser = (User)session.getAttribute(SessionConst.LOGIN_MEMBER);

        String name = "밀덕";
        model.addAttribute("mil",name);

        List<LtParticipant> participant = ltForumService.findAll(userId);
        List<ClubParticipant> joinUser = clubService.findJoinUser(user);
        log.info("joinuser={}",joinUser);
        model.addAttribute("chats",joinUser);
        if(participant != null){
            List<LtForum> forum = new ArrayList<>();
            for (LtParticipant ltParticipant : participant) {
                Long forumId = ltParticipant.getForumId();
                LtForum findForum = ltForumService.findById(forumId);
                forum.add(findForum);
            }
            log.info("forum={}",forum);
            model.addAttribute("forum",forum);
        }

        if(joinUser != null){
            List<Club> club = new ArrayList<>();
            for (ClubParticipant clubParticipant : joinUser) {
                Long clubId = clubParticipant.getClubId();
                Optional<Club> findClub = clubService.findById(clubId);
                club.add(findClub.get());
            }
            model.addAttribute("club",club);
        }

        if(user.getUserId().equals(loginUser.getUserId())) {
            String update = "good";
            model.addAttribute("update", update);
            model.addAttribute("user", user);

            return "user-view";
        }

        model.addAttribute("user",user);
        return "user-view";
    }

    @ResponseBody
    @GetMapping("/images/{filename}")
    public Resource imageDownload(@PathVariable String filename) throws MalformedURLException {
        UrlResource urlResource;
        log.info("filename____________________________________________________________={}",filename);
        if (filename.equals("null")) {
            urlResource = new UrlResource("file:" + fileStore.getFullPath("img_1.png"));
        } else {
            urlResource = new UrlResource("file:" + fileStore.getFullPath(filename));
            log.info("urlresource = {}",urlResource);
        }
            return urlResource;


    }


    @GetMapping("/aa/{userId}")
    public String abc(@PathVariable String userId){
        User user = signUp.find(userId);
        String storeFile = user.getStoreFile();
        return "redirect:/images/"+storeFile;
    }

    @GetMapping("/bb/{filename}")
    public String asd(@PathVariable String filename){
        return fileStore.getFullPath(filename);
    }
}

