package Apocalipse;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author beatriz.sato
 */
public class apocalipse {
    static void imprimirSituacao(int linha, String[][] bloco){
        for(int i=linha;i<(linha+1);i++){
            for (String item : bloco[i]) {
                System.out.println(item);
            }
        }
        System.out.println();
    }
    
    static int geradorAleatorio(int num){
        Random gerador = new Random();
        int numAleatorio = gerador.nextInt(num);
        return numAleatorio;
    }
    
    static void imprimirMorte(){
        System.out.println();
        Random gerador = new Random();
        int num = gerador.nextInt(3);
        if(num == 0){
            System.out.println("Você infelizmente não conseguiu resistir a "
                + "todos os ferimentos e teve uma morte lenta e \ndolorosa");
        }else if(num == 1){
            System.out.println("Você quase conseguiu resistir ao apocalipse "
                + "zumbi, mas com tantos ferimentos, acabou morrendo");
        }else{
            System.out.println("Você foi infectado no último ataque e morreu. "
                + "Parabéns, você virou um zumbi");
        }
    }
    
    static char entrada(){
        Scanner entrada = new Scanner(System.in);
        char op = entrada.next().charAt(0);
        System.out.println();
        return op;
    }
    
    static void imprimirBreak(){
        System.out.print("                               ");
        System.out.print("*******************************");
        System.out.print("                               ");
        System.out.println();
    }

    static boolean deNovo(){
        Scanner entrada = new Scanner(System.in);
        boolean deNovo = false;
        System.out.println();
        System.out.println("Jogar de novo? ");
        System.out.println("[1] Sim");
        System.out.println("[2] Não");
        int resposta = entrada.nextInt();
        if(resposta == 2){
            deNovo = true;
            System.out.println("Foi um prazer!");
            System.out.println();
        }
        return deNovo;
    } 
    
