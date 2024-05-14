package nl.YEA.view;

import nl.YEA.Singleton;
import nl.YEA.controller.MeerkeuzeAntwoordController;
import nl.YEA.controller.MeerkeuzeVraagController;
import nl.YEA.controller.VraagController;
import nl.YEA.repos.IngevuldeVragenlijstRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MeerkeuzeVraagInvulSchermTest {
    @Mock
    private InOutputUtil inOutputUtilMock;
    @Mock
    private Singleton singletonMock;
    @Mock
    private MeerkeuzeVraagController meerkeuzeVraagControllerMock;
    @Mock
    private MeerkeuzeAntwoordController meerkeuzeAntwoordControllerMock;
    @Mock
    private IngevuldeVragenlijstRepo ingevuldeVragenlijstRepoMock;
    private MeerkeuzeVraagInvulScherm sut = new MeerkeuzeVraagInvulScherm(1);

    @BeforeEach
    void beforeEach() {
        InOutputUtil.setInOutputController(inOutputUtilMock);
        Singleton.setSingletonInstance(singletonMock);
    }

    @Test
    void JaNeeVraagHappyFlow(){
        when(singletonMock.getMeerkeuzeVraagController()).thenReturn(meerkeuzeVraagControllerMock);
        when(singletonMock.getMeerkeuzeAntwoordController()).thenReturn(meerkeuzeAntwoordControllerMock);
        when(meerkeuzeVraagControllerMock.getMaxKeuzes(1)).thenReturn(1);
        when(meerkeuzeVraagControllerMock.getMinKeuzes(1)).thenReturn(1);
        when(meerkeuzeVraagControllerMock.getVraagBeschrijving(1)).thenReturn("");
        when(meerkeuzeVraagControllerMock.getMogenlijkeAntwoorden(1)).thenReturn(List.of("ja","nee"));
        when(inOutputUtilMock.getNextLine()).thenReturn("1");
        doNothing().when(meerkeuzeAntwoordControllerMock).addToList(1, new int[]{0});
        doNothing().when(inOutputUtilMock).printNl(any());
        doNothing().when(inOutputUtilMock).print(any());
        sut.show();
        verify(meerkeuzeAntwoordControllerMock).addToList(1, new int[]{0});
    }
}