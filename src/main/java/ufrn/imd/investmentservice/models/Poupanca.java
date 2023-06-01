package ufrn.imd.investmentservice.models;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;

class Historico {
    private LocalDate data;
    private BigDecimal valorInserido;
}

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "poupanca")
public class Poupanca implements Investimento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int taxaDeJuros;
    private BigDecimal montante;
    private LinkedList<Historico> historico;

    public void retirarMontante() {}

    public BigDecimal obterSaldo() {
        return this.getMontante();
    };
    public void devolverInvestimento() {};
}