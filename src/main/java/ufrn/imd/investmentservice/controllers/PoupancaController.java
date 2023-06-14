package ufrn.imd.investmentservice.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufrn.imd.investmentservice.models.Poupanca;
import ufrn.imd.investmentservice.services.PoupancaService;

@RestController
@RequestMapping("/api/poupanca")
public class PoupancaController {

    private final PoupancaService poupancaService;

    @Autowired
    public PoupancaController(PoupancaService poupancaService) {
        this.poupancaService = poupancaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poupanca> getPoupanca(@PathVariable Long id) {
        return poupancaService.getPoupancaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<Poupanca>> getAllPoupanca(Pageable pageable) {
        Page<Poupanca> poupancas = poupancaService.getAllPoupanca(pageable);
        return ResponseEntity.ok(poupancas);
    }

    @PostMapping
    public ResponseEntity<Poupanca> createPoupanca(@RequestBody Poupanca poupanca) {
        Poupanca savedPoupanca = poupancaService.savePoupanca(poupanca);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPoupanca);
    }

    @PatchMapping("/{id}/adicionar_montante")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void adicionarMontante(@PathVariable Long id, @RequestBody BigDecimal quantia) {
        poupancaService.adicionarMontante(id, quantia);
    }

    @PatchMapping("/{id}/retirar")
    public ResponseEntity<BigDecimal> retirarMontante(@PathVariable Long id) {
        BigDecimal montanteRetirado = poupancaService.retirarMontante(id);
        return ResponseEntity.ok(montanteRetirado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleta(@PathVariable Long id) {
        poupancaService.deleta(id);
    }
}
