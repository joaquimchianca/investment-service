package ufrn.imd.investmentservice.models;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;

private class Historico {
    private LocalDate data;
    private BigDecimal valorInserido;
}

@Data
@Builder
@Entity
@Table(name = "poupanca")
public class Poupanca implements Investimento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taxaDeJuros;
    private BigDecimal montante;
    private LinkedList<Historico> historico;

    public void retirarMontante() {}
}