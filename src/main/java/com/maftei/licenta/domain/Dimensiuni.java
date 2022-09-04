package com.maftei.licenta.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Embeddable
public class Dimensiuni {

    @NotNull
    private Double latime;

    @NotNull
    private Double lungime;

	public Double getLatime() {
        return this.latime;
    }

	public void setLatime(Double latime) {
        this.latime = latime;
    }

	public Double getLungime() {
        return this.lungime;
    }

	public void setLungime(Double lungime) {
        this.lungime = lungime;
    }
}
