package view;

import java.util.List;

public class MetodosControle {

    public static boolean isVazio(List lista, String oQue){
        if(lista.isEmpty()){
            System.out.println("Não há " + oQue + " disponíveis, cadastre primeiro");
            return true;
        } else {
            return false;
        }
    }

}
