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
public class Manufacturer {

    @Id
    @GeneratedValue
    private Long id;
    private String manufacturerName;
    private String manufacturerType;

    @Relationship(type = "RECEIVES_FROM",direction = Relationship.Direction.INCOMING)
    private Supplier supplier;
}
