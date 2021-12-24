package com.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.Iternery;

@Repository
public interface IterneryRepository extends JpaRepository<Iternery, Long>{
Iternery findById(long id);

@Query(value="SELECT * FROM iternery  as t1 left join iterneries_package as t2 on t1.id = t2.id where tourpackage_id =:packid", nativeQuery = true)
List<Iternery> findAllIterneryBypack(@Param("packid") long packid);

}
