package com.example.Session_5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/cds")
public class CdsController implements CdsResource{
    private final CdsService cdsService;

    @Autowired
    public CdsController(CdsService cdsService) {
        this.cdsService = cdsService;
    }

    @Override
    @GetMapping
    public List<CdsDto> getAll() {
        return cdsService.getAllCds();
    }

    @Override
    @GetMapping("/{titulo}")
    public CdsDto getByTitulo(@PathVariable String titulo) {
        return cdsService.getCdsByTitulo(titulo);
    }

    @Override
    @PostMapping
    public CdsDto create(@RequestBody CdsDto dto) {
        return cdsService.createCds(dto);
    }

    @Override
    @PutMapping("/{titulo}")
    public CdsDto update(@PathVariable String titulo, @RequestBody CdsDto dto) {
        return cdsService.updateCds(titulo, dto);
    }

    @Override
    @DeleteMapping("/{titulo}")
    public void delete(@PathVariable String titulo) {
        cdsService.deleteCds(titulo);
    }
}
