package br.erico.cursomc.services;

import br.erico.cursomc.domain.Categoria;
import br.erico.cursomc.domain.Cliente;
import br.erico.cursomc.exception.ObjectNotFoundException;
import br.erico.cursomc.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())
        );
    }

}
