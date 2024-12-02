/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import cadastropoo.model.PessoaFisica;
import cadastropoo.model.PessoaFisicaRepo;
import cadastropoo.model.PessoaJuridica;
import cadastropoo.model.PessoaJuridicaRepo;
import java.io.IOException;

/**
 *
 * @author joao_
 */
public class CadastroPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
            
             PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

            
            repo1.inserir(new PessoaFisica(1, "Ana", "123.456.789-00", 25));
            repo1.inserir(new PessoaFisica(2, "Carlos", "987.654.321-00", 52));

            
            String arquivoPessoaFisica = "pessoasFisicas.dat";
            repo1.persistir(arquivoPessoaFisica);
            System.out.println("Dados de pessoas fisicas salvos no arquivo: " + arquivoPessoaFisica);

            
            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();

            
            repo2.recuperar(arquivoPessoaFisica);
            System.out.println("Dados recuperados do arquivo: " + arquivoPessoaFisica);

            
            System.out.println("Pessoas Fisicas recuperadas:");
            for (PessoaFisica pf : repo2.obterTodos()) {
                pf.exibir();
            }

            
             PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

            
            repo3.inserir(new PessoaJuridica(1, "XPTO Sales", "12.345.678/0001-90"));
            repo3.inserir(new PessoaJuridica(2, "XPTO Solutions", "98.765.432/0001-10"));

            
            String arquivoPessoaJuridica = "pessoasJuridicas.dat";
            repo3.persistir(arquivoPessoaJuridica);
            System.out.println("Dados de pessoas juridicas salvos no arquivo: " + arquivoPessoaJuridica);

            // Repositório de pessoas jurídicas (repo4)
            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();

            // Recuperar dados no repo4
            repo4.recuperar(arquivoPessoaJuridica);
            System.out.println("Dados recuperados do arquivo: " + arquivoPessoaJuridica);

            // Exibir dados de todas as pessoas jurídicas recuperadas
            System.out.println("Pessoas Juridicas recuperadas:");
            for (PessoaJuridica pj : repo4.obterTodos()) {
                pj.exibir();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro durante a execução: " + e.getMessage());
            e.printStackTrace();
        }
    
        
    }
    
}
