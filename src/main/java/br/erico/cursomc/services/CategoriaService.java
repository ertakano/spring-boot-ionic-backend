package br.erico.cursomc.services;

import br.erico.cursomc.domain.Categoria;
import br.erico.cursomc.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.erico.cursomc.repositories.CategoriaRepository;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())
        );
    }

    public Categoria insert(Categoria obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Categoria update(Categoria obj){
        find(obj.getId());
        return repo.save(obj);
    }
}
