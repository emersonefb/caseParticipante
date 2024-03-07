package br.com.efb.controller.api;

import br.com.efb.controller.service.IParticipanteService;
import br.com.efb.controller.util.VersionInfo;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

public class BaseResource{

    private WebApplicationContext webApplicationContext;

    protected Logger logger = Logger.getLogger(this.getClass());

    @Context
    protected HttpServletRequest request;
    protected VersionInfo versionInfo;
    protected IParticipanteService participanteServiceImpl;

    protected void init() {
        participanteServiceImpl = getBean("participanteServiceImpl",IParticipanteService.class);

    }

    @Context
    protected void setWebApplicationContext(ServletContext servletContext) {
        webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        init();
    }

    protected WebApplicationContext getWebApplicationContext() {
        return webApplicationContext;
    }

    @SuppressWarnings("unchecked")
    protected <T> T getBean(String beanName, Class<T> beanType) {
        return (T) getWebApplicationContext().getBean(beanName, beanType);
    }
}
