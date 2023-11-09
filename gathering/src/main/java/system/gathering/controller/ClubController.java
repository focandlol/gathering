package system.gathering.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import system.gathering.File.FileStore;
import system.gathering.File.UploadFile;
import system.gathering.SessionConst;
import system.gathering.object.Category;
import system.gathering.object.Chatting;
import system.gathering.object.User;
import system.gathering.object.club.*;
import system.gathering.repository.user.UserRepository;
import system.gathering.service.club.ClubService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ClubController {

    private final ClubService clubService;
    private final FileStore fileStore;
    private final UserRepository userRepository;

    @GetMapping("/club/add")
    public String addClubForm(@ModelAttribute AddClub club,@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) User loginUser, Model model){
       // List<Chatting> club39 = clubService.findChat("club39");

       // log.info("club39={}",club39);
        model.addAttribute("user",loginUser);
        Category[] values = Category.values();
        model.addAttribute("categories",values);
        return "clubAddForm";
    }

    @PostMapping("/club/add")
    public String addClub(@ModelAttribute AddClub addClub, HttpServletRequest request) throws IOException {

        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute(SessionConst.LOGIN_MEMBER);
        log.info("addclub.content={}",addClub.getIntro());
        Club club = new Club();
        club.setClubName(addClub.getClubName());
        club.setIntro(addClub.getIntro());
        club.setHost(user);
        club.setCategory(addClub.getCategory());

        try {
           MultipartFile uploadFile = addClub.getUploadFile();
            log.info("vvvvvvvvvv");
           UploadFile file = fileStore.storeFile(uploadFile);
            log.info("file = {}", file);
           club.setUploadFile(file.getUploadFileName());
           club.setStoreFile(file.getStoreFileName());
           clubService.save(club);

       } catch(NullPointerException e){
            log.info("fail");
            clubService.save(club);

       }
        ClubParticipant clubParticipant = new ClubParticipant();
        clubParticipant.setUser(user);
        clubParticipant.setClubId(club.getClubId());
        clubParticipant.setWhether("join");
        clubService.save(clubParticipant);

        clubService.create(club.getClubId().toString());

        return "redirect:/club";
    }

    @GetMapping("/club/delete/{clubId}")
    public String clubDelete(@PathVariable Long clubId){
        clubService.deleteClub(clubId);
        return "redirect:/club";
    }

    @GetMapping("/club")
    public String club(@ModelAttribute ClubSearchCond clubSearchCond,Model model,
                       @PageableDefault(page = 0,size=6,sort = "clubId",
            direction = Sort.Direction.DESC) Pageable pageable,
                       HttpServletRequest request,@RequestParam(defaultValue = "") String host,
                       @RequestParam(defaultValue = "") String clubName){

        log.info("get");
        //Page<Club> club = clubService.findAll(pageable);
        //model.addAttribute("club",club);

        Page<Club> club;
        ClubSearchCond clubCd = new ClubSearchCond();
        clubCd.setClubName(clubName);
        clubCd.setHost(host);

        if(host == "" && clubName == "") {
            log.info("nulllll");
           club = clubService.searchClubPage(clubCd, pageable);
        } else{
            club = clubService.searchClubPage(clubSearchCond, pageable);
        }

        int nowPage = club.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 1, 1);
        if(club.getTotalPages() > 0) {
            int endPage = Math.min(nowPage + 9, club.getTotalPages());
            model.addAttribute("endPage",endPage);
        } else{
            int endPage = Math.min(nowPage + 9,club.getTotalPages());
            model.addAttribute("endPage",endPage+1);
        }

        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute(SessionConst.LOGIN_MEMBER);
        model.addAttribute("user",user);
        model.addAttribute("searchHost",clubSearchCond.getHost());
        model.addAttribute("searchSubject",clubSearchCond.getClubName());
        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("club",club);

        return "club";

    }

    /*@PostMapping("/club")
    public String searchedclub(@ModelAttribute ClubSearchCond clubSearchCond,
                               @PageableDefault(page = 0,size=6,sort = "clubId",
                                       direction = Sort.Direction.DESC)Pageable pageable,
                               Model model){
        log.info("post");
        Page<Club> club = clubService.searchClubPage(clubSearchCond, pageable);
        model.addAttribute("club",club);

        int nowPage = club.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 1, 1);
        if(club.getTotalPages() > 0) {
            int endPage = Math.min(nowPage + 9, club.getTotalPages());
            model.addAttribute("endPage",endPage);
        } else{
            int endPage = Math.min(nowPage + 9,club.getTotalPages());
            model.addAttribute("endPage",endPage+1);
        }

        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage",startPage);

        log.info("clubname={}",clubSearchCond.getClubName());
        log.info("host={}",clubSearchCond.getHost());

        if(!StringUtils.hasText(clubSearchCond.getClubName())){
            return "redirect:/club";
        }


        return "club";
    }*/

    @GetMapping("/club/{clubId}")
    public String clubIn(@PathVariable Long clubId, Model model, HttpServletRequest request,
                         @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) User loginUser){

        Optional<Club> findClub = clubService.findById(clubId);
        Club club = findClub.get();
        List<ClubParticipant> participants = clubService.findJoinParticipant(clubId);

        model.addAttribute("parts",participants);
        model.addAttribute("club",club);
        model.addAttribute("userId",loginUser.getUserId());
        model.addAttribute("user",loginUser);


        return "clubIn";
    }

    @GetMapping("/club/out/{clubId}/{userId}")
    public String out(@PathVariable Long clubId, @PathVariable String userId){
        User user = userRepository.findById(userId);
        clubService.out(clubId, user);
        return "redirect:/club/"+clubId;
    }

    @GetMapping("/application/{clubId}")
    public String applicant(@PathVariable Long clubId,
                            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) User loginUser,
                            Model model){
        model.addAttribute("clubId",clubId);

        List<ClubParticipant> participant = clubService.findAll(clubId);
        Optional<Club> byId = clubService.findById(clubId);
        model.addAttribute("host",byId.get().getHost().getUserId());
        model.addAttribute("participants",participant);

        Optional<ClubParticipant> clubParticipant = clubService.find(clubId, loginUser.getUserId());
        //ClubParticipant cp = clubParticipant.get();
        log.info("ggggggggggggggggggggg");
        log.info("clubParticipant={}",clubParticipant);
        model.addAttribute("user",loginUser);
        if(clubParticipant.isEmpty()){

            model.addAttribute("join","unjoin");
        }
        else{
            model.addAttribute("join","join");
        }
        return "application";
    }

    @GetMapping("/participant/{clubId}")
    public String participant(@PathVariable Long clubId,
                              @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) User loginUser){

        ClubParticipant clubParticipant = new ClubParticipant();
        clubParticipant.setClubId(clubId);
        clubParticipant.setUser(loginUser);

        clubService.save(clubParticipant);
       return "redirect:/application/"+clubId;
    }

    @GetMapping("/clubInvite")
    public String asda(@RequestParam("userId") String userId, @RequestParam("clubId") Long clubId){

        clubService.updateWhether(clubId, userId);
        return "redirect:/application/"+clubId;
    }

    @GetMapping("/notice/add/{clubId}")
    public String noticeAddForm(@PathVariable Long clubId, @ModelAttribute Notice notice,@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) User loginUser,Model model){
        log.info("notice hi1 = {}",clubId);
        model.addAttribute("user",loginUser);
        return "noticeAddForm";
    }

    @PostMapping("/notice/add/{clubId}")
    public String noticeAdd(@PathVariable Long clubId,
                            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) User loginUser,
                            @ModelAttribute Notice notice){
        log.info("notice hi2 ={}",clubId);
        LocalDate date = LocalDate.now();
        Optional<Club> findclub = clubService.findById(clubId);
        Club club = findclub.get();
        //notice.setClubId(clubId);
        notice.setClub(club);
        notice.setHost(loginUser.getUserId());
        notice.setDate(date);
        clubService.save(notice);
        return "redirect:/notice/"+clubId;
    }

    @GetMapping("/notice/{clubId}")
    public String notice(@PathVariable Long clubId, @PageableDefault(page = 0,size=8,sort = "noticeId",
            direction = Sort.Direction.DESC) Pageable pageable,Model model,HttpServletRequest request,@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) User loginUser){
        log.info("qweqweqweqwe");
        Optional<Club> byId = clubService.findById(clubId);
        Club club = byId.get();
        //Page<Notice> notices = clubService.findByClubId(clubId, pageable);
        Page<Notice> notices = clubService.findByClubId(club, pageable);
        model.addAttribute("notices",notices);

        int nowPage = notices.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 2, 1);
        if(notices.getTotalPages() > 0) {
            int endPage = Math.min(nowPage + 2, notices.getTotalPages());
            model.addAttribute("endPage",endPage);
        } else{
            int endPage = Math.min(nowPage + 2,notices.getTotalPages());
            model.addAttribute("endPage",endPage+1);
        }
        model.addAttribute("user",loginUser);
        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("clubId",clubId);

        request.setAttribute("clubId", clubId);

        return "notice";
    }

    @GetMapping("/noticeIn/{noticeId}")
    public String noticeIn(@PathVariable Long noticeId, Model model,@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) User loginUser){
        log.info("qwe123qwe123qwe123");
        Optional<Notice> findNotice = clubService.findByNoticeId(noticeId);
        Notice notice = findNotice.get();
        model.addAttribute("user",loginUser);
        model.addAttribute("notice",notice);
        return "noticeIn";
    }

    @GetMapping("/club/update/{clubId}")
    public String clubUpdateForm(@PathVariable Long clubId, Model model, @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) User loginUser){
        Optional<Club> findClub = clubService.findById(clubId);
        Club club = findClub.get();
        model.addAttribute("user",loginUser);
        model.addAttribute("club",club);
        return "clubUpdateForm";
    }

    @PostMapping("/club/update/{clubId}")
    public String clubUpdate(@PathVariable Long clubId, @ModelAttribute UpdateClub updateClub) throws IOException {
        log.info("updateupdateupdaetdfsffdsfsfdfsdfsdsf");
        try {
            MultipartFile uploadFile = updateClub.getFile();
            UploadFile file = fileStore.storeFile(uploadFile);
            updateClub.setUploadFile(file.getUploadFileName());
            updateClub.setStoreFile(file.getStoreFileName());

            clubService.updateClub(clubId, updateClub);
        } catch(NullPointerException e){
            clubService.updateClub(clubId, updateClub);
        }

        return "redirect:/club/"+clubId;
    }

    @GetMapping("/club/album/{clubId}")
    public String clubAlbum(@PathVariable Long clubId, Model model,
                            @PageableDefault(page = 0,size=20,sort = "AlbumId",
                                    direction = Sort.Direction.DESC) Pageable pageable,
                            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) User loginUser) throws MalformedURLException {
        model.addAttribute("clubId",clubId);
        model.addAttribute("user",loginUser);
        Club club = clubService.findById(clubId).get();

        Slice<Album> albums = clubService.findAlbum(club, pageable, null);
        Long albumId = 0L;
        List<Resource> resources = new ArrayList<>();

        for (Album album1 : albums) {
            log.info("album={}",album1.getAlbumId());
             albumId = album1.getAlbumId();
        }
        log.info("lastAlbumId={}",albumId);
        model.addAttribute("lastAlbumId",albumId);
        model.addAttribute("albums",albums);
        return "clubAlbum";
    }

    @PostMapping("/club/album/{clubId}")
    @ResponseBody
    public List<Album> albumasdasd(@PathVariable Long clubId,@RequestParam(defaultValue = "", name = "num") Long lastNum,
                                @PageableDefault(size=20,sort = "AlbumId", direction = Sort.Direction.DESC) Pageable pageable) throws IOException {
        log.info("lastNum={}",lastNum);
        log.info("clubId={}",clubId);
        Club club = clubService.findById(clubId).get();
        Slice<Album> albums = clubService.findAlbum(club, pageable, lastNum);
       // List<File> resources = new ArrayList<>();
        Long lastAlbumId = 0L;
        List<String> url = new ArrayList<>();
        List<Album> albumList = new ArrayList<>();
        for(Album album : albums){
            log.info("album={}",album.getAlbumId());
            lastAlbumId = album.getAlbumId();
        }
        for (Album album1 : albums) {
            String urll = "/images/" + album1.getStoreFile() + "|"+lastAlbumId;
            album1.setStoreFile(urll);
            albumList.add(album1);

            url.add(urll);

        }
        //return url;
        return albumList;
    }

    @GetMapping("/club/album/add/{clubId}")
    public String albumAddForm(@ModelAttribute AlbumForm albumForm,@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) User loginUser, Model model){
        model.addAttribute("user",loginUser);
        return "albumAddForm";
    }

    @PostMapping("club/album/add/{clubId}")
    public String albumAdd(@PathVariable Long clubId,@ModelAttribute AlbumForm albumForm) throws IOException {
        List<UploadFile> uploadFiles = fileStore.storeFiles(albumForm.getImageFiles());

        for (UploadFile uploadFile : uploadFiles) {
            Album album = new Album();
            //album.setClubId(clubId);
            Optional<Club> byId = clubService.findById(clubId);
            Club club = byId.get();
            album.setClub(club);
            album.setUploadFile(uploadFile.getUploadFileName());
            album.setStoreFile(uploadFile.getStoreFileName());
            clubService.save(album);
        }

        return "redirect:/club/album/"+clubId;
    }

    @GetMapping("/club/search")
    public String clubSearchForm(@ModelAttribute ClubSearchCond clubSearchCond){
        return "clubSearchForm";
    }

    @PostMapping("/club/search")
    public String clubSearchFor(@ModelAttribute ClubSearchCond clubSearchCond, RedirectAttributes redirectAttributes){

        redirectAttributes.addAttribute("clubName",clubSearchCond.getClubName());
        redirectAttributes.addAttribute("host",clubSearchCond.getHost());
        return "redirect:/club";
    }

}
