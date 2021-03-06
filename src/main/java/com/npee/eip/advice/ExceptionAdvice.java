package com.npee.eip.advice;

import com.npee.eip.advice.exception.*;
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
        return responseService.getFailResult(Integer.parseInt(getMessage("unKnown.code")), getMessage("unKnown.message"));
        // return responseService.getFailResult();
    }

    @ExceptionHandler(CustomQuizNotExistsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult quizNotExistsException(HttpServletRequest request, CustomQuizNotExistsException e) {
        return responseService.getFailResult(Integer.parseInt(getMessage("quizNotExists.code")), getMessage("quizNotExists.message"));
    }

    @ExceptionHandler(CustomQuizTableEmptyException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult quizTableEmptyException(HttpServletRequest request, CustomQuizTableEmptyException e) {
        return responseService.getFailResult(Integer.parseInt(getMessage("quizTableEmpty.code")), getMessage("quizTableEmpty.message"));
    }

    @ExceptionHandler(CustomSubjectNotExistsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult subjectNotExistsException(HttpServletRequest request, CustomSubjectNotExistsException e) {
        return responseService.getFailResult(Integer.parseInt(getMessage("subjectNotExists.code")), getMessage("subjectNotExists.message"));
    }

    @ExceptionHandler(CustomItemNotExistsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult itemNotExistsException(HttpServletRequest request, CustomItemNotExistsException e) {
        return responseService.getFailResult(Integer.parseInt(getMessage("itemNotExists.code")), getMessage("itemNotExists.message"));
    }

    @ExceptionHandler(CustomItemTableEmptyException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult itemTableEmptyException(HttpServletRequest request, CustomItemTableEmptyException e) {
        return responseService.getFailResult(Integer.parseInt(getMessage("itemTableEmpty.code")), getMessage("itemTableEmpty.message"));
    }

    private String getMessage(String code) {
        return getMessage(code, null);
    }

    private String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
