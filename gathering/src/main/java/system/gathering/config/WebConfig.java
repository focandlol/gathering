package system.gathering.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import system.gathering.interceptor.ClubJoinInterceptor;
import system.gathering.interceptor.LoginInterceptor;
import system.gathering.service.club.ClubService;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final ClubService clubService;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/signUp","/logout","/login","/*.jpg","/images/*","/css/*","/css/**","/imgg/**","/sign/**","/script/**");


        registry.addInterceptor(new ClubJoinInterceptor(clubService))
                .order(2)
                .addPathPatterns("/notice/**","/club/album/**","/club/album/*","/club/chat/*");


    }
}
