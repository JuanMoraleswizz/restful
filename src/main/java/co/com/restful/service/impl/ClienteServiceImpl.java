package co.com.restful.service.impl;

import co.com.restful.domain.Cliente;
import co.com.restful.repository.ClienteRepository;
import co.com.restful.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listaClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente listarPorDocumento(String numeroDocumento) {
        return clienteRepository.findByIdentificacion(numeroDocumento).orElse(null);
    }

    @Override
    public Long guardar(Cliente cliente) {
        return clienteRepository.save(cliente).getId();
    }

    @Override
    public Long actualizar(Cliente cliente) {
        return clienteRepository.save(cliente).getId();
    }

    @Override
    public Long eliminar(Long id) {
         clienteRepository.deleteById(id);
         return  1L;
    }

}
