package Connectmongo;

public class User {
    String stName;
    String stTD;
    String stDOB;

    public User(){}
    public User(String stName, String stID){
        this.stName = stName;
        this.stTD = stID;

    }
    public User(String stName, String stID, String stDOB) {
        this.stName = stName;
        this.stTD = stID;
        this.stDOB = stDOB;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getStTD() {
        return stTD;
    }

    public void setStTD(String stTD) {
        this.stTD = stTD;
    }

    public String getStDOB() {
        return stDOB;
    }

    public void setStDOB(String stDOB) {
        this.stDOB = stDOB;
    }}

