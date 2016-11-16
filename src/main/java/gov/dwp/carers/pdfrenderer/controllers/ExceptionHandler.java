package gov.dwp.carers.pdfrenderer.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public String exception(Exception controllerException) throws Exception {
        LOGGER.error("Controller threw exception, error:" + controllerException.getMessage(), controllerException);
        throw controllerException;
    }
}
