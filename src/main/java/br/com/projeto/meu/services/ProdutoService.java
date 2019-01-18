package br.com.projeto.meu.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.projeto.meu.domain.Categoria;
import br.com.projeto.meu.domain.Produto;
import br.com.projeto.meu.repositories.CategoriaRepository;
import br.com.projeto.meu.repositories.ProdutoRepository;
import br.com.projeto.meu.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repositorio;
	
	@Autowired
	private CategoriaRepository categoriaRepositorio;
	
	public Produto buscar(Integer id) {
		Optional<Produto> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linePerPage,String orderBy,String direction){
		List<Categoria> categorias = categoriaRepositorio.findAllById(ids);
		PageRequest pageRequest = PageRequest.of(page, linePerPage, Direction.valueOf(direction), orderBy);
		return repositorio.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}
}

