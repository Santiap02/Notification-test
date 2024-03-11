package co.com.study.r2dbc;

import co.com.study.UsuarioData;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

// TODO: This file is just an example, you should delete or modify it
public interface UsuarioDataRepository extends ReactiveCrudRepository<UsuarioData, Long>
        , ReactiveQueryByExampleExecutor<UsuarioData> {

}
