/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 19052403-5
 */
@Entity
public class Registro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ppu;
    private String fechaEntrada;
    private String horaEntrada;
    private String fechaSalida = null;
    private String horaSalida = null;
    private boolean retirado = false;
    private String RutPersonalIngreso;
    private String RutPersonalSalida = null;
    private Integer montoCancelado = 0;

    public Integer getMontoCancelado() {
        return montoCancelado;
    }

    public void setMontoCancelado(Integer montoCancelado) {
        this.montoCancelado = montoCancelado;
    }
       

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registro)) {
            return false;
        }
        Registro other = (Registro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Registro[ id=" + id + " ]";
    }

    public String getPpu() {
        return ppu;
    }

    public void setPpu(String ppu) {
        this.ppu = ppu;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public boolean isRetirado() {
        return retirado;
    }

    public void setRetirado(boolean retirado) {
        this.retirado = retirado;
    }

    public String getRutPersonalIngreso() {
        return RutPersonalIngreso;
    }

    public void setRutPersonalIngreso(String RutPersonalIngreso) {
        this.RutPersonalIngreso = RutPersonalIngreso;
    }

    public String getRutPersonalSalida() {
        return RutPersonalSalida;
    }

    public void setRutPersonalSalida(String RutPersonalSalida) {
        this.RutPersonalSalida = RutPersonalSalida;
    }
    
}
