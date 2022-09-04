package com.maftei.licenta.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Interventie {

    @NotNull
    @ManyToOne
    private Client client;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dataInceput;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dataSfarsit;

    @NotNull
    @ManyToOne
    private Angajat angajat;

    @NotNull
    @ManyToOne
    private Constatare constatare;

    @NotNull
    @ManyToOne
    private EchipamentService echipament;

    @NotNull
    @Size(max = 4000)
    private String descriereDefect;

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

	public Client getClient() {
        return this.client;
    }

	public void setClient(Client client) {
        this.client = client;
    }

	public Date getDataInceput() {
        return this.dataInceput;
    }

	public void setDataInceput(Date dataInceput) {
        this.dataInceput = dataInceput;
    }

	public Date getDataSfarsit() {
        return this.dataSfarsit;
    }

	public void setDataSfarsit(Date dataSfarsit) {
        this.dataSfarsit = dataSfarsit;
    }

	public Angajat getAngajat() {
        return this.angajat;
    }

	public void setAngajat(Angajat angajat) {
        this.angajat = angajat;
    }

	public Constatare getConstatare() {
        return this.constatare;
    }

	public void setConstatare(Constatare constatare) {
        this.constatare = constatare;
    }

	public EchipamentService getEchipament() {
        return this.echipament;
    }

	public void setEchipament(EchipamentService echipament) {
        this.echipament = echipament;
    }

	public String getDescriereDefect() {
        return this.descriereDefect;
    }

	public void setDescriereDefect(String descriereDefect) {
        this.descriereDefect = descriereDefect;
    }

    @Override
    public String toString() {
        return  descriereDefect;
    }
}
