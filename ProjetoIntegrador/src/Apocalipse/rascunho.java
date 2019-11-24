/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apocalipse;

import java.util.Scanner;

/**
 *
 * @author Junio 2.0
 */
public class rascunho {
    static void imprimirSit(int linha, String[][] bloco){
        for(int i=linha;i<(linha+1);i++){
            for (String item : bloco[i]) {
                System.out.println(item);
            }
        }
    }
    static boolean deNovo(){
        Scanner entrada = new Scanner(System.in);
        boolean deNovo = false;
        System.out.println("Jogar de novo? ");
        System.out.println("[1] Sim");
        System.out.println("[2] Não");
        int resposta = entrada.nextInt();
        if(resposta == 2){
            deNovo = true;
            System.out.println("Foi um prazer!");
        }
        return deNovo;
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String arma = "machado";
        char op;
        boolean morreu = false, deNovo;
        int saude = 1, pontos = 0, saudeT, pontosT;
        
        String[] bloco5 = {"\nAgora é preciso checar se realmente não há nenhum "
                + "morto vivo e se todas as portas e janelas estão à prova de "
                + "zumbi para não ter surpresas a noite.\nAo entrar, percebe que"
                + " há dois andares, o térreo e o subsolo. No térreo, você "
                + "estima 2 salas de aula e 2 laboratórios, e como zumbis tem "
                + "dificuldade\npara subir escada, você começa a checar o andar "
                + "de cima para não ser pego de surpresa. ",
                //situação 1
                "Depois do banheiro, vem a primeira sala à esquerda. A porta "
                + "está aberta, você entra, aparentemente vazia. Várias "
                + "carteiras jogadas e por sorte \nnenhuma janela. ",
                //situação 2
                "Logo em frente à segunda sala, há um laboratório. Sua porta é "
                + "de vai e vem com uma janelinha. Do lado de fora não parece "
                + "ter nenhum zumbi, mas já dá \npara enxergar várias janelas e "
                + "corpos em cima de mesas de alumínio.",
                //situação 3
                "Todo o corredor da esquerda já foi, só falta o laboratório em "
                + "frente à escada para encerrar o dia",
                
                "O segundo laboratório tem uma porta com identificador, que abre"
                + " do lado de fora apenas para quem tem a senha. Você tenta "
                + "algumas senhas, mas \nnenhuma delas funciona. Como já está "
                + "tarde e o cansaço bateu, você vai para a sala 1 descansar. ",
               //situação 4
                "Com muito esforço, consegue abrir a porta. Assim que abre, 3 "
                + "zumbis vem correndo em sua direção. Enquanto você tentar "
                + "matar um na sua frente, os \noutros 2 te atacam pelo outro "
                + "lado. Você sai correndo para fora do laboratório e entra na "
                + "sala 1, onde consegue dar a volta pela sala para trancar \nos "
                + "dois lá dentro e ter um tempo para pensar como matar os dois.",
                
                "Agora que o laboratório está vazio, dá tempo de procurar algum"
                + " recurso para matá-los. Para sua sorte, era nesse lugar que "
                + "os corpos eram dissecados, \nentão encontra vários equipamentos"
                + " cirúrgicos que podem ser úteis para sobreviver."
        };
                
        String[][] sitBloco5 = {
       /*sit1*/            {"A primeira coisa que você faz é checar se tem água, ao "
                + "entrar no banheiro: "},
       /*sit2*/            {"Já a segunda sala está com a porta fechada, então você: ", 
                   "a) abre e explora", "b)  faz barricada na porta usando as carteiras"
                       + " da primeira sala"},
       /*sit3*/            {"Ao entrar, percebe que as janelas não abrem, são apenas para "
                       + "deixar a luz entrar. Dando uma batidinha no vidro, percebe "
                       + "que ele é temperado. \nEntão você: ", "a) joga todos os corpos"
                       + " em um canto e coloca as mesas de metal em frente a janela "
                       + "porque toda segurança ainda é pouca", "b) confia no vidro "
                       + "temperado"},
       /*sit4*/            {"Depois de uma noite mal dormida, se prepara para abrir o "
                + "laboratório fechado. Já deixa a sua "+arma+" preparada para "
                + "caso haja algum zumbi. Tenta \nmais uma combinação de senha antes de "
                + "ir para a força bruta, mas sem sucesso. ", "O que você faz agora?", 
                "a) destrói a caixa de colocar a senha e a maçaneta ", "b) desmonta a "
                + "caixa de colocar a senha e corta todos os fios"}
               };
        saudeT = saude;
        do{
            deNovo = true;
            if(morreu){
                saude = saudeT;
            }
            System.out.println(saude);
            for(int i=0;i<bloco5.length;i++){
                 System.out.println(bloco5[i]);
                 System.out.println();
                 if(i==0){
                     imprimirSit(0, sitBloco5); 
                     op = entrada.next().charAt(0);
                     if(op == 'a'){
                         System.out.println("primeira opção");
                     } else{
                         saude--;
                         if(saude == 0){
                            morreu = true;
                            deNovo = deNovo();
                            break;
                         }
                     }
                }
                if(i==1){
                    imprimirSit(1,sitBloco5);
                    op = entrada.next().charAt(0);
                    if(op == 'a'){
                        System.out.println("primeira opção");
                    }
                }
                 
            }
            
        }while(!deNovo);
    }
}
