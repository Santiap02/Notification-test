package co.com.study;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter

@Table("tbl_usuario")
public class UsuarioData {
    @Id
    @Column("id")
    private Long id;

    @Column("apellido")
    private String apellido;

    @Column("clave")
    private String clave;

    @Column("email")
    private String email;

    @Column("estado")
    private String estado;

    @Column("nombre")
    private String nombre;

    @Column("numero_documento")
    private Long numeroDocumento;

    @Column("telefono")
    private String telefono;

    @Column("tipo_documento")
    private String tipoDocumento;

    @Column("rol_id")
    private Long idRol;

}
