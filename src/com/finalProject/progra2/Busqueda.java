package com.finalProject.progra2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Busqueda {
    private static String searchHeader = "Se encontraron las siguientes coincidencias: ";

    static void todasLasPalabras(List<String> clonedUsuarios, String fragment){
        List <String> listClone = new ArrayList<String>();
        String matchString = "(.*)"+ fragment +"(.*)";
//        String matchString = "(?i)("+ fragment +").*";

        for (String string : clonedUsuarios) {
            if(string.matches(matchString)){
                listClone.add(string);
            }
        }
        System.out.println(listClone);
    }
    static void cualquierPalabra(){
        System.out.println(searchHeader);
    }

}
