package com.npee.eip.advice;

import com.npee.eip.advice.exception.CustomQuizNotExistsException;
import com.npee.eip.advice.exception.CustomQuizTableEmptyException;
import com.npee.eip.advice.exception.CustomSubjectNotExistsException;
import com.npee.eip.config.response.CommonResult;
import com.npee.eip.config.response.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestControllerAdvice(basePackages = "com.npee.eip")
public class ExceptionAdvice {

    private final ResponseService responseService;
    private final MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult defaultException(HttpServletRequest request, Exception e) {
        return responseService.getFailResult(Integer.valueOf(getMessage("unKnown.code")), getMessage("unKnown.message"));
        // return responseService.getFailResult();
    }

    @ExceptionHandler(CustomQuizNotExistsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult quizNotExistsException(HttpServletRequest request, CustomQuizNotExistsException e) {
        return responseService.getFailResult(Integer.valueOf(getMessage("quizNotExists.code")), getMessage("quizNotExists.message"));
    }

    @ExceptionHandler(CustomQuizTableEmptyException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult quizNotExistsException(HttpServletRequest request, CustomQuizTableEmptyException e) {
        return responseService.getFailResult(Integer.valueOf(getMessage("quizTableEmpty.code")), getMessage("quizTableEmpty.message"));
    }

    @ExceptionHandler(CustomSubjectNotExistsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult subjectNotExistsException(HttpServletRequest request, CustomSubjectNotExistsException e) {
        return responseService.getFailResult(Integer.valueOf(getMessage("subjectNotExists.code")), getMessage("subjectNotExists.message"));
    }

    private String getMessage(String code) {
        return getMessage(code, null);
    }

    private String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
