package com.redolf.databaselocks.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Setter
@Getter
@Entity
@Table(name = "tbl_seat")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BusSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer id;
    private String passengerName;
    private  boolean isBooked;

}
