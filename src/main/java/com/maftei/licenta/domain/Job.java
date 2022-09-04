package com.maftei.licenta.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Job {

    @NotNull
    @ManyToOne
    private Client client;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dataPrimirii;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dataFinalizarii;

    @Embedded
    private Dimensiuni dimensiuni;

    @NotNull
    @ManyToOne
    private Material material;

    @NotNull
    @ManyToOne
    private Angajat responsabil;

    @NotNull
    @ManyToOne
    private EchipamentProductie echipament;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusComanda statusJob;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipFinisare tipFinisare;

	public Client getClient() {
        return this.client;
    }

	public void setClient(Client client) {
        this.client = client;
    }

	public Date getDataPrimirii() {
        return this.dataPrimirii;
    }

	public void setDataPrimirii(Date dataPrimirii) {
        this.dataPrimirii = dataPrimirii;
    }

	public Date getDataFinalizarii() {
        return this.dataFinalizarii;
    }

	public void setDataFinalizarii(Date dataFinalizarii) {
        this.dataFinalizarii = dataFinalizarii;
    }

	public Dimensiuni getDimensiuni() {
        return this.dimensiuni;
    }

	public void setDimensiuni(Dimensiuni dimensiuni) {
        this.dimensiuni = dimensiuni;
    }

	public Material getMaterial() {
        return this.material;
    }

	public void setMaterial(Material material) {
        this.material = material;
    }

	public Angajat getResponsabil() {
        return this.responsabil;
    }

	public void setResponsabil(Angajat responsabil) {
        this.responsabil = responsabil;
    }

	public EchipamentProductie getEchipament() {
        return this.echipament;
    }

	public void setEchipament(EchipamentProductie echipament) {
        this.echipament = echipament;
    }

	public StatusComanda getStatusJob() {
        return this.statusJob;
    }

	public void setStatusJob(StatusComanda statusJob) {
        this.statusJob = statusJob;
    }

	public TipFinisare getTipFinisare() {
        return this.tipFinisare;
    }

	public void setTipFinisare(TipFinisare tipFinisare) {
        this.tipFinisare = tipFinisare;
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

}
