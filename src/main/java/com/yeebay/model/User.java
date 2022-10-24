package com.yeebay.model;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Setter(AccessLevel.PROTECTED)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private Float balance;
    @Column
    private String mobileNum;
    @Column
    private String address;

    //@Setter(AccessLevel.NONE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seller", fetch = FetchType.LAZY)
    private List<Listing> userListings = new LinkedList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", mobilenum='" + mobileNum + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
