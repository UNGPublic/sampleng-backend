package ungp.sampleng.backend.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class Proprietario extends Condutor {

	private static final long serialVersionUID = 1L;

    @DBRef
    private List<Veiculo> veiculos;

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
    
}
