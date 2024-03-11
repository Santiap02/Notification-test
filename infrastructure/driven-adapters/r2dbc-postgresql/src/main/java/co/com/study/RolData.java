package co.com.study;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("tbl_rol")
public class RolData {
    @Id
    @Column("id")
    private Long id;

    @Column("descripcion")
    private String descripcion;

    @Column("estado")
    private String estado;

    @Column("nombre")
    private String nombre;

}
