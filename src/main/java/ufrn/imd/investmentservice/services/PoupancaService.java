package ufrn.imd.investmentservice.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ufrn.imd.investmentservice.dto.Aplicacao;
import ufrn.imd.investmentservice.models.Poupanca;
import ufrn.imd.investmentservice.repositories.PoupancaRepository;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class PoupancaService {

    private final PoupancaRepository poupancaRepository;
    private final long SEGUNDO = 1000;

    @Autowired
    public PoupancaService(PoupancaRepository poupancaRepository) {
        this.poupancaRepository = poupancaRepository;
    }

    public Optional<Poupanca> getPoupancaById(Long id) {
        return poupancaRepository.findById(id);
    }

    public Poupanca savePoupanca(Poupanca poupanca) {
        return poupancaRepository.save(poupanca);
    }

    public Page<Poupanca> getAllPoupanca(Pageable p) {
        return poupancaRepository.findAll(p);
    }

    public Poupanca adicionarMontante(Long id, Aplicacao form) {
        Optional<Poupanca> optionalPoupanca = poupancaRepository.findById(id);
        if (optionalPoupanca.isPresent()) {
            Poupanca poupanca = optionalPoupanca.get();
            BigDecimal novoMontante = poupanca.getMontante().add(form.getValor());
            poupanca.setMontante(novoMontante);
            poupancaRepository.save(poupanca);
            return poupanca;
        } else {
            throw new IllegalArgumentException("Poupanca not found with id: " + id);
        }
    }

    public Poupanca retirarMontante(Long id, Aplicacao form) {
        Optional<Poupanca> optionalPoupanca = poupancaRepository.findById(id);
        if (optionalPoupanca.isPresent()) {
            Poupanca poupanca = optionalPoupanca.get();
            BigDecimal novoMontante = poupanca.getMontante().subtract(form.getValor());
            poupanca.setMontante(novoMontante);
            poupancaRepository.save(poupanca);
            return poupanca;
        } else {
            throw new IllegalArgumentException("Poupanca not found with id: " + id);
        }
    }

    public void deleta(Long id) {
        poupancaRepository.deleteById(id);
    }

    @Scheduled(fixedDelay = 3*SEGUNDO)
    @Transactional
    public void rendimento() {
        BigDecimal taxa = new BigDecimal("0.0072");
        poupancaRepository.rendimento(taxa);
    }
}
