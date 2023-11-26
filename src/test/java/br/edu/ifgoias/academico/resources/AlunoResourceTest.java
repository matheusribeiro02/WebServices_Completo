package br.edu.ifgoias.academico.resources;
import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.academico.services.AlunoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class AlunoResourceTest {

    @Mock
    private AlunoService alunoService;

    @InjectMocks
    private AlunoResource alunoResource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        Aluno aluno = new Aluno(1, "João", "Masculino", LocalDate.of(2000, 1, 1));

        when(alunoService.findById(1)).thenReturn(aluno);

        ResponseEntity<Aluno> response = alunoResource.findById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(aluno, response.getBody());
    }

    @Test
    void testInsert() {
        Aluno aluno = new Aluno(1, "João", "Masculino", LocalDate.of(2000, 1, 1));

        when(alunoService.insert(aluno)).thenReturn(aluno);

        ResponseEntity<Aluno> response = alunoResource.insert(aluno);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(aluno, response.getBody());
    }

    @Test
    void testDelete() {
        ResponseEntity<Void> response = alunoResource.delete(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(alunoService, times(1)).delete(1);
    }

    @Test
    void testUpdate() {
        Aluno aluno = new Aluno(1, "João", "Masculino", LocalDate.of(2000, 1, 1));

        when(alunoService.update(1, aluno)).thenReturn(aluno);

        ResponseEntity<Aluno> response = alunoResource.update(1, aluno);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(aluno, response.getBody());
    }
}


