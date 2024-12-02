/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastropoo.model;

/**
 *
 * @author joao_
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Classe PessoaFisicaRepo
public class PessoaFisicaRepo {
    private final List<PessoaFisica> pessoasFisicas = new ArrayList<>();

    // Método inserir
    public void inserir(PessoaFisica pessoa) {
        pessoasFisicas.add(pessoa);
    }

    // Método alterar
    public void alterar(PessoaFisica pessoa) {
        for (int i = 0; i < pessoasFisicas.size(); i++) {
            if (pessoasFisicas.get(i).getId() == pessoa.getId()) {
                pessoasFisicas.set(i, pessoa);
                return;
            }
        }
    }

    // Método excluir
    public void excluir(int id) {
        pessoasFisicas.removeIf(p -> p.getId() == id);
    }

    // Método obter
    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoa : pessoasFisicas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null; // Retorna null caso não encontre a pessoa
    }

    // Método obterTodos
    public List<PessoaFisica> obterTodos() {
        return new ArrayList<>(pessoasFisicas);
    }

    // Método persistir
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(pessoasFisicas);
        }
    }

    // Método recuperar
    @SuppressWarnings("unchecked")
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            List<PessoaFisica> recuperadas = (List<PessoaFisica>) ois.readObject();
            pessoasFisicas.clear();
            pessoasFisicas.addAll(recuperadas);
        }
    }
}
