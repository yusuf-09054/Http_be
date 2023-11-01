package Productdetails.supermarket;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //getter/setter
@NoArgsConstructor //default constructor
@AllArgsConstructor //parameterized constructor
public class supermarketentity
{
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int productcount;
    private String productCategory;
    private String productBrand;
    private String productName;
    private int productPrice;
    private int productOffer;
}
