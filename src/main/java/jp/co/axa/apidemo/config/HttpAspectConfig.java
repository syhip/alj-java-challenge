package jp.co.axa.apidemo.config;

import jp.co.axa.apidemo.common.Const;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Log Info Print Class
 */
@Aspect
@Component
public class HttpAspectConfig {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspectConfig.class);



    @Pointcut(Const.LOG_POINTCUT_DIRECTORY)
    public void log() {
    }

    @Before(Const.LOG)
    public void before(JoinPoint joinPoint) {
        LOGGER.info(Const.START);
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        LOGGER.info(Const.URL, request.getRequestURL());
        LOGGER.info(Const.METHOD, request.getMethod());
        LOGGER.info(Const.IP, request.getRemoteAddr());
        LOGGER.info(Const.CLASS_METHOD, joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        LOGGER.info(Const.ARGS, joinPoint.getArgs());
    }

    @After(Const.LOG)
    public void after() {
        LOGGER.info(Const.END);
    }

    @AfterReturning(returning = Const.OBJECT, pointcut = Const.LOG)
    public void doAfterReturning(Object object) {
        LOGGER.info(Const.RESPONSE, object.toString());
    }
}

