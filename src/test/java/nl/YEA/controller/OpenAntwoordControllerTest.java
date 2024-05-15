package nl.YEA.controller;

import nl.YEA.Singleton;
import nl.YEA.model.OpenAntwoord;
import nl.YEA.repos.IngevuldeVragenlijstRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.lang.Boolean.TRUE;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OpenAntwoordControllerTest {
    @Mock
    OpenAntwoord OaMock;
//    @Mock
//    Singleton singletonMock;
//    @Mock
//    IngevuldeVragenlijstRepo repoMock;

    @InjectMocks
    OpenAntwoordController sut;

    @Test
    public void welOfNietGoedgekeurd() {
        OaMock.setAntwoord("Test");
        Assertions.assertEquals(TRUE, sut.antwoordGoedgekeurd(0, "Test"));
    }
}
