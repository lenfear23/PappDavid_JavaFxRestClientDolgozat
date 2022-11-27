package hu.petrik.dolgozat;

import com.google.gson.annotations.Expose;

public class Datas {
    private int id;
    @Expose
    private String name;
    @Expose
    private String jobtitle;
    @Expose
    private String company;
    @Expose
    private String status;


    public Datas(int id, String name, String product_id, String company, String status) {
        this.id = id;
        this.name = name;
        this.jobtitle = product_id;
        this.company = company;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
