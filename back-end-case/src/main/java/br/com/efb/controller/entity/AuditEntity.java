package br.com.efb.controller.entity;

import br.com.efb.controller.security.AuditListener;
import org.hibernate.envers.*;

import javax.persistence.Entity;

@Entity(name="revinfo_cust")
@RevisionEntity(AuditListener.class)
public class AuditEntity extends DefaultRevisionEntity {

    private static final long serialVersionUID = 1L;

    public String usuario;
    public String ip;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
