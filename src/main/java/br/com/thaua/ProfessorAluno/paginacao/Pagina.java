package br.com.thaua.ProfessorAluno.paginacao;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class Pagina<T> {
    private List<T> conteudo;
    private int paginaAtual;
    private int totalPaginas;
    private int itensPorPagina;
    private Long totalItens;

    public Pagina(Page<T> page)
    {
        conteudo = page.getContent();
        paginaAtual = page.getNumber();
        totalPaginas = page.getTotalPages();
        itensPorPagina = page.getSize();
        totalItens = page.getTotalElements();
    }
}
