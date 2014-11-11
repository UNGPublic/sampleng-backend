package ungp.sampleng.backend.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="infracoes")
public class Infracao implements Serializable{

	private static final long serialVersionUID = 6279552463751962664L;

	@Id
	private String id;
	private Date dtInfracao;

	@DBRef
    private Logradouro logradouro;
    private Condutor condutor;
    

    public Date getDtInfracao() {
		return dtInfracao;
	}
    
	public void setDtInfracao(Date dtInfracao) {
		this.dtInfracao = dtInfracao;
	}
	
	public Logradouro getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}
	
	public Condutor getCondutor() {
		return condutor;
	}
	
	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}
	
	public boolean isCondutorProprietario() {
		return getCondutor() instanceof Proprietario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
