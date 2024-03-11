package co.com.study.r2dbc;

import co.com.study.UsuarioData;
import co.com.study.model.usuario.Usuario;
import co.com.study.model.usuario.gateways.UsuarioRepository;
import co.com.study.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDataRepositoryAdapter extends ReactiveAdapterOperations<Usuario, UsuarioData, Long, UsuarioDataRepository>
        implements UsuarioRepository
{
    public UsuarioDataRepositoryAdapter(UsuarioDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Usuario.class));
    }

}
