package nl.YEA.view;

import nl.YEA.Singleton;
import nl.YEA.controller.OpenAntwoordController;
import nl.YEA.controller.OpenVraagController;
import nl.YEA.model.OpenVraag;
import nl.YEA.model.Vraag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OpenVraagInvulSchermTest {
    @Mock
    private InOutputUtil inOutputUtilMock;
    @Mock
    private OpenAntwoordController openAntwoordControllerMock;
    @Mock
    private OpenVraagController openVraagControllerMock;
    @Mock
    private Singleton singletonMock;
    @Mock
    private Vraag vraagMock;


    private OpenVraagInvulScherm sut = new OpenVraagInvulScherm(1);

    @BeforeEach
    void beforeEach() {
        InOutputUtil.setInOutputController(inOutputUtilMock);
        Singleton.setSingletonInstance(singletonMock);
    }

    @Test
    void openAntwoordInvulSchermSucessvolOpslaan() {
        String test = "Test";
        int vNr = 1;
        when(inOutputUtilMock.getNextLine()).thenReturn("Abc");
        when(singletonMock.getOpenAntwoordController()).thenReturn(openAntwoordControllerMock);
        when(singletonMock.getOpenvraagController()).thenReturn(openVraagControllerMock);
        when(openVraagControllerMock.getVraagBeschrijving(vNr)).thenReturn(test);
        when(openVraagControllerMock.getVraag(vNr)).thenReturn(new OpenVraag(test, 200));
        when(openVraagControllerMock.getmaxAantalTekens(vNr)).thenReturn(300L);
        doNothing().when(openAntwoordControllerMock).addAntwoord(0 ,"Abc");
        sut.show();
        verify(openAntwoordControllerMock).addAntwoord(0,"Abc");
    }
}