package com.example.swaggercodegenexample.repositories;

import com.example.swaggercodegenexample.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;
import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {
    @Query("select v from Visit v where v.date between :dateStart and :dateEnd")
    List<Visit> findByDateBetween(@Param("dateStart") OffsetDateTime dateStart,
                                  @Param("dateEnd") OffsetDateTime dateEnd);
}
