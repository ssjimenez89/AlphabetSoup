package com.gym.appointments.Model;

public class CoordenadasInput {

    int sr;
    int sc;
    int er;
    int ec;

    public CoordenadasInput() {
    }

    public CoordenadasInput(int sr, int sc, int er, int ec) {
        this.sr = sr;
        this.sc = sc;
        this.er = er;
        this.ec = ec;
    }

    public int getSr() {
        return sr;
    }

    public void setSr(int sr) {
        this.sr = sr;
    }

    public int getSc() {
        return sc;
    }

    public void setSc(int sc) {
        this.sc = sc;
    }

    public int getEr() {
        return er;
    }

    public void setEr(int er) {
        this.er = er;
    }

    public int getEc() {
        return ec;
    }

    public void setEc(int ec) {
        this.ec = ec;
    }
}
