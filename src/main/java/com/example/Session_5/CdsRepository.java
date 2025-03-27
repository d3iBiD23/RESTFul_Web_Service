package com.example.Session_5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CdsRepository extends JpaRepository<Cds, String> {
}
