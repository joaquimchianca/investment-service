package ufrn.imd.investmentservice.models;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "poupanca")
public class Poupanca {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int taxaDeJuros;
    private BigDecimal montante;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "poupanca_id", referencedColumnName = "id")
    private List<ItemHistorico> historico;
}