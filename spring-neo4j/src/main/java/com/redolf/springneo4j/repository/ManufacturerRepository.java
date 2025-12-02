package com.redolf.springneo4j.repository;

import com.redolf.springneo4j.entity.Manufacturer;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManufacturerRepository extends Neo4jRepository<Manufacturer, Long> {

    @Query("MATCH (m:Manufacturer) WHERE id(m) = $id RETURN m")
    Optional<Manufacturer> findById(@Param("id") Long id);

    Optional<Manufacturer> findByManufacturerName(String name);

}
