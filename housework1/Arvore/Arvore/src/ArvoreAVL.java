/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Arthur Delpupo e Matheus Aguiar 
 * @param <T>
 */
public class ArvoreAVL<T extends Comparable> extends Arvore<T>{
    
   
    @Override
    public No<T> adicionarNaArvore(No<T> raiz, No<T> novo){
        raiz = super.adicionarNaArvore(raiz, novo);
        
        if (fatorBalanceamento(raiz) > 1){
            if(fatorBalanceamento(raiz.getDireita())>0)
                raiz=this.rotacaoEsquerda(raiz);
            else
                raiz = this.rotacaoDireitaEsquerda(raiz);
        }    
        else if (fatorBalanceamento(raiz)<-1){
            if(fatorBalanceamento(raiz.getEsquerda()) < 0)
                raiz = this.rotacaoDireita(raiz);
            else
                raiz = this.rotacaoEsquerdaDireita(raiz);
        }
        
        return raiz;
  }
    
   private No<T> rotacaoEsquerda(No<T> raiz){
       No<T> f = raiz.getDireita();
       raiz.setDireita(f.getEsquerda());
       f.setEsquerda(raiz);
      return f;
   }
   
   private No<T> rotacaoDireita(No<T> raiz){
       No<T> f = raiz.getEsquerda();
       raiz.setEsquerda(f.getDireita());
       f.setDireita(raiz);
       return f;
   }
    
   private No<T> rotacaoDireitaEsquerda(No<T> raiz){
       raiz.setDireita(rotacaoDireita(raiz.getDireita()));
       return rotacaoEsquerda(raiz);
   }
   
   
   private No<T> rotacaoEsquerdaDireita(No<T> raiz){
       raiz.setEsquerda(rotacaoEsquerda(raiz.getEsquerda()));
       return rotacaoDireita(raiz);
   }

   
   public int fatorBalanceamento(No<T> atual){
       return nivel(atual.getDireita()) - nivel(atual.getEsquerda());
   }
    
    // Remocao
}
