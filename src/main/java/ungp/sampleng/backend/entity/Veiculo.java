package ungp.sampleng.backend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "veiculos")
public class Veiculo implements Serializable {

    @Id
    private String nuPlaca;
    private String nuRenavam;

    @DBRef
    private Proprietario proprietario;

    public String getNuRenavam() {
        return nuRenavam;
    }

    public void setNuRenavam(String nuRenavam) {
        this.nuRenavam = nuRenavam;
    }

    public String getNuPlaca() {
        return nuPlaca;
    }

    public void setNuPlaca(String nuPlaca) {
        this.nuPlaca = nuPlaca;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
}
