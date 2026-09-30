package io.chirs.streams.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@AllArgsConstructor
public class Servidor {

    private Conexion conexion;

    public Optional<Conexion> getConexionActiva() {
        return Optional.ofNullable(conexion);
    }

    @Data
    @AllArgsConstructor
    public static class Conexion {
        private String direccionIp;
    }
}