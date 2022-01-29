package com.cccmbiz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public CustomErrorController() {
    }

    @GetMapping(value = "/error")
    public String handleError(HttpServletRequest request) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        String errorMsg = "";
        int httpErrorCode = (Integer) status;

        switch (httpErrorCode) {
            case 400: {
                errorMsg = "Http Error Code: 400. Bad Request";
                break;
            }
            case 401: {
                errorMsg = "Http Error Code: 401. Unauthorized";
                break;
            }
            case 404: {
                errorMsg = "Http Error Code: 404. Resource not found";
                break;
            }
            case 500: {
                errorMsg = "Http Error Code: 500. Internal Server Error";
                break;
            }
        }

        logger.error("Error: " + status.toString());

        FacesContext context = FacesContext.getCurrentInstance();

        if (context != null) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "抱歉! ", "系統问題 - " + errorMsg));
        }

        return "/static/index.html";
    }

//    @Override
    public String getErrorPath() {
        return "/error";
    }

    private void listAllHeaders(Map<String, String> headers) {
        headers.forEach((key, value) -> {
            logger.debug(String.format("Header '%s' = %s", key, value));
        });

        logger.debug(String.format(">>>>>>>>>>>> Listed %d headers <<<<<<<<<<<<<<", headers.size()));

    }
}
