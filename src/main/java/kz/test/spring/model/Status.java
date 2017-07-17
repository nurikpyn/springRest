package kz.test.spring.model;


public class Status {
    private Long id;
    private String oldStatus;
    private String status;

    public Status(){

    }
    public Status(Long id, String oldStatus, String status) {
        this.id = id;
        this.oldStatus = oldStatus;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(String oldStatus) {
        this.oldStatus = oldStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
