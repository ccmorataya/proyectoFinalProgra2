package com.finalProject.progra2;

class Usuario {
    private String curso;
    private String carne;
    private String alumno;
    private String nota;

    public Usuario(String curso, String carne, String alumno, String nota) {
        setCurso(curso);
        setCarne(carne);
        setAlumno(alumno);
        setNota(nota);
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

}
