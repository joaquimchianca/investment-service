package ufrn.imd.investmentservice.models;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "investimento_tesouro_direto")
public class InvestimentoTesouroDireto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long usuarioId;
    private BigDecimal saldo;
    @ManyToOne
    @JoinColumn(name = "titulo_id")
    private TituloTesouroDireto titulo;

    public BigDecimal obterSaldo() {
        return this.getSaldo();
    }

    public void devolverInvestimento() {}
}
