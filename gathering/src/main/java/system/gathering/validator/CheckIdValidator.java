package system.gathering.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import system.gathering.object.User;
import system.gathering.repository.user.JdbcUserRepository;
import system.gathering.service.SignUp;

@RequiredArgsConstructor
@Component
public class CheckIdValidator extends AbstractValidator<User>{

    private final JdbcUserRepository jdbcUserRepository;
    private final SignUp signUp;

    @Override
    protected void doValidate(User user, Errors errors) {
        if(signUp.checkIdDuplication(user.getUserId()) && user.getUserId() != ""){
            errors.rejectValue("userId", "아이디 중복", "아이디 중복입니다");
        }
    }
}
