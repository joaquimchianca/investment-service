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
@Table(name = "tesouro_direto")
public class InvestimentoTesouroDireto implements Investimento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long usuario_id;
    private BigDecimal saldo;
    @ManyToOne
    private TituloTesouroDireto titulo;

    public BigDecimal obterSaldo() {
        return this.getSaldo();
    }

    public void devolverInvestimento() {}
}
