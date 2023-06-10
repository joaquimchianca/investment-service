package ufrn.imd.investmentservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
