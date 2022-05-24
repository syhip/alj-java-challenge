package jp.co.axa.apidemo.exception;


import jp.co.axa.apidemo.common.Const;
import jp.co.axa.apidemo.entities.Result;
import jp.co.axa.apidemo.enums.ResultEnum;
import jp.co.axa.apidemo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;


/**
 * Handle Exception Class
 */
@ControllerAdvice
public class ExceptionHandle {

    private static  final Logger Logger= LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof UserException){
            UserException userException =(UserException)e;
            return   ResultUtil.error(userException.getCode(),userException.getMessage());
        }
        Logger.error("【System Error】{}",e);
        return   ResultUtil.error(ResultEnum.SYSTEM_ERROR);
    }
}
