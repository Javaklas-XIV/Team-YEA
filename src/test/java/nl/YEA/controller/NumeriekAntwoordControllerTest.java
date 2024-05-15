package nl.YEA.controller;

import nl.YEA.Singleton;
import nl.YEA.model.IngevuldeVragenlijst;
import nl.YEA.model.NumeriekAntwoord;
import nl.YEA.repos.IngevuldeVragenlijstRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NumeriekAntwoordControllerTest {
    @Mock
    Singleton singletonMock;
    @Mock
    NumeriekeVraagController numeriekeVraagControllerMock;
    @Mock
    IngevuldeVragenlijstRepo ingevuldeVragenlijstRepoMock;
    @InjectMocks
    NumeriekAntwoordController sut;

    @BeforeEach
    void setup() {
        Singleton.setSingletonInstance(singletonMock);
    }

    @Test
    void geldigAntwoordIsAdded() {
        int vraagNr = 1;
        int antwoord = 2;
        when(singletonMock.getNumeriekeVraagController()).thenReturn(numeriekeVraagControllerMock);
        when(numeriekeVraagControllerMock.getMinimum(vraagNr)).thenReturn(1);
        when(numeriekeVraagControllerMock.getMaximum(vraagNr)).thenReturn(3);
        when(singletonMock.getRepo()).thenReturn(ingevuldeVragenlijstRepoMock);

        sut.addAntwoord(vraagNr, antwoord);

        verify(ingevuldeVragenlijstRepoMock, times(1)).addAntwoord(any());
    }

}