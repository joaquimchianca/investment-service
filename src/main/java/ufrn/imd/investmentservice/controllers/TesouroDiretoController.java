package ufrn.imd.investmentservice.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufrn.imd.investmentservice.dto.Aplicacao;
import ufrn.imd.investmentservice.models.InvestimentoTesouroDireto;
import ufrn.imd.investmentservice.models.TituloTesouroDireto;
import ufrn.imd.investmentservice.services.InvestimentoTesouroDiretoService;
import ufrn.imd.investmentservice.services.TituloTesouroDiretoService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/tesouro_direto")
public class TesouroDiretoController {

    final InvestimentoTesouroDiretoService investimentoService;

    @Autowired
    public TesouroDiretoController(InvestimentoTesouroDiretoService investimentoService) {
        this.investimentoService = investimentoService;
    }


    @PostMapping("{usuarioId}/{tituloId}")
    public  ResponseEntity<InvestimentoTesouroDireto> investir(
            @PathVariable Long usuarioId,
            @PathVariable Long tituloId,
            @RequestBody Aplicacao valorInvestido
            ) {
        return ResponseEntity.ok(investimentoService.investir(usuarioId, tituloId, valorInvestido.getValor()));
    };
    @GetMapping("/{usuarioId}/{tituloId}")
    public ResponseEntity<InvestimentoTesouroDireto> informacaoInvestimento(
            @PathVariable long usuarioId,
            @PathVariable long tituloId
    ){
        return ResponseEntity.ok(
                investimentoService.infoInvestimento(usuarioId, tituloId)
        );
    }
    @PostMapping("/{usuarioId}/{tituloId}/sacar")
    public ResponseEntity<InvestimentoTesouroDireto> sacarInvestimento(
            @PathVariable long usuarioId,
            @PathVariable long tituloId
    ){
        investimentoService.sacarInvestimento(usuarioId, tituloId);
        return ResponseEntity.ok().build();
    }
}
