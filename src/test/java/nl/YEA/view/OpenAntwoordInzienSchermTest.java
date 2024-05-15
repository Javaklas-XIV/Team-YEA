package nl.YEA.view;

import jakarta.persistence.EntityManager;
import nl.YEA.Singleton;
import nl.YEA.controller.OpenVraagController;
import nl.YEA.controller.OpenAntwoordController;
import nl.YEA.model.Antwoord;
import nl.YEA.model.IngevuldeVragenlijst;
import nl.YEA.model.OpenAntwoord;
import nl.YEA.model.Vraag;
import nl.YEA.repos.IngevuldeVragenlijstRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OpenAntwoordInzienSchermTest {
    @Mock
    private InOutputUtil inOutputUtilMock;
    @Mock
    private OpenAntwoordController openAntwoordControllerMock;

    @Mock
    private IngevuldeVragenlijstRepo ingevuldeVragenlijstRepoMock;
    @Mock
    private OpenVraagController openVraagControllerMock;
    @Mock
    private Singleton singletonMock;
    @Mock
    private Antwoord antwoordMock;
    @Mock
    private OpenAntwoord openAntwoordMock;
    @Mock
    private IngevuldeVragenlijst ingevuldeVragenlijstMock;

    private OpenAntwoordInzienScherm sut = new OpenAntwoordInzienScherm(0);

    @BeforeEach
    void beforeEach() {
        InOutputUtil.setInOutputController(inOutputUtilMock);
        Singleton.setSingletonInstance(singletonMock);
    }

    @Test
    public void ietsWordtGeprint(){
        when(singletonMock.getOpenvraagController()).thenReturn(openVraagControllerMock);
        when(singletonMock.getOpenAntwoordController()).thenReturn(openAntwoordControllerMock);
        when(openAntwoordControllerMock.getAntwoord(0)).thenReturn(openAntwoordMock);
        when(openVraagControllerMock.getVraagBeschrijving(0)).thenReturn("TestVraag");
        when(openAntwoordMock.getAntwoord()).thenReturn("TestAntwoord");
        doNothing().when(inOutputUtilMock).printNl(any());
        sut.setHeeftAntwoord(true);
        sut.show();
        verify(inOutputUtilMock).printNl("TestVraag");
        verify(inOutputUtilMock).printNl("TestAntwoord");
    }
}