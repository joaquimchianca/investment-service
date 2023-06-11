package ufrn.imd.investmentservice.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Entity
@Table(name="titulo_tesouro_direto")
public class TituloTesouroDireto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float taxaDeJuros;
    private LocalDate vencimento;
}

