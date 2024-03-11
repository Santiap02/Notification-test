package co.com.study.model.restaurante;

import co.com.study.model.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurante {

    private Long id;

    private Long idPropietario;

    private String direccion;

    private String estado;

    private String nit;

    private String nombre;

    private String telefono;

    private Usuario propetario;

}
