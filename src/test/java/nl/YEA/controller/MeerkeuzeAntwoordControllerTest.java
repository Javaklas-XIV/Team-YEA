package nl.YEA.controller;

import nl.YEA.Singleton;
import nl.YEA.repos.IngevuldeVragenlijstRepo;
import nl.YEA.view.InOutputUtil;
import nl.YEA.view.MeerkeuzeVraagInvulScherm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class MeerkeuzeAntwoordControllerTest {
    @Mock
    private Singleton singletonMock;
    @Mock
    private IngevuldeVragenlijstRepo ingevuldeVragenlijstRepoMock;
    @Mock
    private MeerkeuzeVraagController meerkeuzeVraagControllerMock;
    private MeerkeuzeAntwoordController sut = new MeerkeuzeAntwoordController();

    @BeforeEach
    void beforeEach() {
        Singleton.setSingletonInstance(singletonMock);
        when(singletonMock.getMeerkeuzeVraagController()).thenReturn(meerkeuzeVraagControllerMock);
        when(singletonMock.getRepo()).thenReturn(ingevuldeVragenlijstRepoMock);
    }

    @Test
    void addAntwoordHappyFlow(){
        when(meerkeuzeVraagControllerMock.getMinKeuzes(1)).thenReturn(1);
        when(meerkeuzeVraagControllerMock.getMaxKeuzes(1)).thenReturn(1);
        when(meerkeuzeVraagControllerMock.getMogenlijkeAntwoorden(1)).thenReturn(List.of("ja","nee"));
        doNothing().when(ingevuldeVragenlijstRepoMock).addAntwoord(any());
        sut.addToList(1,new int[]{0});
        verify(ingevuldeVragenlijstRepoMock).addAntwoord(any());
    }


}