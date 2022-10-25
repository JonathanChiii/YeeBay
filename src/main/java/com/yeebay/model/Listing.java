package com.yeebay.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Listings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Listing {

    @Id
    @Setter(AccessLevel.PROTECTED)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;
    @Column
    private String category;

    @Column
    private String brand;
    @Column
    private String itemCondition;
    @Column
    private Float price;
    @Column
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    private User seller;
    @Column
    private Integer status;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created")
    private Date dateCreated;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified")
    private Date lastModified;

    @Override
    public String toString() {
        return "Listing{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", condition='" + itemCondition + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", seller=" + seller +
                ", status=" + status +
                ", dateCreated=" + dateCreated +
                ", lastModified=" + lastModified +
                '}';
    }
}
