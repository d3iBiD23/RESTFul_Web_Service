package com.example.Session_5;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CdsService {

    @Autowired
    private CdsRepository cdsRepository;

    public List<CdsDto> getAllCds() {
        return cdsRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public CdsDto getCdsByTitulo(String titulo) {
        return cdsRepository.findById(titulo)
                .map(this::convertToDto)
                .orElseThrow(() -> new RuntimeException("CD con título: " + titulo + " no encontrado."));
    }

    public CdsDto createCds(CdsDto dto) {
        Cds cd = convertToEntity(dto);
        cd = cdsRepository.save(cd);
        return convertToDto(cd);
    }

    public CdsDto updateCds(String titulo, CdsDto dto) {
        Cds existente = cdsRepository.findById(titulo)
                .orElseThrow(() -> new RuntimeException("CD con título: " + titulo + " no encontrado."));
        existente.setAutor(dto.getAutor());
        existente.setGenero(dto.getGenero());
        existente.setPrestamo(dto.getPrestamo());
        existente = cdsRepository.save(existente);
        return convertToDto(existente);
    }

    public void deleteCds(String titulo) {
        if (!cdsRepository.existsById(titulo)) {
            throw new RuntimeException("CD con título: " + titulo + " no encontrado.");
        }
        cdsRepository.deleteById(titulo);
    }

    public CdsDto patchCds(String titulo, Map<String, Object> updates) {
        // buscar cd en BBDD
        Cds existente = cdsRepository.findById(titulo)
                .orElseThrow(() -> new RuntimeException("CD con título: " + titulo + " no encontrado."));

        // para cada posible campo, verificamos si viene en el map 'updates'
        if (updates.containsKey("autor")){
            existente.setAutor((String) updates.get("autor"));
        }
        if (updates.containsKey("genero")) {
            existente.setGenero((String) updates.get("genero"));
        }
        if (updates.containsKey("prestamo")) {
            existente.setPrestamo((String) updates.get("prestamo"));
        }

        // guardamos el CD actualizado
        existente = cdsRepository.save(existente);

        return convertToDto(existente);
    }

    public CdsDto getGeneroByAutor(String autor){
        List<Cds> cdsList = cdsRepository.findByAutor(autor);
        if (cdsList.isEmpty()) {
            throw new RuntimeException("No se encontró ningún CD del autor: " + autor);
        }

        // Retorna el DTO del primer CD encontrado
        return convertToDto(cdsList.get(0));
    }

    private CdsDto convertToDto(Cds cd) {
        CdsDto dto = new CdsDto();
        dto.setTitulo(cd.getTitulo());
        dto.setAutor(cd.getAutor());
        dto.setGenero(cd.getGenero());
        dto.setPrestamo(cd.getPrestamo());
        return dto;
    }

    private Cds convertToEntity(CdsDto dto) {
        Cds cd = new Cds();
        cd.setTitulo(dto.getTitulo());
        cd.setAutor(dto.getAutor());
        cd.setGenero(dto.getGenero());
        cd.setPrestamo(dto.getPrestamo());
        return cd;
    }

}
