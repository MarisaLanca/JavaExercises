
package TESTE_PROG06_AnaLanca;

import java.util.Scanner;

/**
 *
 * @author Ana Lança
 */
public class D_Autocarro_Ana
{
    public static void main(String[] args)
    { 
        //dados
        final int NUMFILA = 7, NUMLUGAR = 4;   
        char[][] lugares = new char[NUMFILA][NUMLUGAR];           
        
        iniciarVetor(lugares, NUMFILA, NUMLUGAR);
        ciclo(lugares, NUMFILA, NUMLUGAR);     
        
    }
    
    //iniciar o vetor
    static char[][] iniciarVetor(char[][]lugares, final int NUMFILA,
            final int NUMLUGAR)            
    {
        for( int contFila = 0; contFila < NUMFILA; contFila++)
        {
            for(int contLugar = 0; contLugar < NUMLUGAR; contLugar++)
            {
                lugares[contFila][contLugar] = 'L'; 
            }            
        } 
        return lugares;
    }
    
    //ciclo do programa    
    static void ciclo(char[][]lugares, final int NUMFILA,final int NUMLUGAR)
    {
        boolean sairPrograma = false;
        int escolha = 0;
        
        do
        {               
            menu();
            escolha = escolheOpcao(escolha);
            sairPrograma = processarOpcao(escolha, lugares, NUMFILA, NUMLUGAR,
                    sairPrograma); 
        }while(sairPrograma == false); 
    }
    
    //menu do programa
    static void menu()
    {
        System.out.println();
        System.out.println("+*******************************+");
        System.out.println("|   AUTOCARRO 'BOA VIAGEM'      |");
        System.out.println("|*******************************|");
        System.out.println("|                               |");
        System.out.println("|             MENU              |");
        System.out.println("|                               |");
        System.out.println("|    1 - Listar Lugares         |");
        System.out.println("|    2 - Reservar Lugar         |");
        System.out.println("|    3 - Marcar Lugar           |");
        System.out.println("|    4 - Libertar Lugar         |");
        System.out.println("|    5 - Chegada ao Destino     |");
        System.out.println("|    6 - Sair do Programa       |");
        System.out.println("|                               |");
        System.out.println("+*******************************+");
        System.out.println();
    }
    
    //escolher a opção do menu
    static int escolheOpcao(int escolha)
    {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Escolha a sua opção: ");
        escolha = teclado.nextInt();
        return escolha;
    }
    
    //processar a opção escolhida
    static boolean processarOpcao(int escolha, char[][]lugares, final int NUMFILA,
            final int NUMLUGAR,boolean sairPrograma)
    {
        int numOcupados;
        
        numOcupados = lugaresOcupados(lugares, NUMFILA, NUMLUGAR);
        switch(escolha)
            {
                case 1:
                    listarLugares(lugares, NUMFILA, NUMLUGAR);                    
                    break;
                case 2:
                    reservarLugar(lugares, NUMFILA, NUMLUGAR, numOcupados);
                    break;
                case 3:
                    marcarLugar(lugares, NUMFILA, NUMLUGAR, numOcupados); 
                    break;
                case 4:
                    libertarLugar(lugares, NUMFILA, NUMLUGAR); 
                    break;
                case 5:
                    iniciarVetor(lugares, NUMFILA, NUMLUGAR); 
                    System.out.println("Chegámos ao destino, obrigado pela sua"
                            + " preferência! Todos os lugares estão novamente"
                            + " livres!");
                    break;
                case 6:
                    sairPrograma = sairDoPrograma(sairPrograma);  
                    break;
                default:
                    System.out.print("A opção escolhida não é válida!");
            }  
        return sairPrograma;
    }
 
