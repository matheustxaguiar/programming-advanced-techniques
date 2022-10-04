/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Matheus Aguiar
 */
import java.util.ArrayList;

public class Arvore<T extends Comparable> {
  No<T> raiz;

  public Arvore() {
    this.raiz = null;
  }

  // METODO QUE RETORNA A RAIZ
  public No<T> getRaiz() {
    return raiz;
  }

  
 // METODO QUE ADICIONA UM NO A ARVORE
  public void adicionar(T novoValor){
        No<T> novoNo = new No<T>(novoValor);
        if(this.raiz==null)
            this.raiz= novoNo;
        else
            this.raiz = adicionarNaArvore(this.raiz, novoNo);
    }
  

  protected No<T> adicionarNaArvore(No<T> atual, No<T> novoElemento) {
      if(novoElemento.getValor().compareTo(atual.getValor()) < 0){
          if (atual.getEsquerda() == null) {
              atual.setEsquerda(novoElemento);
          }
          else{
              atual.setEsquerda(adicionarNaArvore(atual.getEsquerda(), novoElemento));
          }
      }
      else{
      if (atual.getDireita() == null){
          atual.setDireita(novoElemento);
      } else {
          atual.setDireita(adicionarNaArvore(atual.getDireita(), novoElemento));  
        }
      }
      return atual;
  }

  
  
  
  
  
//  // METODO QUE ADICIONA UM NO A ARVORE
//  public void adicionarElemento(T novoValor){
//        No<T> novoNo = new No<T>(novoValor);
//        if(this.raiz==null)
//            this.raiz= novoNo;
//        else
//            adicionar(novoNo);
//    }
//  
//  
//  
//  public void adicionar(No<T> novoElemento) {
//    if (raiz == null) {
//      this.raiz = novoElemento;
//    } else {
//      No<T> atual = this.raiz;
//      while (true) {
//        if (novoElemento.getValor().compareTo(atual.getValor()) == -1) {
//          if (atual.getEsquerda() != null) {
//            atual = atual.getEsquerda();
//          } else {
//            atual.setEsquerda(novoElemento);
//            break;
//          }
//        } else { // se for maior ou igual
//          if (atual.getDireita() != null) {
//            atual = atual.getDireita();
//          } else {
//            atual.setDireita(novoElemento);
//            break;
//          }
//        }
//      }
//    }
//  }

  // METODO QUE IMPRIME EM ORDEM OS NOS
  public void emOrdem(No<T> atual) {
    if (atual != null) {
      emOrdem(atual.getEsquerda());
      System.out.println(atual.getValor());
      emOrdem(atual.getDireita());
    }
  }

  // METODO QUE IMPRIME EM NIVEL OS NOS
  public void emNivel(No<T> atual) {
    ArrayList<No<T>> nos = new ArrayList<No<T>>();
    nos.add(atual);

    while (!(nos.isEmpty())) {
      System.out.println(nos.get(0).getValor().toString());
      if (nos.get(0).getEsquerda() != null) {
        nos.add(nos.get(0).getEsquerda());
      }
      if (nos.get(0).getDireita() != null) {
        nos.add(nos.get(0).getDireita());
      }
      nos.remove(0);
    }
  }

//  // METODO QUE BUSCA UM ELEMENTO NA ARVORE
//  public No<T> buscarElemento(No<T> atual, No<T> valor) {
//      System.out.println("Atual:");
//      System.out.println(atual.getValor().toString());
//      System.out.println("\nValor:");
//      System.out.println(valor.getValor().toString());
//    // Condicao parada
//    if (valor.getValor().compareTo(atual.getValor()) != 0) {
//      // Valor menor
//      if (valor.getValor().compareTo(atual.getValor()) == -1) {
//        buscarElemento(atual.getEsquerda(), valor);
//      }
//      if (valor.getValor().compareTo(atual.getValor()) == 1) {
//        buscarElemento(atual.getDireita(), valor);
//      }
//    }
//    return atual;
//  }



  // METODO QUE BUSCA UM ELEMENTO NA ARVORE
  public No<T> buscarElemento(No<T> atual, No<T> valor) {
      while(valor.getValor().compareTo(atual.getValor()) != 0){
          if(valor.getValor().compareTo(atual.getValor()) == -1){
              atual = atual.getEsquerda();
          }
          else {
            atual = atual.getDireita();
          }
      }
      return atual;
  }




