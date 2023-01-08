package com.iecas.admin.exception;

import com.iecas.common.result.R;
import com.iecas.common.result.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理类
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public R handler(SQLIntegrityConstraintViolationException e) {
        log.error("主键冲突异常，详细信息-" + e.getMessage());
        return R.setResult(ResultCodeEnum.DUPLICATE_KEY);
    }
}
