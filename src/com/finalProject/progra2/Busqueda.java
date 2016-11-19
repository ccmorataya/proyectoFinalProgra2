package com.finalProject.progra2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Busqueda {
    private static String searchHeader = "Se encontraron las siguientes coincidencias: ";

    static void todasLasPalabras(List<Usuario> usuarios, String fragment){
        Busqueda buscar = new Busqueda();
        String[] matches = new String[100];
        List<String> dataList = new ArrayList<>();

        for (Usuario row: usuarios) {
            dataList.add(row.getCurso() + " : " + row.getCarne() + " - " + row.getAlumno() + " - " + row.getNota());
        }

        for (String compare : dataList){
            matches = buscar.search(fragment, compare);
        }

        System.out.println(searchHeader);
        printMatches(matches);
    }
    static void cualquierPalabra(){
        System.out.println(searchHeader);
    }

    static String[] search(String regex, String onText)
    {
        Pattern regPatt = Pattern.compile(regex);
        Matcher regMatch = regPatt.matcher(onText);
        ArrayList<String> matches = new ArrayList<>();
        String[] matchesArray;

        while(regMatch.find())
        {
            String match = regMatch.group();
            matches.add(match);
        }

        matchesArray = new String[matches.size()];
        matches.toArray(matchesArray);
        return matchesArray;
    }

    static void printMatches(String[] matches)
    {
        int matchesCount = matches.length;

        for(int i = 0; i < matchesCount; i++)
        {
            System.out.println(matches[i]);
        }
    }
}
