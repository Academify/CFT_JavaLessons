package br.cefet.renata.trabalhoBim1.Principal;

import br.cefet.renata.trabalhoBim1.dao.AlunoDao;
import br.cefet.renata.trabalhoBim1.dao.DaoException;
import br.cefet.renata.trabalhoBim1.entidade.Aluno;
import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {

        // início da criação dos objetos alunos
       
        Aluno aluno1 = new Aluno();

        aluno1.setNmAluno("Maria");
        aluno1.setCpfAluno("12345678900");
        aluno1.setRgAluno("12345678");
        aluno1.setFoneAluno("123456789");

        Aluno aluno2 = new Aluno();

        aluno2.setNmAluno("Juca");
        aluno2.setCpfAluno("98765432100");
        aluno2.setRgAluno("87654321");
        aluno2.setFoneAluno("987654321");
        
        Aluno aluno3 = new Aluno();

        aluno3.setNmAluno("Pabllo");
        aluno3.setCpfAluno("00000000");
        aluno3.setRgAluno("00000000");
        aluno3.setFoneAluno("00000000");

        //fim da criação dos objetos alunos
        
        try {

            AlunoDao aD = new AlunoDao();
            
            List<Aluno> listaAlunos = new ArrayList<>();


            //início da inserção dos objetos alunos na tabela do banco de dados
           
            aD.inserir(aluno1);
            aD.inserir(aluno2);
            aD.inserir(aluno1);
            aD.inserir(aluno2);
            
            System.out.println("Inserção de alunos completa!");
            
            listaAlunos = aD.listarAlunos();
            
            System.out.println("\nListagem de Alunos: ");
            for (int i = 0; i < listaAlunos.size(); i++) {
                System.out.println(listaAlunos.get(i).getNmAluno());
            }
            
            // fim da inserção dos objetos alunos na tabela do banco de dados
            
            Aluno alunoTeste = new Aluno();

            // início da consulta por código
            
            System.out.println("\nConsulta por aluno de código 1:");

            alunoTeste = aD.consultarPorCdAluno(1);

            if (alunoTeste != null) {
                System.out.println("\nCódigo: " + alunoTeste.getCdAluno());
                System.out.println("Nome: " + alunoTeste.getNmAluno());
                System.out.println("CPF: " + alunoTeste.getCpfAluno());
                System.out.println("Fone: " + alunoTeste.getFoneAluno());
                System.out.println("RG: " + alunoTeste.getRgAluno());
            } else {
                System.out.println("\nAluno de código 1 não encontrado");
            }

            //fim da consulta por código
            
            //início da exclusão do aluno de código 1
            
            aD.excluirAluno(1);
            
            System.out.println("\nExclusão do aluno de código 1.");
            
            listaAlunos = aD.listarAlunos();
            
            System.out.println("\nListagem de Alunos: ");
            for (int i = 0; i < listaAlunos.size(); i++) {
                System.out.println(listaAlunos.get(i).getNmAluno());
            }

            //fim da exclusão do aluno de código 1
            
            //início da consulta por nome 
            
            listaAlunos = aD.consultarPorNmAluno("Maria");

            if (listaAlunos.size()>0){
                System.out.println("\nBusca por alunos de nome Maria: ");
                for (int i = 0; i < listaAlunos.size(); i++) {
                    System.out.println(listaAlunos.get(i).getNmAluno());
                }
            }

            //fim da consulta por nome  
            
            listaAlunos = aD.listarAlunos();
            
            System.out.println("\nListagem de Alunos: ");
            for (int i = 0; i < listaAlunos.size(); i++) {
                System.out.println(listaAlunos.get(i).getNmAluno());
            }
            
            //início da alteração do aluno de código 2
            
            System.out.println("\nAlteração do aluno de código 2 (Juca) por Pabllo. ");

            aD.alterarAluno(2, aluno3);
            
            // fim da alteração do aluno de código 2
            
            // listagem de alunos para mostrar a alteração no aluno de código 2
            
            listaAlunos = aD.listarAlunos();
            
            System.out.println("\nListagem de Alunos: ");
            for (int i = 0; i < listaAlunos.size(); i++) {
                System.out.println(listaAlunos.get(i).getNmAluno());
            }
            
            // fim da listagem de alunos
            
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}