package com.finalProject.progra2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Busqueda {
    private static String searchHeader = "Se encontraron las siguientes coincidencias: ";

    static void todasLasPalabras(List<String> clonedUsuarios, String fragment){
        System.out.println(searchHeader);
        List <String> listClone = new ArrayList<String>();
        String[] splited = fragment.split("\\s+");
        StringBuilder matchString = new StringBuilder();
        matchString.append("(.*)");

        for (String aSplited : splited){
            matchString.append(aSplited);
            matchString.append("(.*)");
        }

        for (String string : clonedUsuarios) {
            if(string.matches(matchString.toString())){
                listClone.add(string);
            }
        }

        for (String string : listClone) {
            System.out.println(string);
        }
    }
    static void cualquierPalabra(List<String> clonedUsuarios, String fragment){
        System.out.println(searchHeader);
        List <String> listClone = new ArrayList<String>();
        String[] splited = fragment.split("\\s+");
        StringBuilder matchString = new StringBuilder();

        for (String aSplited : splited){
            matchString.append("((.*)");
            matchString.append(aSplited);
            matchString.append("(.*))");
            if (!Objects.equals(aSplited, splited[splited.length - 1])){
                matchString.append("|");
            }
        }

        for (String string : clonedUsuarios) {
            if(string.matches(matchString.toString())){
                listClone.add(string);
            }
        }

        for (String string : listClone) {
            System.out.println(string);
        }
    }

}
