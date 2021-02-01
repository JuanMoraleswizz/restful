package co.com.restful.controller;

import co.com.restful.domain.Cliente;
import co.com.restful.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("obtiene todos los clientes de nuestra base de datos")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Cliente>> listarClientes(){
        List<Cliente> listaClientes = new ArrayList<>();
         try {
             listaClientes = clienteService.listaClientes();
         }catch (Exception ex){
            return new ResponseEntity<>(listaClientes, HttpStatus.INTERNAL_SERVER_ERROR);
         }
         return new ResponseEntity<>(listaClientes, HttpStatus.OK);
    }

    @GetMapping(value = "/{identificacion}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("obtiene un cliente por el numero de identificacion")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Cliente> obtenerCliente(@ApiParam(value = "el numero de identificacion del cliente", example = "1038125422", required = true)
                                                      @PathVariable("identificacion") String identificacion){
        Cliente cliente = null ;
        try{
            cliente = clienteService.listarPorDocumento(identificacion);
        }catch (Exception exception){
            return  new ResponseEntity<>(cliente, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping(value = "/" , consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("guarda un cliente en la base datos")
    @ApiResponse(code = 200, message = "OK")

    public ResponseEntity<Long> guardar(@RequestBody Cliente cliente){
        Long resultado = 0L;
        try {
            resultado = clienteService.guardar(cliente);
        }catch (Exception exception){
            return new ResponseEntity<>(resultado,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Actualiza los datos del cliente")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Long> actualizar(@RequestBody Cliente cliente){
        Long resultado = 0L;
        try {
            resultado = clienteService.actualizar(cliente);
        }catch (Exception exception){
            return  new ResponseEntity<>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity(resultado, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("elimina un cliente pasando el id del cliente")
    public ResponseEntity<Long> eliminar(@ApiParam(value = "se requiere el id del cliente ", required = true, example = "1")
                                             @PathVariable("id") Long id){
        Long resultado = 0L;
        try {
            resultado = clienteService.eliminar(id);
        }catch (Exception exception){
            return  new ResponseEntity<>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<>(resultado, HttpStatus.OK);
    }

}
