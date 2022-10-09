package br.edu.infnet.appordem.model.service;

import br.edu.infnet.appordem.model.exceptions.CampoObrigatorioException;
import br.edu.infnet.appordem.model.exceptions.EntidadeExistenteException;
import br.edu.infnet.appordem.model.domain.Usuario;
import br.edu.infnet.appordem.model.repository.UsuarioRepository;
import br.edu.infnet.appordem.model.test.AppImpressao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public void incluir(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new EntidadeExistenteException(String.format("Já existe um usuário com e-mail %s", usuario.getEmail()));
        }
        try {
            usuarioRepository.save(usuario);
            AppImpressao.relatorio("Atualizado o usuário: " + usuario.getNome(), usuario);
        } catch (CampoObrigatorioException e) {
            System.out.println("[ERRO] - USUÁRIO: " + e.getMessage());
        }
    }

    public Collection<Usuario> obterLista() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obterPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> obterPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public void atualizar(Long id, Usuario usuario) {
        Optional<Usuario> usuarioParaAtualizar = usuarioRepository.findById(id);
        if (usuarioParaAtualizar.isEmpty())
            throw new EntityNotFoundException(String.format("O usuário de id %s não foi encontrado.", id));

        try {
            BeanUtils.copyProperties(usuario, usuarioParaAtualizar.get(), "id");
            usuarioRepository.save(usuarioParaAtualizar.get());
            AppImpressao.relatorio("Atualizado o usuário: " + usuario.getNome(), usuario);
        } catch (CampoObrigatorioException e) {
            System.out.println("[ERRO] - USUÁRIO: " + e.getMessage());
        }
    }

    public Usuario validar(String email, String senha) {
        Optional<Usuario> usuario = obterPorEmail(email);
        if (usuario.isPresent() && usuario.get().getSenha().equals(senha)) {
            return usuario.get();
        }
        return null;
    }

    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }
}
