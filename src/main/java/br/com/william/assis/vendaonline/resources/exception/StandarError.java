package br.com.william.assis.vendaonline.resources.exception;

import java.io.Serializable;

public class StandarError implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer status;
    private String Msg;
    private Long timeStamp;

    public StandarError(Integer status, String msg, Long timeStamp) {
         super();
        this.status = status;
        Msg = msg;
        this.timeStamp = timeStamp;

    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
