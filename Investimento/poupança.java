import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poupanca")
public class PoupancaController {
    private Poupanca poupanca;
    
    @Autowired
    public PoupancaController(Poupanca poupanca) {
        this.poupanca = poupanca;
    }
    
    @GetMapping("/saldo")
    public double obterSaldo() {
        return poupanca.obterSaldo();
    }
    
    @GetMapping("/juros")
    public void calcularJuros() {
        poupanca.calcularJuros();
    }

    @PostMapping
    
   
}