    //listar os lugares
    static void listarLugares(char[][]lugares, final int NUMFILA,
            final int NUMLUGAR)
    {
        for( int contFila = 0; contFila < NUMFILA; contFila++)
        {
            for(int contLugar = 0; contLugar < NUMLUGAR;
                    contLugar++)
            {
                if(lugares[contFila][contLugar] == 'L')
                {
                    System.out.println("O lugar " + (contLugar+1)+ 
                            " dda fila " + (contFila + 1) + 
                            " está: Livre");
                }
                else if (lugares[contFila][contLugar] == 'R')
                {
                    System.out.println("O lugar " + (contLugar+1)+ 
                            " da fila " + (contFila + 1) + 
                            " está: Reservado");
                }
                else
                {
                    System.out.println("O lugar " + (contLugar+1)+ 
                            " da fila " + (contFila + 1) + 
                            " está: Ocupado");
                } 
            }
            System.out.println();
        }
    }
        
    
    //reservar lugar    
    static char[][] reservarLugar(char[][] lugares, final int NUMFILA,
            final int NUMLUGAR, int numOcupados)
    {
        int lugarEscolhido = 0, filaEscolhida = 0;
        Scanner teclado = new Scanner(System.in);
        
        if (numOcupados == (NUMFILA * NUMLUGAR))
        {
            menuOcupado(); 
        }
        else
        {
            try
            {
                System.out.print("Que lugar pretende reservar? ");
                lugarEscolhido = teclado.nextInt();
                System.out.print("Que fila pretende reservar? ");
                filaEscolhida = teclado.nextInt();
                
                 if(lugares[filaEscolhida-1][lugarEscolhido-1] == 'L')
                {
                    lugares[filaEscolhida-1][lugarEscolhido-1] = 'R';
                    System.out.println("O lugar foi reservado com"
                            + " sucesso!");
                    numOcupados++;
                }
                else if (lugares[filaEscolhida-1][lugarEscolhido-1] == 'R')
                {
                    System.out.println("O lugar escolhido já está"
                            + " reservado, verifique novamente os "
                            + "lugares disponíveis.");
                }
                else
                {
                    System.out.println("O lugar escolhido está ocupado, "
                            + "verifique novamente os lugares disponíveis.");
                }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Apenas é possível escolher do lugar 1 ao 4 "
                        + "e da fila 1 á 7!");               
            }         
        }
        return lugares;
    }  

    //ocupar quarto    
    static char[][] marcarLugar(char[][] lugares, final int NUMFILA,
            final int NUMLUGAR, int numOcupados)
    {
        int lugarEscolhido = 0, filaEscolhida = 0;
        Scanner teclado = new Scanner(System.in);
        
        if (numOcupados == (NUMFILA * NUMLUGAR))
        {
            menuOcupado(); 
        }
        else
        {
            try
            {
                System.out.print("Que lugar pretende marcar? ");
                lugarEscolhido = teclado.nextInt();
                System.out.print("Que fila pretende marcar? ");
                filaEscolhida = teclado.nextInt();   

                if(lugares[filaEscolhida-1][lugarEscolhido-1] == 'L')
                {
                    lugares[filaEscolhida-1][lugarEscolhido-1] = 'O';
                    System.out.println("O lugar foi ocupado com sucesso!");
                    numOcupados++;
                }
                else if (lugares[filaEscolhida-1][lugarEscolhido-1] == 'R')
                {
                    System.out.println("O lugar escolhido já está "
                            + "reservado, verifique novamente os "
                            + "lugares disponíveis.");
                }
                else
                {
                    System.out.println("O lugar escolhido está ocupado, "
                            + "verifique novamente os lugares disponíveis.");
                }
              }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Apenas é possível escolher do lugar 1 ao 4 "
                        + "e da fila 1 á 7!");              
            }  
                
        }
        return lugares;
    }    
    
    //libertar lugar
    static char[][] libertarLugar(char[][] lugares, final int NUMFILA,
            final int NUMLUGAR)
    {
        int lugarEscolhido = 0, filaEscolhida = 0;
        Scanner teclado = new Scanner(System.in);
        
        try
            {
                System.out.print("Que lugar pretende libertar? ");
                lugarEscolhido = teclado.nextInt();
                System.out.print("Que fila pretende libertar? ");
                filaEscolhida = teclado.nextInt();       
                
                if (lugares[filaEscolhida-1][lugarEscolhido-1] == 'L')
                {
                    System.out.println("O lugar escolhido já está "
                            + "desocupado, verifique novamente "
                            + "qual o seu lugar.");
                }    
                else
                {  
                    lugares[filaEscolhida-1][lugarEscolhido-1]= 'L';
                    System.out.println("O lugar está novamente Livre!");  
                } 
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Apenas é possível escolher do lugar 1 ao 4 "
                        + "e da fila 1 á 7!");              
            }  
        return lugares;
    }
        
    //sair do programa
    static boolean sairDoPrograma(boolean sairPrograma)
    {
        char op;
        Scanner teclado = new Scanner(System.in);

        System.out.print('\n' + "Pretende sair do programa? (S/N) ");
        op = teclado.nextLine().charAt(0);
        if (op == 'S' || op == 's')
        {
            sairPrograma = true;
        }    
        return sairPrograma;
    }
    
    static void menuOcupado()
    {
        System.out.println("+*******************************+");
        System.out.println("|      LUGARES OCUPADOS!        |");
        System.out.println("|*******************************|");
        System.out.println("|    Aguarde pelo próximo,      |");
        System.out.println("|     autocarro, Obrigado!      |");
        System.out.println("+*******************************+");
    }
    
    static int lugaresOcupados(char[][] lugares, final int NUMFILA,
            final int NUMLUGAR)
    {
        int numOcupados = 0;
        
        for( int contFila = 0; contFila < NUMFILA; contFila++)
        {
            for(int contLugar = 0; contLugar < NUMLUGAR; contLugar++)
            {
                if(lugares[contFila][contLugar] == 'R' ||
                        lugares[contFila][contLugar] == 'O')
                {
                numOcupados++;
                }  
            }            
        }     
        return numOcupados;
    }     
}
