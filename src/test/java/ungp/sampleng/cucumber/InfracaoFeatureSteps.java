package ungp.sampleng.cucumber;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import ungp.sampleng.backend.entity.Condutor;
import ungp.sampleng.backend.entity.Infracao;
import ungp.sampleng.backend.entity.Logradouro;
import ungp.sampleng.backend.entity.Veiculo;
import ungp.sampleng.backend.resource.CondutorResource;
import ungp.sampleng.backend.resource.InfracaoResource;
import ungp.sampleng.backend.resource.LogradouroResource;
import ungp.sampleng.backend.resource.VeiculoResource;
import ungp.sampleng.cucumber.util.SpringStep;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class InfracaoFeatureSteps extends SpringStep {

	@Autowired
	private InfracaoResource infracaoResource;
	
	@Autowired
	private VeiculoResource veiculoResource;
	
	@Autowired
	private CondutorResource condutorResource;
	
	@Autowired
	private LogradouroResource logradouroResource;

	private Veiculo veiculo;
	
	private Infracao infracao;

	@Dado("^Um veiculo com placa \"(.*?)\" e renavam \"(.*?)\"$")
	public void criarVeiculo(String placa, String renavam) throws Throwable {
		veiculo = new Veiculo();
		veiculo.setPlaca(placa);
		veiculo.setRenavam(renavam);
	}

	@Dado("^um proprietario com  cpf \"(.*?)\" e nome \"(.*?)\" e cnh \"(.*?)\"$")
	public void criarProprietario(String cpf, String nome, String cnh) throws Throwable {
		Condutor condutor = new Condutor();
		condutor.setCpf(cpf);
		condutor.setNome(nome);
		condutor.setCnh(cnh);
		
		condutorResource.insert(condutor);
		veiculo.setProprietario(condutor);
		veiculoResource.insert(veiculo);
	}

	@Dado("^com o logradouro com id \"(.*?)\" e descricao \"(.*?)\"  e cep \"(.*?)\" e tipo de logradouro \"(.*?)\"$")
	public void criarLogradouro(String id, String logradouroStr, String cep, String tipo) throws Throwable {
		Logradouro logradouro = new Logradouro();
		logradouro.setId(id);
		logradouro.setLogradouro(logradouroStr);
		logradouro.setCep(cep);
		logradouro.setTp_logradouro(tipo);
		
		logradouroResource.insert(logradouro);
	}

	@Dado("^com as seguintes infracoes:$")
	public void criarInfracoes(List<Map<String, String>> listMap) throws Throwable {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for (Map<String, String> map : listMap) {
			Infracao infracao = new Infracao();
			String cnh = map.get("proprietario");
			infracao.setDtInfracao(sdf.parse(map.get("data da infracao")));
			infracao.setId(map.get("id"));
			infracao.setCondutor(condutorResource.findById(cnh));
			infracao.setLogradouro(logradouroResource.findById(map.get("logradouro")));
			infracaoResource.insert(infracao);
		}
	}

	@Quando("^buscar infracao com id = (\\d+)$")
	public void buscarInfracao(String id) throws Throwable {
		infracao = infracaoResource.findById(id);
	}

	@Entao("^o sistema deve retornar a infracao:$")
	public void verificarInfracao(DataTable dataTable) throws Throwable {
		Assert.assertNotNull("infracao", infracao);
	}
}
