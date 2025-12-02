package com.redolf.springneo4j.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue
    private Long id;
    private String supplierName;
    private String supplierType;

    @Relationship( type = "SUPPLIES_TO",direction = Relationship.Direction.OUTGOING)
    private Manufacturer manufacturer;
}
