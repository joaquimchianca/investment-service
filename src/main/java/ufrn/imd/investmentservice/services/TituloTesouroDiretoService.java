package ufrn.imd.investmentservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ufrn.imd.investmentservice.models.TituloTesouroDireto;
import ufrn.imd.investmentservice.repositories.TituloTesouroDiretoRepository;

@Service
public class TituloTesouroDiretoService {
    @Autowired
    private TituloTesouroDiretoRepository tituloRepository;

    public Page<TituloTesouroDireto> listaTitulosDisponiveis(Pageable pageable) {
        return tituloRepository.findAll(pageable);
    }

}
