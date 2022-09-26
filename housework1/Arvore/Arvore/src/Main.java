/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @authores Matheus Aguiar e Arthur Delpupo
 */

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.nio.file.*;


public class Main {

  public static void main(String[] args) throws Exception {
    Arvore<Aluno> arvore = new Arvore<Aluno>();
    lerArquivo(arvore);
    
    Scanner menu = new Scanner(System.in);
    int opcao;
    
    do{
    
    // MENU
    System.out.print("##--Sistema Academico--##\n\n");
    System.out.print("|------------------------------------------------|\n");
    System.out.print("| Opção 1 - Exibir estatísticas                  |\n");
    System.out.print("| Opção 2 - Efetuar busca por matrícula          |\n");
    System.out.print("| Opção 3 - Excluir por matrícula                |\n");
    System.out.print("| Opção 4 - Incluir aluno                        |\n");
    System.out.print("| Opção 5 - Sair                                 |\n");
    System.out.print("|------------------------------------------------|\n");
    System.out.print("Digite uma opção: ");

    opcao = menu.nextInt();

    switch (opcao) {
      case 1:
        System.out.print("\nOpção Exibir estatísticas Selecionada\n\n");
        exibirEstatisticas(arvore);
        break;

      case 2:
        System.out.print("\nOpção Efetuar busca por matrícula Selecionada\n\n");
        Scanner scan = new Scanner(System.in);
        System.out.print("Insira a matricula que deseja buscar: ");
        int matricula = scan.nextInt();
        scan.close();
        buscarMatricula(matricula, arvore);
        break;

      case 3:
        System.out.print("\nOpção Excluir por matrícula Selecionada\n");
        //excluirMatricula(lerMatricula(), arvore);

        break;

      default:
        System.out.print("\nOpção Inválida!");
        break;

      case 4:
        incluirAluno(arvore);
        break;

      case 5:
        sairEmOrdem(arvore.getRaiz());
        System.out.print("\nAté logo!");
        menu.close();
        break;
    }
    
    }while(opcao != 5);
    
  }

  // BUSCA POR MATRICULA
  static void buscarMatricula(int matricula, Arvore<Aluno> arvore) {
    try {
      long tempoInicial = System. currentTimeMillis();        
      System.out.println(arvore.buscarElemento(arvore.getRaiz(), new No(new Aluno(matricula, "", 0))).getValor());
      long tempoFinal = System. currentTimeMillis();
      System.out.println("Tempo Total de busca na arvore em ms: " + (tempoFinal - tempoInicial));
        
    } catch (NullPointerException e) {
      System.out.println("Aluno não encontrado");
    }
  } // FIM METODO BUSCAR POR MATRICULA

  // EXCLUIR POR MATRICULA
  static void excluirMatricula(int matricula, Arvore<Aluno> arvore) {
    try {
      arvore.remover(new Aluno(matricula, "", 0));
      System.out.println("Matricula excluida com sucesso!\n");

    } catch (NullPointerException e) {
      System.out.println("Aluno não encontrado para exclusão");
    }
  } // FIM METODO EXCLUIR POR MATRICULA

  static void exibirEstatisticas(Arvore<Aluno> arvore) {
    System.out.println("- Total elementos: " + arvore.quantidade_nos(arvore.getRaiz()) + ".\n");
    System.out.println("- Altura da árvore: " + (arvore.nivel(arvore.getRaiz()) - 1) + ".\n");
    System.out.println("- Menor: " + arvore.menor_elemento(arvore.getRaiz()).getValor() + ".\n");
    System.out.println("- Maior: " + arvore.maior_elemento(arvore.getRaiz()).getValor() + ".\n");
    System.out.println("- Pior caso: " + arvore.pior_caso(arvore.getRaiz()) + " comparacões.\n");
  } // FIM METODO PARA EXIBIR ESTATISTICAS

  //LEITURA DE MATRICULA
  //static int lerMatricula() {
//    Scanner scan = new Scanner(System.in);
//    System.out.print("Insira a matricula que deseja buscar: ");
//    int matricula = scan.nextInt();
//    scan.close();
//    return matricula;
//  } // FIM METODO LER MATRICULA

  // PROCEDIMENTO DE INCLUIR ALUNO
  static void incluirAluno(Arvore<Aluno> arvore) {
    Scanner scan = new Scanner(System.in);
    Scanner scan1 = new Scanner(System.in);
    Scanner scan2 = new Scanner(System.in);

    System.out.print("\n matricula: ");
    int matricula = scan.nextInt();
    System.out.print("\nnome: ");
    String nome = scan1.nextLine();
    System.out.print("\nnota: ");
    int nota = scan2.nextInt();
    scan.close();

    arvore.adicionar(new Aluno(matricula, nome, nota));
  }

  // PROCEDIMENTO SAIR EM ORDEM FALTA FAZER ISSO
  public static void sairEmOrdem(No<Aluno> atual) {
    if (atual != null) {
      sairEmOrdem(atual.getEsquerda());
      escreverArquivo(atual.getValor().toString());
      sairEmOrdem(atual.getDireita());
    }
  }

  public static void escreverArquivo(String aluno) {
    try {
      FileWriter writer = new FileWriter("resultado.txt", true);
      writer.write(aluno + "\n");
      writer.close();
    } catch (Exception e) {
      System.out.println("arquivo nao enontrado");
    }
  }

  // LENDO O ARQUIVO E CRIANDO OS OBJETOS
  static void lerArquivo(Arvore<Aluno> arvore) {
    String line = "";
    String splitBy = ";";
    try {
      BufferedReader br = new BufferedReader(new FileReader("./entradaBalanceada10.txt"));
      
      String inutil = br.readLine();
      
      while ((line = br.readLine()) != null) {
        String[] st = line.split(splitBy);

        int matricula = Integer.valueOf(st[0]);
        String nome = st[1];
        int nota = Integer.valueOf(st[2]);

        arvore.adicionar(new Aluno(matricula, nome, nota));

      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  } // FIM METODO LER ARQUIVO

  // FIM DA MAIN
}