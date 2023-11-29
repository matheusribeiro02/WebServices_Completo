package br.edu.ifgoias.academico.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CursoTest {

    private Curso curso;
    private Aluno aluno;

    @BeforeEach
    void setUp() {
        curso = new Curso(1, "Curso Teste");
        aluno = new Aluno(1, "João", "Masculino", LocalDate.of(2000, 1, 1));
    }

    @Test
    void testGetIdcurso() {
        assertEquals(1, curso.getIdcurso());
    }

    @Test
    void testSetIdcurso() {
        curso.setIdcurso(2);
        assertEquals(2, curso.getIdcurso());
    }

    @Test
    void testGetNomecurso() {
        assertEquals("Curso Teste", curso.getNomecurso());
    }

    @Test
    void testSetNomecurso() {
        curso.setNomecurso("Novo Curso");
        assertEquals("Novo Curso", curso.getNomecurso());
    }

    @Test
    void testGetAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno);
        curso.addAluno(aluno);
        assertEquals(alunos, curso.getAlunos());
    }

    @Test
    void testAddAluno() {
        curso.addAluno(aluno);
        assertTrue(curso.getAlunos().contains(aluno));
        assertEquals(curso, aluno.getCurso());
    }

    @Test
    void testRemoveAluno() {
        curso.addAluno(aluno);
        curso.removeAluno(aluno);
        assertFalse(curso.getAlunos().contains(aluno));
        assertNull(aluno.getCurso());
    }

    @Test
    void testEquals() {
        Curso curso2 = new Curso(1, "Curso Teste");
        assertEquals(curso, curso2);
    }

    @Test
    void testHashCode() {
        Curso curso2 = new Curso(1, "Curso Teste");
        assertEquals(curso.hashCode(), curso2.hashCode());
    }

    @Test
    void testToString() {
        String expected = "Curso [idcurso=1, nomecurso=Curso Teste]";
        assertEquals(expected, curso.toString());
    }
}