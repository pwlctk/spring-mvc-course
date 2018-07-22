package pl.pwlctk.kursspringmvc.models;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Component
@Entity
public class Package {
    public static final int STANDARD = 1000;
    public static final int PREMIUM = 500;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int type;
    private int expired;

    public Package() {
    }

    public Package(int type, int expired) {
        this.type = type;
        this.expired = expired;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getExpired() {
        return expired;
    }

    public void setExpired(int expired) {
        this.expired = expired;
    }
}
