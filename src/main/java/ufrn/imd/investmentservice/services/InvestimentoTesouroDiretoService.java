package ufrn.imd.investmentservice.services;

import org.springdoc.core.converters.models.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ufrn.imd.investmentservice.models.InvestimentoTesouroDireto;
import ufrn.imd.investmentservice.models.TituloTesouroDireto;
import ufrn.imd.investmentservice.repositories.InvestimentoTesouroDiretoRepository;
import ufrn.imd.investmentservice.repositories.TituloTesouroDiretoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
    @Scheduled(cron="0 1 * * * *")
    public void rendimento(){
        LocalDate start = LocalDate.ofEpochDay(System.currentTimeMillis() / (24 * 60 * 60 * 1000) ).withDayOfMonth(1);

        LocalDate end = LocalDate.ofEpochDay(System.currentTimeMillis() / (24 * 60 * 60 * 1000) ).plusMonths(1).withDayOfMonth(1).minusDays(1);

        List<InvestimentoTesouroDireto> investimentos = investimentoRepository.findByCreatedAtGreaterThanAndCreatedAtLessThan(start, end);

        List<InvestimentoTesouroDireto> investimentosAtualizados = investimentos.stream().map(investimento -> {
            BigDecimal juros = BigDecimal.valueOf(investimento.getTitulo().getTaxaDeJuros());
            BigDecimal saldoAtual = investimento.getSaldo();
            investimento.setSaldo(saldoAtual.add((saldoAtual.multiply((juros)))));
            return investimento;
        }).collect(Collectors.toList());

        investimentoRepository.saveAll(investimentosAtualizados);

    }
}
