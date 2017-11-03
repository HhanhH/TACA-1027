package com.taca.config.aspect;

import com.alibaba.fastjson.JSON;
import com.taca.common.bean.ResultBean;
import com.taca.common.constants.IMResp;
import com.taca.common.exception.IMException;
import com.taca.common.exception.IMRunTimeException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Aspect   //定义一个切面
@Configuration
@Order(-55)
public class ControllerAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);


    // 定义切点Pointcut
    @Pointcut("execution(java.lang.String com.taca.controller..*(..))")
    private void excudeServicePage() {
    }
    @Around("excudeServicePage()")
    public Object pageAspect(ProceedingJoinPoint pjp) throws Throwable {
        LOGGER.debug("controller页面跳转异常处理切面执行开始，时间{}",new Date());
        try {
            return pjp.proceed();
        } catch (Throwable e) {
            LOGGER.info("页面跳转出错",e);
            return "mobile/error/500.ftl";
        }

    }

    @Pointcut("execution(com.taca.common.bean.* com.taca.controller..*(..))")
    private void excudeService() {
    }

    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        LOGGER.debug("controller异常处理切面执行开始，时间{}",new Date());
        ResultBean<?> result;
        try {
            result = (ResultBean<?>) pjp.proceed();
            result.setCode(IMResp.SUCCESS.getCode());
            result.setMessage(IMResp.SUCCESS.getMessage());
        } catch (Throwable e) {
            result = handlerException(pjp, e);
        }
        LOGGER.debug("controller异常处理切面执行结束，时间{}",new Date());
        return result;
    }

    private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        ResultBean<?> result = new ResultBean();
        LOGGER.error(pjp.getSignature() + " error ", e);
        if(e instanceof IMException ){
            IMException imException=(IMException)e;
            result.setCode(imException.getCode());
            result.setMessage(imException.getMessage());
        }else if(e instanceof IMRunTimeException){
            IMRunTimeException imException=(IMRunTimeException)e;
            result.setCode(imException.getCode());
            result.setMessage(imException.getMessage());
        }
        else {
            result.setCode(IMResp.FAIL.getCode());
            result.setMessage(IMResp.FAIL.getMessage());

        }
        return result;
    }
}