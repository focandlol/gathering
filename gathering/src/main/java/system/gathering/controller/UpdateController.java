package system.gathering.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import system.gathering.File.FileStore;
import system.gathering.File.UploadFile;
import system.gathering.object.UpdateUser;
import system.gathering.object.User;
import system.gathering.service.Update;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UpdateController {
    private final Update update;
    private final FileStore fileStore;

    @GetMapping("/user/{userId}/edit")
    public String userUpdateForm(@PathVariable String userId, Model model){
        User findUser = update.find(userId);
        model.addAttribute("user",findUser);
        return "userUpdateForm";
    }

    @PostMapping("/user/{userId}/edit")
    public String userUpdate(@PathVariable String userId,@Validated @ModelAttribute("user") UpdateUser user, BindingResult bindingResult) throws IOException {

        if(bindingResult.hasErrors()){
            return "userUpdateForm";
        }
        User updateUser = update.find(userId);
        updateUser.setPassword(user.getPassword());
        updateUser.setName(user.getName());
        updateUser.setPostcode(user.getPostcode());
        updateUser.setAddress(user.getAddress());
        updateUser.setDetailAddress(user.getDetailAddress());
        updateUser.setExtraAddress(user.getExtraAddress());
        updateUser.setPhoneNumber(user.getPhoneNumber());

       /* UploadFile uploadFile = fileStore.storeFile(user.getUploadFile());
        updateUser.setUploadFile(uploadFile.getUploadFileName());
        updateUser.setStoreFile(uploadFile.getStoreFileName());*/

        try {
            MultipartFile uploadFile = user.getUploadFile();
            log.info("vvvvvvvvvv");
            UploadFile file = fileStore.storeFile(uploadFile);
            log.info("file = {}", file);
            updateUser.setUploadFile(file.getUploadFileName());
            updateUser.setStoreFile(file.getStoreFileName());
            update.userUpdate(updateUser,userId);

        } catch(NullPointerException e){
            log.info("fail");
            update.userUpdate(updateUser,userId);

        }
        log.info("hi11111111111111111111111111111111");
        return "redirect:/user/{userId}";

    }
}
