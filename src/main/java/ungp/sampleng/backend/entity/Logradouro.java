package ungp.sampleng.backend.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="logradouro")
public class Logradouro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
    private String nuCep;
    private String nmLogradouro;
    private Integer nuLogradouro;

    public String getNuCep() {
        return nuCep;
    }

    public void setNuCep(String nuCep) {
        this.nuCep = nuCep;
    }

    public String getNmLogradouro() {
        return nmLogradouro;
    }

    public void setNmLogradouro(String nmLogradouro) {
        this.nmLogradouro = nmLogradouro;
    }

    public Integer getNuLogradouro() {
        return nuLogradouro;
    }

    public void setNuLogradouro(Integer nuLogradouro) {
        this.nuLogradouro = nuLogradouro;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
