package com.dev.alpha.leruo;

public class Profile {
    private String name;
    private String location;
    private String contact;

    private int profilePic;
    private boolean permission;

    public Profile() {
    }

    public Profile(int profilePic, String name, String location, String contact /*, boolean permission*/) {
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.profilePic = profilePic;
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(int profilePic) {
        this.profilePic = profilePic;
    }

    public boolean getPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }
}