    public static void main(String[] args) {
        String arma = "machado";
        char op;
        int saude = 4, pontos = 0, saudeT, pontosT, num;
        boolean amigo = false, deNovo, morreu = false;
        
        //Todos os vetores de texto de bloco
        String[] bloco5 = {"Agora é preciso checar se realmente não há nenhum "
            + "morto vivo e se todas as portas e janelas \nestão à prova de "
            + "zumbi para não ter surpresas a noite. Ao entrar, você estima 2"
            + " salas de aula \ne 2 laboratórios e decide começar pelo corredor"
            + " à esquerda.",
            //situação 1
            "Depois do banheiro, vem a primeira sala à esquerda. A porta "
            + "está aberta, você entra, \naparentemente vazia. Várias "
            + "carteiras jogadas e por sorte nenhuma janela. ",
            //situação 2
            "Logo em frente à segunda sala, há um laboratório. Sua porta é "
            + "de vai e vem com uma janelinha. \nDo lado de fora não parece "
            + "ter nenhum zumbi, mas já dá para enxergar várias janelas e "
            + "corpos\nem cima de mesas de alumínio.",
            //situação 3
            "Todo o corredor da esquerda já foi, só falta o laboratório em "
            + "frente à escada para encerrar o\ndia",

            "O segundo laboratório tem uma porta com identificador, que abre"
            + " do lado de fora apenas para \nquem tem a senha.\nVocê tenta "
            + "algumas senhas, mas nenhuma delas funciona. \nComo já está "
            + "tarde e o cansaço bateu, você vai para a sala 1 descansar. ",
           //situação 4
            "Com muito esforço, consegue abrir a porta. \nAssim que abre, 3 "
            + "zumbis vem correndo em sua direção. \nEnquanto você tentar "
            + "matar um na sua frente, os outros 2 te atacam pelo outro "
            + "lado.\nVocê sai correndo para fora do laboratório e entra na "
            + "sala 1, onde consegue dar a volta pela\nsala para trancar os "
            + "dois lá dentro e ter um tempo para pensar como matar os dois.",

            "Agora que o laboratório está vazio, dá tempo de procurar algum"
            + " recurso para matá-los.\nPara sua sorte, era nesse lugar que "
            + "os corpos eram dissecados, então encontra vários\nequipamentos"
            + "cirúrgicos que podem ser úteis para sobreviver."
        };
        
        
        //todas matrizes de situações de cada bloco
        String[][] sitBloco5 = {
/*sit0*/    {"A primeira coisa que você faz é checar se tem água, ao "
/*aleat*/   + "entrar no banheiro ", "você é surpreendido\npor um zumbi que te"
            + "ataca e te deixa levemente ferido \nantes de você matá-lo.",
            "logo vê a torneira \naberta com água saindo dela e comemora.", 
            "tenta abrir a \ntorneira mas infelizmente nada sai."},
/*sit1*/    {"Já a segunda sala está com a porta fechada, então você: ", 
            "a) abre e explora","b) faz barricada na porta usando as carteiras"
            + " da primeira sala"},
/*sit2*/    {"Ao entrar, percebe que as janelas não abrem, são apenas para "
            + "deixar a luz entrar. \nDando uma batidinha no vidro, percebe "
            + "que ele é temperado. Então você: ", "a) joga todos os corpos"
            + " em um canto e coloca as mesas de metal em frente a janela "
            + "porque toda\nsegurança ainda é pouca", "b) confia no vidro "
            + "temperado"},
/*sit3*/    {"Depois de uma noite mal dormida, se prepara para abrir o "
            + "laboratório fechado.\nJá deixa a sua "+arma+" preparada para "
            + "caso haja algum zumbi. Tenta mais uma combinação de \nsenha"
            + "antes de ir para a força bruta, mas sem sucesso. ", "O que você "
            + "faz agora?", "a) destrói a caixa de colocar a senha e a maçaneta"
            + " ", "b) desmonta a caixa de colocar a senha e corta todos os "
            + "fios"}
        };
        
        //texto de alternativa
        String textoSituacao2 = "Ao abrir, é pego de surpresa por um zumbi, que"
            + " tenta te atacar mas você consegue rapidamente \nacertar ele na "
            + "cabeça com "+arma+", apesar de sair com um pequeno ferimento."
            + "\nEssa sala tem uma janela, que você cobre com as carteiras.\n"
            + "Depois de proteger as janelas, você acha no canto da sala um kit"
            + " de primeiros socorros para \ncuidar do ferimento, mas nada "
            + "além disso. \nPor precaução, acha melhor deixar a porta "
            + "fechada e fazer uma barricada para impedir a \npassagem por "
            + "ela também.";
        
        saudeT = saude; pontosT = pontos; //antes de todo bloco fazer isso
       //imprimir o bloco 5
        do{
            imprimirBreak();
            deNovo = true; //faz com que não repita o laço caso não morra
            if(morreu){
                saude = saudeT;
                pontos = pontosT;
            }
            for(int i=0;i<bloco5.length;i++){
                System.out.println(bloco5[i]);
                System.out.println();
                if(i==0){
                    System.out.print(sitBloco5[0][0]);
                    num = geradorAleatorio(3);
                    switch (num) {
                        case 0:
                            System.out.println(sitBloco5[0][1]);
                            saude--;
                            System.out.println("    -1 ponto saúde");
                            break;
                        case 1:
                            System.out.println(sitBloco5[0][2]);
                            pontos++;
                            break;
                        default:
                            System.out.println(sitBloco5[0][3]);
                            break;
                    }
                    if(saude <= 0){
                        imprimirMorte();
                        morreu = true;
                        deNovo = deNovo();
                        break;
                    }
                }
                if(i==1){
                    imprimirSituacao(1,sitBloco5); //situacao 2
                    op = entrada();
                    if(op == 'a'){
                        pontos++;
                        System.out.println(textoSituacao2);
                        System.out.println();
                    }
                }
                if(i==2){
                    imprimirSituacao(2,sitBloco5); //situacao 3
                    op = entrada();
                    if(op == 'a'){
                        pontos++;
                    } 
                }
                if(i==4){
                    imprimirSituacao(3,sitBloco5); //situação 4
                    op = entrada();
                    if(op == 'b'){
                        pontos++;
                    }
                }
                if(i==5){
                    saude -= 2;
                    System.out.println("    -2 pontos de saúde");
                    System.out.println();
                    if(saude <= 0){
                        imprimirMorte();
                        morreu = true;
                        deNovo = deNovo();
                        break;
                     }
                }
            }
        }while(!deNovo);
        
        System.out.println("Status: ");
        System.out.println(saude);
        System.out.println(pontos);
        
        //check
        //bloco 6
    }
}
