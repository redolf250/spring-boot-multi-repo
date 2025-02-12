package com.redolf.storedprocedure.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.usertype.DynamicParameterizedType;

import java.math.BigDecimal;

@Entity
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_products")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "get_all_Products",
                procedureName = "getAllProducts"
        ),
        @NamedStoredProcedureQuery(
                name = "get_product_by_id",
                procedureName = "getProductById",
                parameters = {
                        @StoredProcedureParameter( mode =  ParameterMode.IN, name = "productId", type = Integer.class),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "count_products",
                procedureName = "countAllProducts",
                parameters = {
                        @StoredProcedureParameter( mode =  ParameterMode.OUT, name = "total", type = Integer.class),
                }
        )
})
public class Product {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;
    private String sku;
    private String productName;
    private double unitPrice;
    private String productDescription;
}
