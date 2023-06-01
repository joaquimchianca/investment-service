package ufrn.imd.investmentservice.models;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tesouro_direto")
public class TesouroDireto implements Investimento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private BigDecimal saldo;
    private Integer taxaDeJuros;

    public BigDecimal obterSaldo() {
        return this.getSaldo();
    };

    public void devolverInvestimento() {};
}