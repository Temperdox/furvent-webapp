package org.furvent.web_app.utility.user;
import lombok.Getter;
import lombok.Setter;
import org.furvent.web_app.utility.widgets.Widget;

import javax.jdo.annotations.Persistent;
import javax.persistence.*;
import java.util.HashMap;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long discriminator;

    @Getter @Setter
    private String userName;

    @Getter @Setter
    private String nickName;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private int level;

    @Getter @Setter
    private int xp;

    @Getter @Setter
    private boolean trusted;

    @Getter @Setter
    private int balance;

    @Getter @Setter
    private int reputation;

    @Getter
    @OneToMany
    private Set<User> friends;

    @Getter
    @OneToMany
    private Set<User> blocked;

    @Getter
    @OneToMany
    private Set<User> muted;

    @Getter
    @OneToMany
    private Set<User> deafened;

    @Getter
    @Transient
    private Set<Widget> widgets;

    //used for when the user turns another users volume down on VOIP.
    @Getter
    @Transient
    private HashMap<User, Double> volume;

    protected User() {
    }

    public User(String userName, String nickName) {
        this.userName = userName;
        this.nickName = nickName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((discriminator == null) ? 0 : discriminator.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User user = (User) obj;
        if (discriminator == null) {
            return user.discriminator == null;
        } else return discriminator.equals(user.discriminator);
    }

    public boolean addFriend(User user){
        try{
            friends.add(user);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeFriend(User user){
        try{
            friends.remove(user);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean block(User user){
        try{
            blocked.add(user);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean unblock(User user){
        try{
            blocked.remove(user);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("User[id=%d, firstName='%s', lastName='%s']", discriminator,
                userName, nickName);
    }
}
