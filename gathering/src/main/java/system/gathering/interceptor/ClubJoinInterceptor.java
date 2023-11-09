package system.gathering.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import system.gathering.SessionConst;
import system.gathering.object.Role;
import system.gathering.object.User;
import system.gathering.object.club.ClubParticipant;
import system.gathering.service.club.ClubService;

import java.util.Map;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class ClubJoinInterceptor implements HandlerInterceptor {

    private final ClubService clubService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute(SessionConst.LOGIN_MEMBER);
        long clubId = 0l;
        Map pathVariables = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        log.info("hi");

            String clubIdd = (String) pathVariables.get("clubId");
            clubId = Long.parseLong(clubIdd);

        //log.info("clubIddd={}",clubId);

       Optional<ClubParticipant> clubParticipant = clubService.find(clubId, user.getUserId());

        if(clubParticipant.isEmpty() || clubParticipant.get().getWhether().equals("unjoin")){
            log.info("미가입");
            //return "redirect:/club/"+clubId;
            if(user.getRole().equals(Role.ADMIN)){
                return true;
            }
            else {
                response.sendRedirect("/club/" + clubId);
            }
            //response.sendRedirect("/club/" + clubId);
        }
        return true;
    }

}
