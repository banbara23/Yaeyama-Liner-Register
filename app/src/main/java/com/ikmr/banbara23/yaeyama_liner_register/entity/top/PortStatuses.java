package com.ikmr.banbara23.yaeyama_liner_register.entity.top;


import com.ikmr.banbara23.yaeyama_liner_register.entity.Port;
import com.ikmr.banbara23.yaeyama_liner_register.entity.Status;

public class PortStatuses {
    public PortStatuses() {
    }

    private Port port;
    private Status status;

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
