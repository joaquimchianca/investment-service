package ufrn.imd.investmentservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufrn.imd.investmentservice.models.InvestimentoTesouroDireto;
import ufrn.imd.investmentservice.models.TituloTesouroDireto;
import ufrn.imd.investmentservice.repositories.InvestimentoTesouroDiretoRepository;
import ufrn.imd.investmentservice.repositories.TituloTesouroDiretoRepository;

import java.math.BigDecimal;

@Service
public class InvestimentoTesouroDiretoService {

    @Autowired
    private InvestimentoTesouroDiretoRepository investimentoRepository;
    @Autowired
    private TituloTesouroDiretoRepository tituloRepository;

    public InvestimentoTesouroDireto investir(Long usuarioId, Long tituloId, BigDecimal valorInvestido) {
        InvestimentoTesouroDireto investimento = investimentoRepository.findByUsuarioIdAndTituloId(usuarioId, tituloId);
        if (investimento == null) {
            TituloTesouroDireto titulo = tituloRepository.findById(tituloId).orElseThrow();
            InvestimentoTesouroDireto novoInvestimento = InvestimentoTesouroDireto.builder()
                    .titulo(titulo)
                    .saldo(valorInvestido)
                    .usuarioId(usuarioId)
                    .build();
            return investimentoRepository.save(novoInvestimento);
        }
        investimento.setSaldo(investimento.getSaldo().add(valorInvestido));
        return investimentoRepository.save(investimento);
    }
    public InvestimentoTesouroDireto infoInvestimento(Long usuarioId, Long tituloId) {
        return investimentoRepository.findByUsuarioIdAndTituloId(usuarioId, tituloId);
    }

    public void sacarInvestimento(Long usuarioId, Long tituloId){
        InvestimentoTesouroDireto investimento = investimentoRepository.findByUsuarioIdAndTituloId(usuarioId, tituloId);
        BigDecimal saldoAtual = investimento.getSaldo();
        // ContaService.realizarTransferencia(...)
        investimento.setSaldo(BigDecimal.ZERO);
    }
}
