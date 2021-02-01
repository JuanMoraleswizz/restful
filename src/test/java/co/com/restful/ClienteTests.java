package co.com.restful;

import co.com.restful.controller.ClienteController;
import co.com.restful.domain.Cliente;
import co.com.restful.domain.TipoIdentificacion;
import co.com.restful.repository.ClienteRepository;
import co.com.restful.service.impl.ClienteServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class ClienteTests {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Mock
    private ClienteServiceImpl clienteServiceImpl;

    @InjectMocks
    private ClienteController clienteController;

    private List<Cliente> listaEsperados;
    private List<Cliente> listaEntrada;

    @Before
    public void setup(){
        listaEsperados = new ArrayList<>();
        Cliente cliente1 = Cliente.builder().id(1L).identificacion("1038125422")
                .primerNombre("juan").segundoNombre("david").primerApellido("Morales")
                .segundoApellido("Muñoz").tipoIdentificacion(TipoIdentificacion.builder().id(1).nombre("CC").build()).build();

        Cliente cliente12= Cliente.builder().id(2L).identificacion("1038125432")
                .primerNombre("jhoan").segundoNombre("david").primerApellido("Morales")
                .segundoApellido("Muñoz").tipoIdentificacion(TipoIdentificacion.builder().id(1).nombre("CC").build()).build();

        listaEsperados.add(cliente1);
        listaEsperados.add(cliente12);
        listaEntrada = listaEsperados;
    }


    @Test
    public void debeListarTodosLosClientesLLamadoDesdeElController() {

        //Arrangue
        Mockito.when(this.clienteServiceImpl.listaClientes())
                .thenReturn(listaEntrada);
        //Action
        List<Cliente> listaValoraciones = clienteController.listarClientes().getBody();
        //Assert
        Assert.assertEquals(listaValoraciones,listaEsperados);
    }


    @Test
    public void debeListarTodosCLientesLLamadoDesdeElBusiness() {

        //Arrangue
        Mockito.when(this.clienteRepository.findAll())
                .thenReturn(listaEntrada);
        //Action
        List<Cliente> listaValoraciones = clienteService.listaClientes();
        //Assert
        Assert.assertEquals(listaValoraciones,listaEsperados);
    }
    @Test
    public void debeListarTodasLasValoracionesDeUnCuestionarioDadoLLamadoDesdeLaApi() {

       /* //Arrangue
        Mockito.when(restTemplate.getForObject("http://localhost:9090",List<CuestionarioValoracion>))
                .thenReturn(listaEntrada);
        //Action
        List<CuestionarioValoracion> listaValoraciones = cuestionarioValoracionBusiness.listar(1);
        //Assert
        Assert.assertEquals(listaValoraciones,listaEsperados);*/
    }


}
