package com.maftei.licenta.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class EchipamentProductie {

    @NotNull
    @Size(min = 2)
    private String nume;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Operatiune operatiune;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusEchipament status;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Material> material = new HashSet<Material>();

	public String getNume() {
        return this.nume;
    }

	public void setNume(String nume) {
        this.nume = nume;
    }

	public Operatiune getOperatiune() {
        return this.operatiune;
    }

	public void setOperatiune(Operatiune operatiune) {
        this.operatiune = operatiune;
    }

	public StatusEchipament getStatus() {
        return this.status;
    }

	public void setStatus(StatusEchipament status) {
        this.status = status;
    }

	public Set<Material> getMaterial() {
        return this.material;
    }

	public void setMaterial(Set<Material> material) {
        this.material = material;
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Version
    @Column(name = "version")
    private Integer version;

	public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }

	public Integer getVersion() {
        return this.version;
    }

	public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return  nume;
    }
}
