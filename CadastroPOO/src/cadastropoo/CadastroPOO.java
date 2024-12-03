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
import java.util.Scanner;

/**
 *
 * @author joao_
 */
public class CadastroPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Repositórios
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        int opcao;
        do {
            // Menu de opções
            System.out.println("\n--- Menu ---");
            System.out.println("1. Incluir");
            System.out.println("2. Alterar");
            System.out.println("3. Excluir");
            System.out.println("4. Exibir pelo ID");
            System.out.println("5. Exibir todos");
            System.out.println("6. Salvar dados");
            System.out.println("7. Recuperar dados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1: // Incluir
                    System.out.print("Tipo (1 - Física, 2 - Jurídica): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    if (tipo == 1) {
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine();
                        repoFisica.inserir(new PessoaFisica(id, nome, cpf, idade));
                    } else if (tipo == 2) {
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CNPJ: ");
                        String cnpj = scanner.nextLine();
                        repoJuridica.inserir(new PessoaJuridica(id, nome, cnpj));
                    }
                    break;

                case 2: // Alterar
                    System.out.print("Tipo (1 - Física, 2 - Jurídica): ");
                    tipo = scanner.nextInt();
                    scanner.nextLine();

                    if (tipo == 1) {
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        PessoaFisica pf = repoFisica.obter(id);
                        if (pf != null) {
                            System.out.println("Dados atuais: ");
                            pf.exibir();
                            System.out.print("Novo Nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("Novo CPF: ");
                            String cpf = scanner.nextLine();
                            System.out.print("Nova Idade: ");
                            int idade = scanner.nextInt();
                            scanner.nextLine();
                            repoFisica.alterar(new PessoaFisica(id, nome, cpf, idade));
                        } else {
                            System.out.println("Pessoa Física não encontrada!");
                        }
                    } else if (tipo == 2) {
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        PessoaJuridica pj = repoJuridica.obter(id);
                        if (pj != null) {
                            System.out.println("Dados atuais: ");
                            pj.exibir();
                            System.out.print("Novo Nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("Novo CNPJ: ");
                            String cnpj = scanner.nextLine();
                            repoJuridica.alterar(new PessoaJuridica(id, nome, cnpj));
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada!");
                        }
                    }
                    break;

                case 3: // Excluir
                    System.out.print("Tipo (1 - Física, 2 - Jurídica): ");
                    tipo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    if (tipo == 1) {
                        repoFisica.excluir(id);
                        System.out.println("Pessoa Física removida!");
                    } else if (tipo == 2) {
                        repoJuridica.excluir(id);
                        System.out.println("Pessoa Jurídica removida!");
                    }
                    break;

                case 4: // Exibir pelo ID
                    System.out.print("Tipo (1 - Física, 2 - Jurídica): ");
                    tipo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    if (tipo == 1) {
                        PessoaFisica pf = repoFisica.obter(id);
                        if (pf != null) {
                            pf.exibir();
                        } else {
                            System.out.println("Pessoa Física não encontrada!");
                        }
                    } else if (tipo == 2) {
                        PessoaJuridica pj = repoJuridica.obter(id);
                        if (pj != null) {
                            pj.exibir();
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada!");
                        }
                    }
                    break;

                case 5: // Exibir todos
                    System.out.print("Tipo (1 - Física, 2 - Jurídica): ");
                    tipo = scanner.nextInt();
                    scanner.nextLine();

                    if (tipo == 1) {
                        for (PessoaFisica pf : repoFisica.obterTodos()) {
                            pf.exibir();
                        }
                    } else if (tipo == 2) {
                        for (PessoaJuridica pj : repoJuridica.obterTodos()) {
                            pj.exibir();
                        }
                    }
                    break;

                case 6: // Salvar dados
                    System.out.print("Prefixo do arquivo: ");
                    String prefixo = scanner.nextLine();
                    try {
                        repoFisica.persistir(prefixo + ".fisica.bin");
                        repoJuridica.persistir(prefixo + ".juridica.bin");
                        System.out.println("Dados salvos com sucesso!");
                    } catch (IOException e) {
                        System.err.println("Erro ao salvar os dados: " + e.getMessage());
                    }
                    break;

                case 7: // Recuperar dados
                    System.out.print("Prefixo do arquivo: ");
                    prefixo = scanner.nextLine();
                    try {
                        repoFisica.recuperar(prefixo + ".fisica.bin");
                        repoJuridica.recuperar(prefixo + ".juridica.bin");
                        System.out.println("Dados recuperados com sucesso!");
                    } catch (IOException | ClassNotFoundException e) {
                        System.err.println("Erro ao recuperar os dados: " + e.getMessage());
                    }
                    break;

                case 0: // Sair
                    System.out.println("Finalizando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

}
