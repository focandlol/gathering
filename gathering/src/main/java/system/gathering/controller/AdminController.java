package system.gathering.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import system.gathering.SessionConst;
import system.gathering.object.*;
import system.gathering.repository.admin.AdminRp;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminController {

    private final AdminRp adminRp;

    @GetMapping("admin")
    public String admin(@ModelAttribute UserSearchCond userSearchCond,@PageableDefault(page = 0,size=3,sort = "userId",
            direction = Sort.Direction.DESC) Pageable pageable, @RequestParam(defaultValue = "") String userId,Model model,
                        @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) User loginUser){

        Role role = loginUser.getRole();
        if(!role.equals(Role.ADMIN)){
            return "redirect:/";
        }

        log.info("userSearchCond={}",userSearchCond);
        Page<User> users;

        if(userId.equals("")) {
            users = adminRp.searchUser(userSearchCond, pageable);
        } else{
            log.info("usc");
            userSearchCond.setUserId(userId);
            users = adminRp.searchUser(userSearchCond, pageable);
        }

        int nowPage = users.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 1, 1);
        if(users.getTotalPages() > 0) {
            int endPage = Math.min(nowPage + 9, users.getTotalPages());
            model.addAttribute("endPage",endPage);
        } else{
            int endPage = Math.min(nowPage + 9,users.getTotalPages());
            model.addAttribute("endPage",endPage+1);
        }

        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("users",users);
        model.addAttribute("userSearchCond",userSearchCond);

        return "admin";
    }

    @GetMapping("/admin/feedback")
    public String adminFeedback(@ModelAttribute FeedSearchCond feedSearchCond,@PageableDefault(page = 0,size=3,sort = "id",
            direction = Sort.Direction.DESC) Pageable pageable,@RequestParam(defaultValue = "") Checking name, Model model,
                                @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) User loginUser){

        Role role = loginUser.getRole();
        if(!role.equals(Role.ADMIN)){
            return "redirect:/";
        }
        log.info("feedSearchCond = {}",feedSearchCond);

        Page<Feedback> feedbacks = adminRp.searchFeedback(feedSearchCond, pageable);

        int nowPage = feedbacks.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 1, 1);
        if(feedbacks.getTotalPages() > 0) {
            int endPage = Math.min(nowPage + 9, feedbacks.getTotalPages());
            model.addAttribute("endPage",endPage);
        } else{
            int endPage = Math.min(nowPage + 9,feedbacks.getTotalPages());
            model.addAttribute("endPage",endPage+1);
        }
        Checking[] values = Checking.values();
        model.addAttribute("checks",values);
        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("feedbacks",feedbacks);
        model.addAttribute("FeedSearchCond",feedSearchCond);

        return "adminFeedback";
    }
    @PostMapping("/admin/feedback")
    @ResponseBody
    public void checkFeedback( @RequestParam(defaultValue = "none",name = "id") Long id,
                               @RequestParam(defaultValue = "none",name = "defendant") String defendant){
        log.info("id = {}",id);
        log.info("defendant={}",defendant);

        adminRp.checkFeedback(id);
        log.info("checkfeedback ok");
        adminRp.downGrade(defendant);
        log.info("all com");
    }

    @PostMapping("/admin")
    @ResponseBody
    public void userout( @RequestParam(defaultValue = "none",name = "userId") String userId){
        adminRp.userOut(userId);
    }

    @GetMapping("/admin/out")
    @ResponseBody
    public void out(@RequestParam(name = "userId") String userId){
        adminRp.userOut(userId);
    }
}
