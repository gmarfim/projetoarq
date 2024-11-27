package src.interfaces;

import src.models.Imovel;
import java.util.List;

public interface Persistencia {
    void salvarImovel(Imovel imovel);
    List<Imovel> listarImoveis();
}
