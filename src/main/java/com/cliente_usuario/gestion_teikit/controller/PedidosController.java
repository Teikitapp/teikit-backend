package com.cliente_usuario.gestion_teikit.controller;

import com.cliente_usuario.gestion_teikit.exception.ResourceNotFoundException;
import com.cliente_usuario.gestion_teikit.model.*;
import com.cliente_usuario.gestion_teikit.model.Dto.DetallePedidoDto;
import com.cliente_usuario.gestion_teikit.model.Dto.PedidosDto;
import com.cliente_usuario.gestion_teikit.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "${frontend.api.url}")
@RestController
@RequestMapping("/api/pedido")
public class PedidosController {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PedidoRepositoryCustomer pedidoRepositoryCustomer;
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;
    @Autowired
    private CasilleroRepository casilleroRepository;

    private Pedido pedidosTem;


    @GetMapping("/listarPedidos")
    public List<Pedido> listarPedidos(){
        return pedidoRepository.findAll();
    }

    @PostMapping("/ingresarPedido")
    public Pedido guardarProducto(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @DeleteMapping("/eliminarPedido/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarPedido (@PathVariable Long id){
        Pedido pedido= pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El Pedido con ese ID no existe " + id));

        pedidoRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    /*@GetMapping("/actualizarPedido/{idUsuario}-{id}")
    public List<Pedido>  actualizarPedido (@PathVariable int idUsuario, @PathVariable int id){
        return pedidoRepository.actualizarStatus( idUsuario, id);
    }*/
    @PutMapping("/actualizarPedido/{idPedido}-{estado}")
    public ResponseEntity<Pedido>  actualizarPedido (@PathVariable Long idPedido, @PathVariable int estado){
        Pedido pedido = pedidoRepository.findById(idPedido)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con ese ID no existe " + idPedido));

        pedido.setStatus(estado);
        Pedido pedidoActualizado = pedidoRepository.save(pedido);
        //Long temId = (long) pedido.getCasillero();


        return ResponseEntity.ok(pedidoActualizado);
    }

   /* public  void  actualizarDetallePedido (Long id, Long idUsuario){
           detallePedidoRepository.findByStatus(id, idUsuario);

    }*/



    @GetMapping("/buscarPedidoPorId/{status}-{idCliente}")
    public List<Pedido> ejemplo (@PathVariable int status ,@PathVariable int idCliente){
        System.out.println(idCliente);
        return pedidoRepository.findByStatus( status, idCliente);

    }
    @GetMapping("/buscarPedidoEnProcesoYlistoRetiro/{idCliente}")
    public List<Pedido> ejemplo (@PathVariable int idCliente){
        System.out.println(idCliente);
        return pedidoRepository.findByStatus2( idCliente);

    }
    @PutMapping("/actualizarPagoPedido/{idPedido}-{idCompra}-{estadoCompra}")
    public ResponseEntity<Pedido>  actualizarPagoPedido (@PathVariable Long idPedido,@PathVariable Long idCompra, @PathVariable int estadoCompra){
        Pedido pedido = pedidoRepository.findById(idPedido)
                .orElseThrow(() -> new ResourceNotFoundException("El Pedido con ese ID no existe " + idPedido));

        pedido.setEstadoCompra(estadoCompra);
        pedido.setIdCompra(idCompra);
        pedido.setStatus(2);
        Pedido pedidoActualizado = pedidoRepository.save(pedido);

        return ResponseEntity.ok(pedidoActualizado);
    }

    @GetMapping("/listarPedidosYdetalle/{idCliente}")
    public List<PedidosDto> listarPedidosYdetalle(@PathVariable int idCliente){

        Date todayDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaActual = sdf.format(todayDate);
        String fechaTemp = "13/1/2025";

        try {
            PedidosDto dto = new PedidosDto();
            List<PedidosDto> listDto = new ArrayList<>();
            List<Pedido> list = new ArrayList<>();


            DetallePedidoDto dtoDetalle = new DetallePedidoDto();
            List<DetallePedidoDto> listDtoDetalle = new ArrayList<>();
            List<DetallePedido> detallePedido = new ArrayList<>();

            list = pedidoRepositoryCustomer.getPedidosYdetalle(idCliente, fechaActual);


            for (int i = 0; i < list.size() ; i++) {
                dto = new PedidosDto();
                listDtoDetalle = new ArrayList<>();
            dto.setId(list.get(i).getId());
            dto.setFechaIngresadoPedido(list.get(i).getFechaIngresadoPedido());
            dto.setFechaRetiraPedido(list.get(i).getFechaRetiraPedido());
            dto.setHoraRetiraPedido(list.get(i).getHoraRetiraPedido());
            dto.setLugarRetiraPedido(list.get(i).getLugarRetiraPedido());
            dto.setCasillero(list.get(i).getCasillero());
            dto.setStatus(list.get(i).getStatus());
            dto.setIdUsuario(list.get(i).getIdUsuario());
            dto.setEstadoCompra(list.get(i).getEstadoCompra());
            dto.setIdCompra(list.get(i).getIdCompra());
            dto.setIdCliente(list.get(i).getIdCliente());
            listDto.add(dto);

            detallePedido = detallePedidoRepository.findByPedidoUsuario(dto.getId(), dto.getIdUsuario());
                for (int j = 0; j < detallePedido.size() ; j++) {
                    //listDtoDetalle = new ArrayList<>();
                    dtoDetalle = new DetallePedidoDto();

                    dtoDetalle.setId(detallePedido.get(j).getId());
                    dtoDetalle.setCantidad(detallePedido.get(j).getCantidad());
                    dtoDetalle.setUnitPrice(detallePedido.get(j).getUnitPrice());
                    dtoDetalle.setNombreProducto(detallePedido.get(j).getNombreProducto());
                    dtoDetalle.setIdUsuario(detallePedido.get(j).getIdUsuario());
                    dtoDetalle.setIdCliente(detallePedido.get(j).getIdCliente());
                    dtoDetalle.setEstadoDetallePedido(detallePedido.get(j).getEstadoDetallePedido());
                    dtoDetalle.setIdPedido(detallePedido.get(j).getIdPedido());

                    listDtoDetalle.add(dtoDetalle);
                    listDto.get(i).setDPedido(listDtoDetalle);

                }
            }
            System.out.println(listDto);

            return listDto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
