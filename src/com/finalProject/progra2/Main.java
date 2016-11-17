package com.finalProject.progra2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;

public class Main {

    public static void main(String[] args) {
        try {

            List<Usuario> usuarios = new ArrayList<Usuario>();

            CsvReader usuarios_import = new CsvReader("C:\\Users\\LuisF\\Desktop\\pruevaarray/usuarios_import.csv");
            usuarios_import.readHeaders();

            while (usuarios_import.readRecord())
            {
                String curso = usuarios_import.get(0);
                String carne = usuarios_import.get(1);
                String alumno = usuarios_import.get("Alumno");
                String nota = usuarios_import.get("Nota");

                usuarios.add(new Usuario(curso, carne, alumno, nota));
            }

            usuarios_import.close();

            for(Usuario us : usuarios){

                System.out.println(us.getCurso() + " : " + us.getCarne() + " - "
                        + us.getAlumno() + " - " + us.getNota());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
