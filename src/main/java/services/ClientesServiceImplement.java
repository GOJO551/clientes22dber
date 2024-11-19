package services;

import modelos.Clientes;

import java.util.Arrays;
import java.util.List;

public class ClientesServiceImplement implements ClientesService{

    @Override
    public List<Clientes> listar() {
        return Arrays.asList(new Clientes(1L,"Ivan","Lisintuña",1125,"Masculino"),
                new Clientes(65L,"Carlos","Cabrera",1022,"Masculino"),
                new Clientes(45L,"Angel","Cabrera",666,"Masculino"),
                new Clientes(30L,"Magdalena","Cabrera",13131,"Femenino"),
                new Clientes(22L,"Juan","Cabrera",1225,"Masculino"),
                new Clientes(21L,"David","Cabrera",12314534,"Masculino"),
                new Clientes(30L,"Sebastian","Cabrera",9221456,"Masculino"),
                new Clientes(15L,"Alex","Cadena",17567577,"Masculino"),
                new Clientes(88L,"Jhonatan","Pardo",12155464,"Masculino"),
                new Clientes(99L,"Ximena","Cabrera",956558,"Femenino")
        );

    }
}
