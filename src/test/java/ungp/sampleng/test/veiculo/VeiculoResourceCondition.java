package ungp.sampleng.test.veiculo;

import org.junit.runner.Description;
import org.springframework.data.mongodb.core.MongoOperations;
import ungp.sampleng.backend.entity.Proprietario;
import ungp.sampleng.backend.entity.Veiculo;
import ungp.sampleng.backend.util.Application;
import ungp.sampleng.test.Condition;

public class VeiculoResourceCondition extends Condition {

    @Override
    public void prepare(Description description) {
        MongoOperations mongoOperation = Application.getMongoOperations();

        Veiculo veiculo = createVeiculo();
        Proprietario proprietario = veiculo.getProprietario();

        mongoOperation.insert(proprietario);
        mongoOperation.insert(veiculo);
    }

    @Override
    public void done(Description description) {
        MongoOperations mongoOperation = Application.getMongoOperations();
        mongoOperation.dropCollection(Veiculo.class);
        mongoOperation.dropCollection(Proprietario.class);
    }

    public static Veiculo createVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setNuPlaca("ABC0123");
        veiculo.setNuRenavam("5451355435453");

        Proprietario proprietario = new Proprietario();
        proprietario.setNmProprietario("John Java");
        proprietario.setNuCnh("1234567890");
        veiculo.setProprietario(proprietario);

        return veiculo;
    }

}
