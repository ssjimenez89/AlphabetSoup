package com.gym.appointments.Input;

public class MensajeInput extends JsonInput {
    String mensaje;

    public MensajeInput() {
    }

    public MensajeInput(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
