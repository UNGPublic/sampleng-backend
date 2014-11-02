package ungp.sampleng.backend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "proprietarios")
public class Proprietario implements Serializable {

    @Id
    private String nuCnh;
    private String nmProprietario;

    @DBRef
    private List<Veiculo> veiculos;

    public String getNuCnh() {
        return nuCnh;
    }

    public void setNuCnh(String nuCnh) {
        this.nuCnh = nuCnh;
    }

    public String getNmProprietario() {
        return nmProprietario;
    }

    public void setNmProprietario(String nmProprietario) {
        this.nmProprietario = nmProprietario;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
