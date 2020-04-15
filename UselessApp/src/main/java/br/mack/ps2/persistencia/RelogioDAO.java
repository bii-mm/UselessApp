package br.mack.ps2.persistencia;
import br.mack.ps2.entidades.Relogio;
import java.util.*;

public interface RelogioDAO {
    boolean create(Relogio relogio);
    List<Relogio>read();
    boolean delete(Relogio relogio);
}

