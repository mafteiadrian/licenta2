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
public class Angajat {

    @NotNull
    @Size(min = 2)
    private String nume;

    @NotNull
    @Size(min = 2)
    private String prenume;

    @NotNull
    @Size(min = 2)
    private String adresa;

    @NotNull
    @Size(min = 2)
    private String telefon;

	public String getNume() {
        return this.nume;
    }

	public void setNume(String nume) {
        this.nume = nume;
    }

	public String getPrenume() {
        return this.prenume;
    }

	public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

	public String getAdresa() {
        return this.adresa;
    }

	public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

	public String getTelefon() {
        return this.telefon;
    }

	public void setTelefon(String telefon) {
        this.telefon = telefon;
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
        return nume + " " + prenume ;
    }
}
