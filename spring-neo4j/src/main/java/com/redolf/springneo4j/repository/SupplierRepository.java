package com.redolf.springneo4j.repository;

import com.redolf.springneo4j.entity.Supplier;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierRepository extends Neo4jRepository<Supplier, Long> {

    @Query("MATCH (s:Supplier) WHERE elementId(s) = $id RETURN s")
    Optional<Supplier> findByElementId(@Param("id") String id);
}
