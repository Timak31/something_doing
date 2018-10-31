package app;

public class Admin {
    private final String user = "admin";
    private final String password = "admin";
    private boolean check;

    public Admin() {}

    public Admin(String userEnter, String passwordEnter) {
        setCheck(userEnter, passwordEnter);
    }

    private void setCheck(String userEnter, String passwordEnter) {
        this.check = this.user.equals(userEnter) && this.password.equals(passwordEnter);
    }

    public boolean isCheck() {
        return check;
    }
}
