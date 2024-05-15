package nl.YEA.view;

import nl.YEA.Singleton;
import nl.YEA.controller.NumeriekAntwoordController;
import nl.YEA.controller.NumeriekeVraagController;
import nl.YEA.repos.IngevuldeVragenlijstRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NumeriekAntwoordInzienSchermTest {
    @Mock
    InOutputUtil inOutputUtilMock;
    @Mock
    Singleton singletonMock;
    @Mock
    IngevuldeVragenlijstRepo ingevuldeVragenlijstRepoMock;
    @Mock
    NumeriekeVraagController nvControllerMock;
    @Mock
    NumeriekAntwoordController naControllerMock;
    @InjectMocks
    NumeriekAntwoordInzienScherm sut = new NumeriekAntwoordInzienScherm(1);

    @BeforeEach
    void setUp() {
        InOutputUtil.setInOutputController(inOutputUtilMock);
        Singleton.setSingletonInstance(singletonMock);
    }

    @Test
    void numeriekAntwoordInzienHappyFlow() {
        String beschrijving = "beschrijving";
        int antwoord = 2;
        when(singletonMock.getNumeriekeVraagController()).thenReturn(nvControllerMock);
        when(singletonMock.getNumeriekAntwoordController()).thenReturn(naControllerMock);
        when(nvControllerMock.getVraagBeschrijving(1)).thenReturn(beschrijving);
        sut.setHeeftAntwoord(true);
        when(naControllerMock.getAntwoord(1)).thenReturn(antwoord);

        sut.show();

        assertEquals(1,sut.vraagNr);
        verify(inOutputUtilMock).printNl(beschrijving);
        verify(inOutputUtilMock).printNl("" + antwoord);
    }

    @Test
    void numeriekeVraagZonderAntwoord() {
        String beschrijving = "beschrijving";
        int antwoord = 2;
        when(singletonMock.getNumeriekeVraagController()).thenReturn(nvControllerMock);
        when(singletonMock.getNumeriekAntwoordController()).thenReturn(naControllerMock);
        when(nvControllerMock.getVraagBeschrijving(1)).thenReturn(beschrijving);
        sut.setHeeftAntwoord(false);

        sut.show();

        assertEquals(1,sut.vraagNr);
        verify(inOutputUtilMock).printNl(beschrijving);
        verify(inOutputUtilMock).printNl("");
    }
}