package system.gathering.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import system.gathering.SessionConst;
import system.gathering.object.*;
import system.gathering.repository.user.UserRepository;
import system.gathering.service.EmptyCheck;
import system.gathering.service.ltForum.LtForumService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LtForumController {

    private final LtForumService ltForumService;
    private final UserRepository userRepository;

    @GetMapping("/ltforum")
    public String ltForumSearch2(@ModelAttribute LtForumSearchCond ltForumSearchCond,@PageableDefault(page = 0,size=4,sort = "num",
            direction = Sort.Direction.DESC) Pageable pageable,
                                 Model model,@RequestParam(defaultValue = "") String host,
                                 @RequestParam(defaultValue = "") String subject,@RequestParam(defaultValue = "") String content,
                                 @RequestParam(defaultValue = "ing") String state,
                                 HttpServletRequest request){

        Page<LtForum> list = ltForumService.searchLtForumPage(ltForumSearchCond, pageable);

        log.info("ltForumSearchCond={}",ltForumSearchCond);
        LtForumSearchCond lt = new LtForumSearchCond();
        lt.setContent(content);
        lt.setHost(host);
        lt.setSubject(subject);
        lt.setState(state);
        log.info("host={}",host);
        log.info("content={}",content);
        log.info("subject={}",subject);
        log.info("state={}",state);

        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute(SessionConst.LOGIN_MEMBER);
        model.addAttribute("user",user);
        int a = 0;
       /* if(host == "" && subject == "" && content =="" && state == "ing") {
            log.info("nulllll");
            list = ltForumService.searchLtForumPage(ltForumSearchCond, pageable);
        } else{
            list = ltForumService.searchLtForumPage(lt, pageable);
        }*/


        for (LtForum ltForum : list) {
            a=a+1;
            model.addAttribute("a",a);
        }

        int nowPage = list.getPageable().getPageNumber() + 1;


        int startPage = Math.max(nowPage - 1, 1);
        //log.info("startpage={}",startPage);
        if(list.getTotalPages() > 0) {
            int endPage = Math.min(nowPage + 9, list.getTotalPages());
            model.addAttribute("endPage",endPage);

        } else{
            int endPage = Math.min(nowPage + 9, list.getTotalPages());
            model.addAttribute("endPage",endPage+1);

        }
        Category[] values = Category.values();
        model.addAttribute("categories",values);
        model.addAttribute("searchHost",ltForumSearchCond.getHost());
        model.addAttribute("searchSubject",ltForumSearchCond.getSubject());
        model.addAttribute("searchContent",ltForumSearchCond.getContent());
        model.addAttribute("searchState",ltForumSearchCond.getState());
        model.addAttribute("lists",list);
        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("a",a);

        a=0;

        /*if(!StringUtils.hasText(ltForumSearchCond.getSubject()) && !StringUtils.hasText(ltForumSearchCond.getHost())&&
                !StringUtils.hasText(ltForumSearchCond.getContent())){
            log.info("nullnull");
            return "redirect:/ltforum";
        }*/
        model.addAttribute("search","search");
        return "ltForum";
    }


    @GetMapping("/ltforum/{forumId}")
    public String ltForumIn(@PathVariable Long forumId, @ModelAttribute Comment comment, @ModelAttribute Feedback feedback,Model model,
                            HttpServletRequest request){

        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute(SessionConst.LOGIN_MEMBER);
        model.addAttribute("user",user);
        //String userId = user.getUserId();
       // model.addAttribute("userId",userId);

        LtForum findForum;
        try{
            findForum = ltForumService.findById(forumId);
        }catch(Exception e){
            return "index";
        }
        model.addAttribute("forum",findForum);
        
        List<Comment> comments = ltForumService.commentFindById(forumId);
        for (Comment comment1 : comments) {
            User host = comment1.getHost();
            Optional<LtParticipant> ltParticipant = ltForumService.findLtParticipant(forumId, host.getUserId());
            if(!ltParticipant.isEmpty()){
                ltForumService.updateComments(forumId, host.getUserId());
            }
        }
        List<Comment> commentss = ltForumService.commentFindById(forumId);
        model.addAttribute("comments",commentss);

        Optional<Comment> findComment = ltForumService.findComment(forumId, user.getUserId());
        Optional<LtParticipant> ltParticipant = ltForumService.findLtParticipant(forumId, user.getUserId());
        //List<LtParticipant> part = ltForumService.findPart(forumId);

        //model.addAttribute("parts",part);

        log.info("findComment={}",findComment);

        List<LtParticipant> allParticipant = ltForumService.findAllParticipant(forumId);
        log.info("allparti={}",allParticipant);
        model.addAttribute("participant",allParticipant);

        int length = Feed.values().length;
        Feed[] values = Feed.values();
        Feed value = values[0];
        log.info("feeeed={}",values);
        model.addAttribute("feeds",values);


        if(findComment.isEmpty() && ltParticipant.isEmpty()){
            model.addAttribute("havaComment","no");
            log.info("abcdefg");
        } else{
            model.addAttribute("haveComment","yes");
        }
        return "ltForumIn";
    }

    @PostMapping("/ltforum/{forumId}")
    public String addComment(@PathVariable Long forumId,@ModelAttribute Comment comment,HttpServletRequest request,
                             Model model){
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute(SessionConst.LOGIN_MEMBER);
        log.info("comment={}",comment);
        comment.setHost(user);
        comment.setForumId(forumId);
        log.info("comment={}",comment);
        ltForumService.commentSave(comment);


        return "redirect:/ltforum/{forumId}";
    }

    /*@GetMapping("/ltforum/part/{userId}")
    public String part(@PathVariable String userId){

    }*/
    @GetMapping("/ltforum/out/{forumId}/{userId}")
    public String out(@PathVariable Long forumId, @PathVariable String userId){
        User user = userRepository.findById(userId);
        ltForumService.out(forumId, user);
        return "redirect:/ltforum/"+forumId;
    }


    @GetMapping("/add")
    public String addForm(@ModelAttribute LtForum forum,Model model,@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) User loginUser){

        Category[] values = Category.values();
        model.addAttribute("categories",values);
        model.addAttribute("user",loginUser);
        return "ltForumAddForm";
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute LtForum forum, BindingResult bindingResult, HttpServletRequest request){
        if(bindingResult.hasErrors()){
            log.info("bindingResult ={}", bindingResult);
            return "ltForumAddForm";
        }
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute(SessionConst.LOGIN_MEMBER);
        forum.setHost(user);
        LocalDate date = LocalDate.now();
        forum.setDate(date);
        LtForum save = ltForumService.save(forum);

        LtParticipant participant = new LtParticipant();
        participant.setForumId(save.getForumId());
        participant.setUser(user);

        ltForumService.create(save.getForumId().toString());

        ltForumService.participantSave(participant);
        return "redirect:/ltforum";
    }

    @GetMapping("/invite/{commentId}")
    public String invite(@PathVariable Long commentId, RedirectAttributes redirectAttributes){
        Comment comment = ltForumService.findByCommentId(commentId);
        Long forumId = comment.getForumId();
        LtParticipant participant = new LtParticipant();
        participant.setForumId(comment.getForumId());
        participant.setUser(comment.getHost());
        

        ltForumService.participantSave(participant);
        ltForumService.deleteComment(commentId);

        //redirectAttributes.addAttribute();
        return "redirect:/ltforum/"+forumId;
    }

    @GetMapping("/delete/{commentId}")
    public String deleteComment(@PathVariable Long commentId){
        Comment comment = ltForumService.findByCommentId(commentId);
        Long forumId = comment.getForumId();
        ltForumService.deleteComment(comment.getCommentId());

        return "redirect:/ltforum/"+forumId;
    }

    @GetMapping("/deleteForum/{forumId}")
    public String deleteForum(@PathVariable Long forumId){
        ltForumService.deleteForum(forumId);
        return "redirect:/ltforum";
    }

    @GetMapping("/ltforum/edit/{forumId}")
    public String updateForm(@PathVariable Long forumId,Model model,@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) User loginUser,
                             @ModelAttribute UpdateLtForum updateLtForum){
        LtForum findForum = ltForumService.findById(forumId);
        Category[] values = Category.values();
        model.addAttribute("categories",values);
        model.addAttribute("ltForum",findForum);
        model.addAttribute("user",loginUser);
        return "ltForumUpdateForm";
    }

    @PostMapping("/ltforum/edit/{forumId}")
    public String ltForumUpdate(@PathVariable Long forumId,@ModelAttribute UpdateLtForum updateLtForum){
        log.info("forumId={}",forumId);
        log.info("updateLtForum={}",updateLtForum);
        ltForumService.updateLtForum(forumId, updateLtForum);
        return "redirect:/ltforum/"+forumId;
    }

    @GetMapping("/ltforum/start/{forumId}")
    public String startForum(@PathVariable Long forumId){
        ltForumService.updateToStart(forumId);
        return "redirect:/ltforum/"+forumId;
    }

    @GetMapping("/ltforum/end/{forumId}")
    public String endForum(@PathVariable Long forumId){
        ltForumService.updateToEnd(forumId);
        return "redirect:/ltforum/"+forumId;
    }

    @PostMapping("ltforum/feedback/{forumId}")
    public String feedback(@PathVariable Long forumId, @ModelAttribute Feedback feed,@RequestParam(name = "defend", defaultValue = "") String defend,@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) User loginUser){
        log.info("defendant={}",defend);
        User findUser = userRepository.findById(defend);
        feed.setDefendant(findUser);
        feed.setForumId(forumId);
        feed.setUser(loginUser);
        log.info("feed={}",feed);
        ltForumService.feedBack(feed);

        return "redirect:/ltforum";
    }

}
