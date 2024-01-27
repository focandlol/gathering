package system.gathering.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import system.gathering.SessionConst;
import system.gathering.object.Category;
import system.gathering.object.LtForum;
import system.gathering.object.User;
import system.gathering.object.club.Club;
import system.gathering.repository.club.ClubRp;
import system.gathering.repository.forum.ForumRp;
import system.gathering.repository.user.UserRepository;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ForumRp forumRp;
    private final ClubRp clubRp;
    private final UserRepository userRepository;

    @GetMapping("/")
    public String home(
                       HttpServletRequest request, Model model) {
         HttpSession session = request.getSession(false);
        log.info("session = {}",session);
        if(session == null){
            model.addAttribute("user",null);
            return "index";
        }

        User loginUser = (User)session.getAttribute(SessionConst.LOGIN_MEMBER);

        List<Club> clubs = clubRp.indexClub();
        List<LtForum> ltForums = forumRp.indexLtForum();

        User findUser = userRepository.findById(loginUser.getUserId());


        Category[] values = Category.values();
        model.addAttribute("categories",values);
        model.addAttribute("ltForums",ltForums);
        model.addAttribute("clubs",clubs);
        model.addAttribute("user", findUser);
        log.info("user = {}",loginUser);
        return "index";
    }

    @GetMapping("/home")
    public String house(){
        return "redirect:/";
    }
}
