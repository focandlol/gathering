package system.gathering.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import system.gathering.SessionConst;
import system.gathering.object.Chatting;
import system.gathering.object.Room;
import system.gathering.object.User;
import system.gathering.service.club.ClubService;
import system.gathering.service.ltForum.LtForumService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ChatController {

    List<Room> roomList = new ArrayList<Room>();
    private final ClubService clubService;
    private final LtForumService ltForumService;

    @GetMapping("/club/chat/{clubId}")
    public String chat(@PathVariable Long clubId, Model model, @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) User loginUser){
        log.info("open club");
        String a = "club"+clubId;
        List<Chatting> chat = clubService.findChat(a);

        model.addAttribute("userName",loginUser.getUserId());
        model.addAttribute("roomNumber",clubId);
        model.addAttribute("chatContent",chat);
        return "chat";
    }

    @GetMapping("/ltforum/chat/{forumId}")
    public String chatt(@PathVariable Long forumId, Model model, @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) User loginUser){
        log.info("open lt");
        String a = "ltforum"+forumId;
        List<Chatting> chat = clubService.findChat(a);
        model.addAttribute("userName",loginUser.getUserId());
        model.addAttribute("roomNumber",forumId);
        model.addAttribute("chatContent",chat);
        return "forumChat";
    }
}
