package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 切面
 * 此处知识点:
 *  <code>@Aspect,@Pointcut,@Before,@After,@AfterReturning</code>
 * Created by Jthan on 17/8/19.
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    //最后两个点的意思是说此方法中的参数个数是多少都会被拦截
    //@Pointcut("execution(public * com.example.controller.GirlController.girlList(..))")
    //*的意思是指所有方法
    @Pointcut("execution(public * com.example.controller.GirlController.*(..))")
    public void pointcutForAll() {
        //这个方法里貌似就是空的,啥都没有
    }

    //定义切点就可以不用在@Before或@After中写重复的execution........
    @Before("pointcutForAll()")
    public void doBefore() {
        LOGGER.info("login aspect before------");
    }

    @After("pointcutForAll()")
    public void doAfter() {
        LOGGER.info("login aspect after------");
    }

    @Before("pointcutForAll()")
    public void loginBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        //url
        LOGGER.info("url={}", request.getRequestURL());

        //method
        LOGGER.info("method={}", request.getMethod());

        //ip
        LOGGER.info("method={}", request.getRemoteAddr());

        //class method
        Signature signature = joinPoint.getSignature();
        LOGGER.info("class method={}", signature.getDeclaringTypeName() + "." + signature.getName());

        //args
        LOGGER.info("args={}", joinPoint.getArgs());
    }

    //object为方法返回的结果
    @AfterReturning(pointcut = "pointcutForAll()", returning = "object")
    public void doAfterReturn(Object object) {
        LOGGER.info("return={}", object.toString());
    }
}
