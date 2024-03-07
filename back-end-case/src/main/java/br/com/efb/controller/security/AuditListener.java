package br.com.efb.controller.security;

import br.com.efb.controller.entity.AuditEntity;
import br.com.efb.controller.api.BaseResource;
import org.hibernate.envers.RevisionListener;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;


public class AuditListener extends BaseResource implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        AuditEntity revEntity = (AuditEntity) revisionEntity;
        revEntity.setUsuario("Token");
        revEntity.setTimestamp(new Date().getTime());
        revEntity.setIp("Teste IP");
    }

    private HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest();
    }

    private HttpSession getSession() {
        return getRequest().getSession();
    }
}
