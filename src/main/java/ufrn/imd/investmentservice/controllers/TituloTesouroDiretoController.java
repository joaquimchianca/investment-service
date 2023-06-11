package ufrn.imd.investmentservice.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufrn.imd.investmentservice.models.TituloTesouroDireto;
import ufrn.imd.investmentservice.services.TituloTesouroDiretoService;

@RestController
@RequestMapping("/api/tesouro_direto")
public class TituloTesouroDiretoController {

    @Autowired
    TituloTesouroDiretoService tituloService;

    @GetMapping("/titulos")
    public ResponseEntity<Page<TituloTesouroDireto>> listaTitulos(Pageable pageable) {
        Page<TituloTesouroDireto> titulos = tituloService.listaTitulosDisponiveis(pageable);
        return ResponseEntity.ok(titulos);
    }

    @GetMapping("/titulos/{id}")
    public ResponseEntity<TituloTesouroDireto> exibirTitulo(@PathVariable long id) {
        return ResponseEntity.of(tituloService.exibirTitulo(id));
    }
    @PostMapping("/titulos")
    @Transactional
    public ResponseEntity<TituloTesouroDireto> criarTitulo(@RequestBody TituloTesouroDireto input){
        return new ResponseEntity<>(tituloService.criarTitulo(input), HttpStatus.CREATED);
    }

}
