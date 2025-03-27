package com.example.Session_5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cds")
public class CdsController implements CdsResource{
    private final CdsService cdsService;

    @Autowired
    public CdsController(CdsService cdsService) {
        this.cdsService = cdsService;
    }

    @Override
    public List<CdsDto> getAll() {
        return List.of();
    }

    @Override
    public CdsDto getByTitulo(String titulo) {
        return null;
    }

    @Override
    public CdsDto create(CdsDto dto) {
        return null;
    }

    @Override
    public CdsDto update(String titulo) {
        return null;
    }

    @Override
    public void delete(String titulo) {

    }
}
