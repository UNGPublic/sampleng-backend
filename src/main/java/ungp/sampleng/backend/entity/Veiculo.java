package ungp.sampleng.backend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "veiculos")
public class Veiculo implements Serializable {

    @Id
    private String nuPlaca;
    private String nuRenavam;
    private String nmProprietario;

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

    public String getNmProprietario() {
        return nmProprietario;
    }

    public void setNmProprietario(String nmProprietario) {
        this.nmProprietario = nmProprietario;
    }



}
