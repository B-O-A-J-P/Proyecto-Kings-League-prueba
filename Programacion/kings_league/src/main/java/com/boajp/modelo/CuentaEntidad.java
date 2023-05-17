package com.boajp.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "CUENTAS", schema = "HR")
public class CuentasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_CUENTA")
    private int codCuenta;
    @Basic
    @Column(name = "USUARIO")
    private String usuario;
    @Basic
    @Column(name = "CONTRASENA")
    private String contrasena;
    @Basic
    @Column(name = "EMAIL")
    private String email;
    @ManyToOne
    @JoinColumn(name = "COD_PERFIL", referencedColumnName = "COD_PERFIL")
    private PermisosEntity permisosByCodPerfil;

    public int getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(int codCuenta) {
        this.codCuenta = codCuenta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CuentasEntity that = (CuentasEntity) o;

        if (codCuenta != that.codCuenta) return false;
        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;
        if (contrasena != null ? !contrasena.equals(that.contrasena) : that.contrasena != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codCuenta;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (contrasena != null ? contrasena.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public PermisosEntity getPermisosByCodPerfil() {
        return permisosByCodPerfil;
    }

    public void setPermisosByCodPerfil(PermisosEntity permisosByCodPerfil) {
        this.permisosByCodPerfil = permisosByCodPerfil;
    }
}
