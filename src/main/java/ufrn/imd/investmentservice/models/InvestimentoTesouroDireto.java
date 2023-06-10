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
    private BigDecimal saldo;

    public BigDecimal obterSaldo() {
        return this.getSaldo();
    }

    public void devolverInvestimento() {}
}
