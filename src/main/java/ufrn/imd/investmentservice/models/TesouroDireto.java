package ufrn.imd.investmentservice.models;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;

@Data
@Builder
@Entity
@Table(name = "tesouro_direto")
public class TesouroDireto implements Investimento {
    private BigDecimal saldo;
    private Integer taxaDeJuros;
}