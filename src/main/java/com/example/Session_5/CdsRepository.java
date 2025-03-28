package com.example.Session_5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CdsRepository extends JpaRepository<Cds, String> {

    List<Cds> findByAutor(String autor);
}