  // METODO QUE REMOVE UM ELEMENTO NA ARVORE
  public boolean remover(T valor) {
    // buscar o elemento na árvore
    No<T> atual = this.raiz;
    No<T> paiAtual = null;

    while (atual != null) {
      if ((atual.getValor().compareTo(valor)) == 0) {
        break;
      } else if (valor.compareTo(atual.getValor()) == -1) {
        paiAtual = atual;
        atual = atual.getEsquerda();
      } else {
        paiAtual = atual;
        atual = atual.getDireita();
      }
    }
    // verifica se existe o elemento
    if (atual != null) {
      // elemento tem 2 filhos ou elemento tem somente filho à direita
      if (atual.getDireita() != null) {

        No<T> substituto = atual.getDireita();
        No<T> paiSubstituto = atual;
        while (substituto.getEsquerda() != null) {
          paiSubstituto = substituto;
          substituto = substituto.getEsquerda();
        }
        substituto.setEsquerda(atual.getEsquerda());
        if (paiAtual != null) {
          if (atual.getValor().compareTo(paiAtual.getValor()) == -1) {
            paiAtual.setEsquerda(substituto);
          } else {
            paiAtual.setDireita(substituto);
          }
        } else { // se não tem paiAtual, então é a raiz
          this.raiz = substituto;
          paiSubstituto.setEsquerda(null);
          this.raiz.setDireita(paiSubstituto);
          this.raiz.setEsquerda(atual.getEsquerda());
        }

        // removeu o elemento da árvore
        if (substituto.getValor().compareTo(paiSubstituto.getValor()) == -1) {
        } else {
          paiSubstituto.setDireita(null);
        }

      } else if (atual.getEsquerda() != null) { // tem filho só à esquerda
        No<T> substituto = atual.getEsquerda();
        No<T> paiSubstituto = atual;
        while (substituto.getDireita() != null) {
          paiSubstituto = substituto;
          substituto = substituto.getDireita();
        }
        if (paiAtual != null) {
          if (atual.getValor().compareTo(paiAtual.getValor()) == -1) {
            paiAtual.setEsquerda(substituto);
          } else {
            paiAtual.setDireita(substituto);
          }
        } else { // se for a raiz
          this.raiz = substituto;
        }

        // removeu o elemento da árvore
        if (substituto.getValor().compareTo(paiSubstituto.getValor()) == -1) {
          paiSubstituto.setEsquerda(null);
        } else {
          paiSubstituto.setDireita(null);
        }
      } else { // não tem filho
        if (paiAtual != null) {
          if (atual.getValor().compareTo(paiAtual.getValor()) == -1) {
            paiAtual.setEsquerda(null);
          } else {
            paiAtual.setDireita(null);
          }
        } else { // é a raiz
          this.raiz = null;
        }
      }
      return true;
    } else {
      return false;
    }
  }

  // METODO QUE RETORNA A ALTURA DA ARVORE
  public int nivel(No<T> atual) {
    if (atual == null)
      return -1;
    return (int) Math.max(nivel(atual.getEsquerda()) + 1, nivel(atual.getDireita()) + 1);
  }

  // METODO QUE RETORNA A QUANTIDADE DE NOS DA ARVORE
  public int quantidade_nos(No<T> atual) {
    if (atual == null)
      return 0;
    else {
      return 1 + quantidade_nos(atual.getEsquerda()) + quantidade_nos(atual.getDireita());
    }
  }

  // METODO QUE RETORNA O PIOR CASO NA QUANTIADADE DE COMPARAÇÕES
//  public int pior_caso(No<T> atual) {
//    return quantidade_nos(atual) + 1;
//  }
  
  
  // METODO QUE RETORNA A ALTURA DA ARVORE
//  public No<T> piorCaso(No<T> atual, int altura){
//    //if(atual == null) return;
//    
//    while (altura != 1){
//       piorCaso(atual.getEsquerda(), altura - 1);
//       piorCaso(atual.getDireita(), altura - 1); 
//    }
//    return atual;   
//}
  
  
    public void piorCaso(No<T> atual, int altura){
        if(atual == null) return;
        if(altura == 1){
            System.out.print(atual.getValor().toString() + " | ");
        }
        else if(altura > 1)
        {
            piorCaso(atual.getEsquerda(), altura - 1);
            piorCaso(atual.getDireita(), altura - 1);
        }
    }

  

  // METODO QUE RETORNA O MENOR VALOR
  public No<T> menor_elemento(No<T> atual) {
    while (true) {
      if (atual.getEsquerda() == null) {
        return atual;
      }
      atual = atual.getEsquerda();
      menor_elemento(atual);
    }
  }

  // METODO QUE RETORNA O MAIOR VALOR
  public No<T> maior_elemento(No<T> atual) {
    while (true) {
      if (atual.getDireita() == null) {
        return atual;
      }
      atual = atual.getDireita();
      menor_elemento(atual);
    }
  }
 

}

