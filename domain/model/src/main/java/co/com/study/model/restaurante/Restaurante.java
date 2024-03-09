package co.com.study.model.restaurante;
import lombok.Builder;
import lombok.AllArgsConstructor;
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
public class Restaurante {

    private Long id;

    private Long idPropietario;

    private String direccion;

    private String estado;

    private String nit;

    private String nombre;

    private String telefono;

    private Long propietario;

}
