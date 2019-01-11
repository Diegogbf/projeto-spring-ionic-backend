package br.com.projeto.meu.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.projeto.meu.domain.Cliente;
import br.com.projeto.meu.domain.Cliente;
import br.com.projeto.meu.dto.ClienteDTO;
import br.com.projeto.meu.repositories.ClienteRepository;
import br.com.projeto.meu.services.exceptions.DataIntegrityException;
import br.com.projeto.meu.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repositorio;
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj,obj);
		return repositorio.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repositorio.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um cliente que possui pedidos");
		}
	}

	public List<Cliente> findAll() {
		return repositorio.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linePerPage,String orderBy,String direction) {
		PageRequest pageRequest = PageRequest.of(page, linePerPage, Direction.valueOf(direction), orderBy);
		return repositorio.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
}
