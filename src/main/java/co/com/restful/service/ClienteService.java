package co.com.restful.service;

import co.com.restful.domain.Cliente;

import java.util.List;

public interface ClienteService {
    public List<Cliente> listaClientes();

    public Cliente listarPorDocumento(String numeroDocumento);

    public Long guardar(Cliente cliente);

    public Long actualizar(Cliente cliente);

    public Long eliminar(Long id);
}
