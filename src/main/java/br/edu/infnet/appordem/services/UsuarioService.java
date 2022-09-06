package br.edu.infnet.appordem.services;

import br.edu.infnet.appordem.model.domain.Usuario;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioService {

    private static Map<String, Usuario> usuarioMap = new HashMap<>();
    private static Long id = 1L;

    public void incluir(Usuario usuario) {
        usuario.setId(id++);
        usuarioMap.put(usuario.getEmail(), usuario);
        AppImpressao.relatorio("Incluído o usuário: " + usuario.getNome(), usuario);
    }

    public Collection<Usuario> obterLista() {
        return usuarioMap.values();
    }

    public Usuario obterPorEmail(String email) {
        return usuarioMap.get(email);
    }

    public void atualizar(String email, Usuario usuario) {
        usuarioMap.put(email, usuario);
        AppImpressao.relatorio("Atualizado o usuário: " + usuario.getNome(), usuario);
    }

    public Usuario validar(String email, String senha) {
        Usuario usuario = obterPorEmail(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            ;
            return usuario;
        }
        return null;
    }

    public void excluir(String email) {
        usuarioMap.remove(email);
    }
}
