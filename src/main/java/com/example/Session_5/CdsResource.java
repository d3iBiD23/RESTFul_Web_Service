package com.example.Session_5;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public interface CdsResource {
    @GetMapping
    List<CdsDto> getAll();

    @GetMapping("/{titulo}")
    CdsDto getByTitulo(@PathVariable String titulo);

    @PostMapping
    CdsDto create(@RequestBody CdsDto dto);

    @PutMapping("/{titulo}")
    CdsDto update(@PathVariable String titulo, @RequestBody CdsDto dto);

    @DeleteMapping("/{titulo}")
    void delete(@PathVariable String titulo);

    @PatchMapping("/{titulo}")
    CdsDto patchCds(@PathVariable String titulo, @RequestBody Map<String, Object> updates);
}
