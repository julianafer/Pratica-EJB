package com.gugawag.pdist.ejbs;

import com.gugawag.pdist.model.Mensagem;
import com.gugawag.pdist.model.Usuario;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Stateless(name = "mensagemService")
@Remote
public class MensagemService {
    @EJB
    private UsuarioDAO usuarioDao;

    @EJB
    private MensagemDAO mensagemDao;

    public List<Mensagem> listar() {
        return mensagemDao.listar();
    }

    public void inserir(long id, String mensagem) {
        Mensagem novaMensagem = new Mensagem(id,mensagem);
        if(mensagem.equals("merda") || mensagem.equals("carambolas"))
            throw new RuntimeException("Palavrão não é permitido no nosso sistema!");
        mensagemDao.inserir(novaMensagem);
    }
}
