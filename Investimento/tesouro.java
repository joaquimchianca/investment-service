import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tesouro")
public class TesouroController {
    private Tesouro tesouro;
    
    @Autowired
    public TesouroController(Tesouro tesouro) {
        this.tesouro = tesouro;
    }
    
    @GetMapping("/saldo")
    public double obterSaldo() {
        return tesouro.obterSaldo();
    }
    
    @GetMapping("/juros")
    public void calcularJuros() {
        tesouro.calcularJuros();
    }
    
    @GetMapping("/titulos")
    public List<Titulo> listarTitulos() {
        return tesouro.listarTitulos();
    }
    
    @PostMapping("/comprar")
    public void comprarTitulo(@RequestBody Titulo titulo) {
        tesouro.comprarTitulo(titulo);
    }
    
    @PostMapping("/vender")
    public void venderTitulo(@RequestBody Titulo titulo) {
        tesouro.venderTitulo(titulo);
    }
    
    @PostMapping("/dividendos")
    public void pagarDividendos() {
        tesouro.pagarDividendos();
    }
    
    @GetMapping("/carteira")
    public List<Titulo> listarCarteira() {
        return tesouro.listarCarteira();
    }
    
   
}
