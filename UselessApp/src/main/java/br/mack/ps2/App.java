package br.mack.ps2;
/*
Nome: Bianca Maciel
TIA: 31936873
Turma: 3H
 */
import br.mack.ps2.persistencia.InterfaceUsuario;
import br.mack.ps2.persistencia.RelogioDAOMySQL;
import java.sql.*;
public class App {
    public static void main(final String[] args ) {
        RelogioDAOMySQL mysqlDAO = new RelogioDAOMySQL();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(mysqlDAO);
        interfaceUsuario.iniciar();
    }
}
