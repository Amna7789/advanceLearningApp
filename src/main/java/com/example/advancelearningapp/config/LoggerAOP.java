package com.example.advancelearningapp.config;

import com.example.advancelearningapp.services.common.IAuthService;
import com.example.advancelearningapp.services.common.impl.AuthServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@Aspect
@Component
public class LoggerAOP {
    @Autowired
    IAuthService authService;
    @Autowired
    AuthServiceImpl authServiceImpl;
    Logger logger = LoggerFactory.getLogger(LoggerAOP.class);

    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)||" +
            "@annotation(org.springframework.web.bind.annotation.PostMapping)||" +
            "@annotation(org.springframework.web.bind.annotation.PutMapping)||" +
            "@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public Object processLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Boolean validity = authService.isAdminUserData();
        if(validity == null)
            throw new IllegalArgumentException("");
        HttpServletRequest request1 =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        logger.info("That's the data for each user request");
        logger.info(request1.getHeader("Authorization").substring(6));
        String base64Auth = request1.getHeader("Authorization").substring(6);
        String credentials = new String(Base64.getDecoder().decode(base64Auth));
        String email = credentials.split(":")[0];
        String password = credentials.split(":")[1];
        logger.info("Email of admin is " +email);
        logger.info("Password of admin is " +password);
        logger.info("URL is "+request1.getRequestURI());
        Object object = proceedingJoinPoint.proceed();
        return object;

    }
}
