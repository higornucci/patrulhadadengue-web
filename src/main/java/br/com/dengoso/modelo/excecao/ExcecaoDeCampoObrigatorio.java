package br.com.dengoso.modelo.excecao;

import java.util.ArrayList;
import java.util.List;

public final class ExcecaoDeCampoObrigatorio extends Exception {

    private final List<String> erros = new ArrayList<String>();

    public ExcecaoDeCampoObrigatorio() {
    }

    private void inserir(String msg) {
        erros.add(msg);
    }

    private boolean possuiErro() {
        return !erros.isEmpty();
    }

    public List<String> getErros() {
        return erros;
    }

    private ExcecaoDeCampoObrigatorio quando(boolean condicao, String mensagem) {
        if (condicao) {
            inserir(mensagem);
        }
        return this;
    }

    public void entaoDispara() throws ExcecaoDeCampoObrigatorio {
        if (!erros.isEmpty()) {
            String mensagemDeErro = "";
            for (String mensagem : erros) {
                mensagemDeErro = mensagemDeErro + " - " + mensagem;
            }
            throw this;
        }
    }

    public ExcecaoDeCampoObrigatorio quandoNulo(Object obj, String mensagem) {
        quando(obj == null, mensagem);
        return this;
    }

    public ExcecaoDeCampoObrigatorio quandoZero(Double valor, String mensagem) {
        quandoNulo(valor, mensagem);
        if (!possuiErro()) {
            quando(valor == 0, mensagem);
        }
        return this;
    }
}
