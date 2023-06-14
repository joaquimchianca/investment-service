package ufrn.imd.investmentservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "historico")
public class ItemHistorico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private BigDecimal valor;
    private LocalDateTime dataAplicacao;
    @ManyToOne
    @JoinColumn(name = "poupanca_id")
    private Poupanca poupanca;
}
