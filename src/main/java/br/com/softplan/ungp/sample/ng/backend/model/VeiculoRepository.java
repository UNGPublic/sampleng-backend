package br.com.softplan.ungp.sample.ng.backend.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface VeiculoRepository extends CrudRepository<Veiculo, String> {

    Veiculo findByPlaca(String placa);

}
