package com.maftei.licenta.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class EchipamentService {

    @NotNull
    @Size(min = 2)
    private String nume;

    @NotNull
    @Column(unique = true)
    @Size(min = 2)
    private String serie;

    @NotNull
    @Size(min = 2)
    private String tip;

	public String getNume() {
        return this.nume;
    }

	public void setNume(String nume) {
        this.nume = nume;
    }

	public String getSerie() {
        return this.serie;
    }

	public void setSerie(String serie) {
        this.serie = serie;
    }

	public String getTip() {
        return this.tip;
    }

	public void setTip(String tip) {
        this.tip = tip;
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
        return nume;
    }
}
