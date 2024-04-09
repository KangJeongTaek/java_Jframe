public class UsersDto {
    private String id;
    private String password;
    private int time_Re;
    
    public UsersDto(){

    }
    public UsersDto(String id, String passWord, int time_Re){
        this.id = id;
        this.password = passWord;
        this.time_Re = time_Re;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getTime_Re() {
        return time_Re;
    }
    public void setTime_Re(int time_Re) {
        this.time_Re = time_Re;
    }

    @Override
    public String toString(){
        return "아이디 : " + id + ", 비밀번호 : " + password; 
    }
}
