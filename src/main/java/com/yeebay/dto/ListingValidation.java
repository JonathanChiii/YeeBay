package com.yeebay.dto;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;

import com.yeebay.model.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListingValidation {
    @NotEmpty(message = "Please enter a title.")
    private String title;

    private String category;

    @NotEmpty(message = "Please enter a brand.")
    private String brand;

    private String itemCondition;

    @DecimalMin("0")
    @DecimalMax("99999999")
    private Float price;

    private String description;
    private User seller;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    @Override
    public String toString() {
        return "ListingValidation{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", itemCondition='" + itemCondition + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", seller=" + seller +
                ", dateCreated=" + dateCreated +
                ", lastModified=" + lastModified +
                '}';
    }
}
