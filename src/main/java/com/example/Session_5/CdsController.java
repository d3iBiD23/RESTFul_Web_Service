package com.example.Session_5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/genero")
    public Map<String, String> getGeneroByAutor(@RequestParam String autor) {
        CdsDto dto = cdsService.getGeneroByAutor(autor);
        return Collections.singletonMap("genero", dto.getGenero());
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

    @PatchMapping("/{titulo}")
    @Override
    public CdsDto patchCds(String titulo, Map<String, Object> updates) {
        return cdsService.patchCds(titulo, updates);
    }
}
