package com.example.Session_5;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cds")
public class Cds {
    @Id
    private String titulo;
    private String autor;
    private String genero;
    private String prestamo;
}
