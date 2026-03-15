/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Scanner;

import colecao.IColecao;
import listaencadeada.*;

/**
 *
 * @author victoriocarvalho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Instanciando uma lista com Object
        IColecao<Aluno> l;
        l = new ListaEncadeada<Aluno>();

        Aluno a;
        int mat, nota, opcao;
        String nome;

        Scanner scanner = new Scanner(System.in);

        try {

            do {

                System.out.println("\n1 - Adicionar aluno");
                System.out.println("2 - Pesquisar aluno");
                System.out.println("3 - Remover aluno");
                System.out.println("4 - Imprimir lista");
                System.out.println("0 - Sair");

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch(opcao){

                    case 1:

                        System.out.println("Digite a matricula do aluno");
                        mat = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Digite o nome do aluno");
                        nome = scanner.nextLine();

                        System.out.println("Digite a nota do aluno");
                        nota = scanner.nextInt();

                        a = new Aluno(mat, nome, nota);
                        l.adicionar(a);

                        break;


                    case 2:

                        System.out.println("Digite o nome do aluno a ser procurado");
                        nome = scanner.nextLine();

                        a = l.pesquisar(new Aluno(0,nome,0));

                        if (a==null)
                            System.out.println("Aluno não existe");
                        else
                            System.out.println("Aluno encontrado " + a);

                        break;


                    case 3:

                        System.out.println("Digite o nome do aluno a ser removido");
                        nome = scanner.nextLine();

                        boolean removido = l.remover(new Aluno(0,nome,0));

                        if(removido)
                            System.out.println("Aluno removido");
                        else
                            System.out.println("Aluno não encontrado");

                        break;


                    case 4:

                        System.out.println("Lista de alunos:");
                        System.out.println(l);

                        break;

                }

            }while(opcao!=0);

            scanner.close();

        } catch (Exception e) {

            scanner.close();
            System.out.println("ERRO! " + e.getMessage());

        }

    }
}