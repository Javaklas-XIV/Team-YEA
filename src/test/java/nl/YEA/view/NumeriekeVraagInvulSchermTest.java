package nl.YEA.view;

import nl.YEA.Singleton;
import nl.YEA.controller.NumeriekAntwoordController;
import nl.YEA.controller.NumeriekeVraagController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NumeriekeVraagInvulSchermTest {

    @Mock
    private InOutputUtil inOutputUtilMock;
    @Mock
    private Singleton singletonMock;
    @Mock
    private NumeriekAntwoordController naControllerMock;
    @Mock
    private NumeriekeVraagController nvControllerMock;
    @InjectMocks
    private NumeriekeVraagInvulScherm sut = new NumeriekeVraagInvulScherm(1);

    @BeforeEach
    void setUp() {
        InOutputUtil.setInOutputController(inOutputUtilMock);
        Singleton.setSingletonInstance(singletonMock);
    }

    @Test
    void geldigAntwoordIsAdded() {
        when(singletonMock.getNumeriekeVraagController()).thenReturn(nvControllerMock);
        when(singletonMock.getNumeriekAntwoordController()).thenReturn(naControllerMock);
        when(nvControllerMock.getMinimum(1)).thenReturn(1);
        when(nvControllerMock.getMaximum(1)).thenReturn(5);
        doNothing().when(inOutputUtilMock).printNl(any());
        when(inOutputUtilMock.getNextLine()).thenReturn("x", "0", "2");

        sut.show();

        verify(inOutputUtilMock).printNl("Geen geldige input, probeer opnieuw:");
        verify(inOutputUtilMock).printNl("Ongeldig getal, probeer opnieuw:");
        verify(naControllerMock).addAntwoord(1, 2);
    }
}