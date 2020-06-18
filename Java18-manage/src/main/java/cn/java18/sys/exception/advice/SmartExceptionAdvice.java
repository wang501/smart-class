package cn.java18.sys.exception.advice;

import cn.java18.sys.exception.SmartGlobalException;
import cn.java18.utils.RestBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@ControllerAdvice
public class SmartExceptionAdvice {
    @ExceptionHandler(SmartGlobalException.class)
    @ResponseBody
    public Map<String,Object> SmartGlobalException(SmartGlobalException ex){
        Map<String, Object> mapPara = RestBean.getMapPara();
        mapPara.put(RestBean.MSG,ex.getMessage());
        return mapPara;
    }
}
