package ufrn.imd.investmentservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufrn.imd.investmentservice.models.Poupanca;
import ufrn.imd.investmentservice.repositories.PoupancaRepository;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class PoupancaService {

    private final PoupancaRepository poupancaRepository;

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

    public void adicionarMontante(Long id, BigDecimal quantia) {
        Optional<Poupanca> optionalPoupanca = poupancaRepository.findById(id);
        if (optionalPoupanca.isPresent()) {
            Poupanca poupanca = optionalPoupanca.get();
            BigDecimal novoMontante = poupanca.getMontante().add(quantia);
            poupanca.setMontante(novoMontante);
            poupancaRepository.save(poupanca);
        } else {
            throw new IllegalArgumentException("Poupanca not found with id: " + id);
        }
    }

    public BigDecimal retirarMontante(Long id) {
        Optional<Poupanca> optionalPoupanca = poupancaRepository.findById(id);
        if (optionalPoupanca.isPresent()) {
            Poupanca poupanca = optionalPoupanca.get();
            BigDecimal montante = poupanca.getMontante();
            poupanca.setMontante(BigDecimal.ZERO);
            poupancaRepository.save(poupanca);
            return montante;
        } else {
            throw new IllegalArgumentException("Poupanca not found with id: " + id);
        }
    }
}
