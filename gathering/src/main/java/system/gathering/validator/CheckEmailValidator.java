package system.gathering.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import system.gathering.object.User;
import system.gathering.repository.user.JdbcUserRepository;
import system.gathering.service.SignUp;

@RequiredArgsConstructor
@Component
public class CheckEmailValidator  extends AbstractValidator<User>{

    private final JdbcUserRepository jdbcUserRepository;
    private final SignUp signUp;

    @Override
    protected void doValidate(User user, Errors errors) {
        if(signUp.checkEmailDuplication(user.getEmail()) && user.getEmail() != ""){
            errors.rejectValue("email", "이메일 중복", "이메일 중복입니다");
        }
    }
}
