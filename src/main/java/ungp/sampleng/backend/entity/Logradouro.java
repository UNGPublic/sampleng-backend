package ungp.sampleng.backend.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

/**
 * Full text document.
 */
@Document(collection="logradouros", language="portuguese")
public class Logradouro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
    private String cep;
    
    @TextIndexed(weight=5F)
    private String logradouro;
    @TextIndexed(weight=3F)
    private String cidade;
    @TextIndexed(weight=1F)
    private String bairro;
    
    @TextScore 
    private Float score;
    
    private String tp_logradouro;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getTp_logradouro() {
		return tp_logradouro;
	}
	public void setTp_logradouro(String tp_logradouro) {
		this.tp_logradouro = tp_logradouro;
	}
	@Override
	public String toString() {
		return "Logradouro [id=" + id + ", cep=" + cep + ", logradouro="
				+ logradouro + ", cidade=" + cidade + ", bairro=" + bairro
				+ ", tp_logradouro=" + tp_logradouro + "]";
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}

    
    
}
