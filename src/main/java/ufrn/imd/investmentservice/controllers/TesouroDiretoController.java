package ufrn.imd.investmentservice.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufrn.imd.investmentservice.models.InvestimentoTesouroDireto;
import ufrn.imd.investmentservice.models.TituloTesouroDireto;
import ufrn.imd.investmentservice.services.InvestimentoTesouroDiretoService;
import ufrn.imd.investmentservice.services.TituloTesouroDiretoService;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
class Input {
    BigDecimal valorInvestido;
}
@RestController
@RequestMapping("/api/tesouro_direto")
public class TesouroDiretoController {

    @Autowired
    InvestimentoTesouroDiretoService investimentoService;


    @PostMapping("{usuarioId}/{tituloId}")
    public  ResponseEntity<InvestimentoTesouroDireto> investir(
            @PathVariable Long usuarioId,
            @PathVariable Long tituloId,
            @RequestBody Input valorInvestido
            ) {
        return ResponseEntity.ok(investimentoService.investir(usuarioId, tituloId, valorInvestido.valorInvestido));
    };
    @GetMapping("/{usuarioId}/{tituloId}")
    public ResponseEntity<InvestimentoTesouroDireto> info(
            @PathVariable long usuarioId,
            @PathVariable long tituloId
    ){

        return ResponseEntity.ok(
                investimentoService.infoInvestimento(usuarioId, tituloId)
        );

    }


}
