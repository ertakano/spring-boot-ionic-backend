package br.erico.cursomc.services;

import br.erico.cursomc.domain.Pedido;
import br.erico.cursomc.services.exception.ObjectNotFoundException;
import br.erico.cursomc.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repo;

    public Pedido find(Integer id){
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())
        );
    }
}
