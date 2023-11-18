
package GUI;

public class Activities {
    
    private String name;
    private String desc;
    private String timeS;
    private String timeE;
    private String cat;
    private String user_id;
    private String days;
    
    public Activities(){}
    public Activities(String name, String desc, String timeS, String timeE, String cat,String user_id, String days ){
        
        this.name = name;
        this.desc = desc;
        this.timeS = timeS;
        this.timeE = timeE;
        this.cat = cat;
        this.user_id = user_id;
        this.days = days;
        
    }
    
        
        
        
        
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTimeS() {
        return timeS;
    }

    /**
     * @param timeS the timeS to set
     */
    public void setTimeS(String timeS) {
        this.timeS = timeS;
    }

    /**
     * @return the timeE
     */
    public String getTimeE() {
        return timeE;
    }

    public void setTimeE(String timeE) {
        this.timeE = timeE;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    
    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
    
}
