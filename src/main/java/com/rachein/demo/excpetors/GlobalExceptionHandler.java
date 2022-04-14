package com.rachein.demo.excpetors;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.rachein.demo.result.CodeMsg;
import com.rachein.demo.result.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;
import java.util.List;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/11 8:54
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultVo<String> exceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        log.error(e.toString());
        if (e instanceof GlobalException) {
            return ResultVo.error(((GlobalException) e).getCodeMsg());
        } else if (e instanceof BindException) {
            org.springframework.validation.BindException ex = (org.springframework.validation.BindException)e;
            List<ObjectError> errors = ex.getAllErrors();//绑定错误返回很多错误，是一个错误列表，只需要第一个错误
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return ResultVo.error(CodeMsg.BIND_ERROR.fillArgs(msg));//给状态码填充参数
        } else if (e instanceof NotLoginException) {
            return ResultVo.error(CodeMsg.LOGIN_CHECK);
        } else if (e instanceof NotPermissionException) {
            return ResultVo.error(CodeMsg.PERMISSION_ERROR);
        } else if (e instanceof NotRoleException) {
            return ResultVo.error(CodeMsg.ROLE_ERROR);
        }

        else {
            return ResultVo.error(CodeMsg.ERROR_SERVER);
        }


    }


}
