package com.finalProject.progra2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.csvreader.CsvReader;

public class Main {

    public static void main(String[] args) {
        boolean isAlive = true;
        Scanner scann = new Scanner(System.in);
        int i = 0;
        List<Usuario> usuarios = new ArrayList<>();
        List<String> clone = new ArrayList<>();

        while(isAlive) {
            Menu.show();
            i = Integer.parseInt(scann.nextLine());

            if (i == 1) {
                try {
                    Path filePath = Paths.get(System.getProperty("user.dir") + "/usuarios_import.csv");
                    CsvReader usuarios_import = new CsvReader(filePath.toString());
                    usuarios_import.readHeaders();

                    while (usuarios_import.readRecord()) {
                        String curso = usuarios_import.get(0);
                        String carne = usuarios_import.get(1);
                        String alumno = usuarios_import.get("Alumno");
                        String nota = usuarios_import.get("Nota");

                        usuarios.add(new Usuario(curso, carne, alumno, nota));
                    }

                    usuarios_import.close();

                    System.out.println("\nDatos cargados exitosamente, la información ingresada es:\n");

                    for (Usuario us : usuarios) {
                        clone.add(us.getCurso() + " : " + us.getCarne() + " - " + us.getAlumno() + " - " + us.getNota());
                        System.out.println(us.getCurso() + " : " + us.getCarne() + " - " + us.getAlumno() + " - " + us.getNota());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println();
            }
            else if (i == 2){
                Menu.find();

                i = Integer.parseInt(scann.nextLine());
                String fragment;

                if (i == 1){
                    System.out.println("Ingresa el nombre a buscar\n");
//                    System.out.println("Search all words\n");
                    fragment = scann.nextLine();
                    Busqueda.todasLasPalabras(clone, fragment);
                }
                else if (i == 2){
                    System.out.println("Search any word\n");
                    Busqueda.cualquierPalabra();
                }
            }
            else if (i == 0){
                isAlive = false;
            }
        }

    }
}
