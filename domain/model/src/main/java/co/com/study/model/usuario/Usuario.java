package co.com.study.model.usuario;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Usuario {

    private Long id;

    private String apellido;

    private String clave;

    private String email;

    private String estado;

    private String nombre;

    private Long numeroDocumento;

    private String telefono;

    private String tipoDocumento;

    private Long idRol;
}
