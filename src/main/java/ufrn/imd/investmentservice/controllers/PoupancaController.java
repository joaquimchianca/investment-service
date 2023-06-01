package ufrn.imd.investmentservice.controllers;

import java.math.BigDecimal;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufrn.imd.investmentservice.models.Poupanca;

@RestController
@RequestMapping("/api/poupanca")
public class PoupancaController {
    @GetMapping("/{id}")
    public Poupanca getPoupanca(){
        // Pega do banco de dados...
        Poupanca p = new Poupanca();
        return p;
    };

    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity<Poupanca> createPoupanca(
        @RequestBody Poupanca input
    ){
        return ResponseEntity.ok(input);
    };

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}/adicionar_montante")
    @Transactional
    public void adicionarMontante(
        @PathVariable Long id,
        @RequestBody BigDecimal quantia
    ){
        Poupanca p = new Poupanca();
        p.setMontante(p.getMontante().add(quantia));
    }


    @PatchMapping("/{id}/retirar")
    @Transactional
    public BigDecimal retirarMontante(
        @PathVariable Long id
    ){
        Poupanca p = new Poupanca();
        return p.getMontante();
    }

}
