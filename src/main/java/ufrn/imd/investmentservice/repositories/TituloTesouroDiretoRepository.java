package ufrn.imd.investmentservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ufrn.imd.investmentservice.models.TituloTesouroDireto;

@Repository
public interface TituloTesouroDiretoRepository extends JpaRepository<TituloTesouroDireto,Long> {
}
