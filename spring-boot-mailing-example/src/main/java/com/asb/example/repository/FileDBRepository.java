package com.asb.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asb.example.dto.FileDB;


@Repository
public interface FileDBRepository extends JpaRepository<FileDB, Long>{

}
