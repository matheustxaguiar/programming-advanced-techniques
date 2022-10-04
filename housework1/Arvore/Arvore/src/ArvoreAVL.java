/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Matheus Aguiar
 * @param <T>
 */
public class ArvoreAVL<T extends Comparable> extends Arvore<T>{
   
    @Override
    public No<T> adicionarNaArvore(No<T> raiz, No<T> novo){
        raiz = super.adicionarNaArvore(raiz, novo);
        
        if (raiz.fatorBalanceamento() > 1){
            if(raiz.getDireita().fatorBalanceamento()>0)
                raiz=this.rotacaoEsquerda(raiz);
            else
                raiz = this.rotacaoDireitaEsquerda(raiz);
        }    
        else if (raiz.fatorBalanceamento()<-1){
            if(raiz.fatorBalanceamento().fatorBalanceamento() < 0)
                raiz = this.rotacaoDireita(raiz);
            else
                raiz = this.rotacaoEsquerdaDireita(raiz);
        }
        
        return raiz;


         // SOBRESCRVER TUDO DE FORMA RECURSSIVA
//        if (raiz == null) {
//         this.raiz = novoElemento;
//       } else {
//        No<T> atual = this.raiz;
//        while (true) {
//            if (novoElemento.getValor().compareTo(atual.getValor()) == -1) {
//              if (atual.getEsquerda() != null) {
//                atual = atual.getEsquerda();
//              } else {
//                atual.setEsquerda(novoElemento);
//                break;
//              }
//            } else { // se for maior ou igual
//              if (atual.getDireita() != null) {
//                atual = atual.getDireita();
//              } else {
//                atual.setDireita(novoElemento);
//                break;
//              }
//            }
//          }
//        }
  }
    
   private No<T> rotacaoEsquerda(No<T> raiz){
       return raiz;
   }
   
   private No<T> rotacaoDireita(No<T> raiz){
       return raiz;
   }
    
   private No<T> rotacaoDireitaEsquerda(No<T> raiz){
       return raiz;
   }   
   
   public int fatorBalanceamento(){
       return super.nivel(this.raiz.getDireita()) - super.nivel(this.raiz.getEsquerda());
   }
    
    // Remocao
}
