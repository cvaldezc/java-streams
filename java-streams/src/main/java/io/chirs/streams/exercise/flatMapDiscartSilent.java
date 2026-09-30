package io.chirs.streams.exercise;

import io.chirs.streams.model.Servidor;

import java.util.List;

public class flatMapDiscartSilent {

    /*
    * Tienes una List<Servidor> servidores. Cada servidor tiene un método Optional<Conexion> getConexionActiva(),
    * el cual devuelve un Optional vacío si el servidor está caído. La clase Conexion expone un método String getDireccionIp().
    * Tu objetivo es obtener una List<String> plana que contenga únicamente las direcciones IP de los servidores que están
    * online (los que tienen una conexión presente). Cero comprobaciones de nulos (!= null) y cero bloques if con .isPresent().
    * Usa el flujo para descartar automáticamente los caídos.
     */
    public static void main(String[] args) {
        var srv1 = new Servidor(new Servidor.Conexion("10"));
        var srv2 = new Servidor(new Servidor.Conexion("20"));
        var srv3 = new Servidor(null);
        var srv4 = new Servidor(new Servidor.Conexion("30"));
        var srv5 = new Servidor(null);
        var servidores = List.of(srv1, srv2, srv3, srv4, srv5);

        var isConnect = servidores.stream()
                .flatMap(srv -> srv.getConexionActiva().stream())
                .map(Servidor.Conexion::getDireccionIp)
                .toList();

        isConnect.forEach(System.out::println);
    }
}
