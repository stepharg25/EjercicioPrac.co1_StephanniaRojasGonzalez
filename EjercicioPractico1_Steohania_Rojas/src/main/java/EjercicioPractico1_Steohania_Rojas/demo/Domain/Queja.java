package EjercicioPractico1_Steohania_Rojas.demo.Domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "queja")
@Data
@Getter
@Setter
public class Queja {
    
    public enum Tipo {
        QUEJA, SUGERENCIA, CONSULTA
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre_cliente", length = 150)
    private String nombreCliente;
    
    @Column(name = "email", length = 200)
    private String email;
    
    @Column(name = "telefono", length = 30)
    private String telefono;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private Tipo tipo = Tipo.CONSULTA;
    
    @Column(name = "asunto", length = 200)
    private String asunto;
    
    @Column(name = "mensaje", columnDefinition = "TEXT", nullable = false)
    private String mensaje;
    
    @Column(name = "tratado", nullable = false)
    private Boolean tratado = false;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    // Constructor por defecto
    public Queja() {}
    
    // Getters y Setters manuales (por si Lombok falla)
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombreCliente() {
        return nombreCliente;
    }
    
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public Tipo getTipo() {
        return tipo;
    }
    
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    public String getAsunto() {
        return asunto;
    }
    
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public Boolean getTratado() {
        return tratado;
    }
    
    public void setTratado(Boolean tratado) {
        this.tratado = tratado;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}