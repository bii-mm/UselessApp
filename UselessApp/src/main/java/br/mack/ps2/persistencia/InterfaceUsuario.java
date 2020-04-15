package br.mack.ps2.persistencia;
import br.mack.ps2.entidades.Relogio;
import br.mack.ps2.persistencia.RelogioDAO;
import java.util.*;

public class InterfaceUsuario {
    RelogioDAO dao;
    Scanner in;

    public InterfaceUsuario(RelogioDAO dao){
        this.dao = dao;
        this.in = new Scanner(System.in);
    }

    public void iniciar(){
        System.out.println("Bem-vindo(a) ao PerdiClock!");
        System.out.println("\nBasta você me dizer o horário (apenas as horas) e eu te direi se é de manhã, tarde ou noite");
        imprimirMenu();
    }

    private void imprimirMenu(){
        int opc = 0;
        do{
            System.out.println("==MENU==");
            System.out.println("\t1.Create\t2.Read\t3.Delete\t4.Sair");
            System.out.print("Opção: ");
            opc = in.nextInt();

            in.nextLine();

            switch (opc){
                case 1:
                    this.create();
                    break;
                case 2:
                    this.read();
                    break;
                case 3:
                    this.delete();
                    break;
                default:
                    break;
            }
        }while (opc != 4);
    }

    private void create(){
        Relogio relogio = new Relogio();
        System.out.println("===NOVO HORÁRIO==");
        System.out.print("Informe o seu nome: ");
        String p = in.nextLine();
        relogio.setNome(p);
        System.out.print("Informe a hora: ");
        int h = in.nextInt();
        relogio.setHora(h);
        verHorario(p,h);
        if(dao.create(relogio))
            System.out.println("Cadastro adicionado com sucesso!");
        else
            System.out.println("Vish, tivemos um problema...");
    }

    private void read(){
        List<Relogio> relogios = dao.read();
        System.out.println("==LISTA DE CADASTROS==");
        for(Relogio relogio : relogios)
            System.out.println(relogio);
    }

    private void delete(){
        List<Relogio> relogios = dao.read();

        while(true){
            System.out.println("==LISTA DE CADASTROS==");
            int i = 0;
            for(Relogio relogio : relogios){
                System.out.println(i + " - " + relogio);
                i++;
            }
            System.out.print("Qual cadastro você quer remover? ");
            int opc = in.nextInt();
            in.nextLine();

            if (opc == i)
                break; //cancelar a operação
            if (opc>=relogios.size() || opc<0)
                System.out.println("Opção Inválida!");
            else{
                if (dao.delete(relogios.get(i)))
                    System.out.println("O cadastro do(a) " + relogios.get(opc).getNome() + "foi removido com sucesso!");
                else
                    System.out.println("Vish, tente novamente...");
            break;
            }
        }
    }

    private void verHorario(String p, int h){
        if (h>=6 && h<=11)
            System.out.println("\nBOM DIA "+ p + "! É de manhã ainda..Ótimo horário para acordar e meditar");
        else
            if(h>=12 && h<=18)
                System.out.println("\nBOA TARDE " + p + "! É de tarde já... Momento perfeito para começar a sua rotina");
            else
                if(h>=19 && h<=23)
                    System.out.println("\nBOA NOITE " + p + "! É de noite, mas não pense que ainda não dá tempo de terminar o que estiver fazendo!");
                else
                    System.out.println("\n" + p + "...é de madrugada!! Se eu fosse você iria dormir, ficar acordado até essa hora causa rugas");

    }
}
