/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Arthur Delpupo e Matheus Aguiar
 */
public class Aluno implements Comparable<Aluno> {
    private int matricula;
    private String nome;
    private int nota;
  
    public Aluno(int matricula, String nome, int nota){
      this.matricula = matricula;
      this.nome = nome;
      this.nota = nota;    
    }
  
    @Override
    public String toString(){
      return matricula+";"+nome+";"+nota;    
    }
    
    public int getMatricula(){
      return matricula;
    }
    
    @Override
    public int compareTo(Aluno a){
      if (this.matricula == a.matricula)
        return 0;
      else
        if (this.matricula > a.matricula)
          return 1;
        else
          return -1;
    }
    
  }

