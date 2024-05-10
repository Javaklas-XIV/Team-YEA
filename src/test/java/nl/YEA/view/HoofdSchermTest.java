package nl.YEA.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HoofdSchermTest {
    @Mock
    private InOutputController inOutputControllerMock;
    @Mock private OverzichtScherm overzichtSchermMock;
    @Mock private InvulScherm invulSchermMock;
    @InjectMocks
    private HoofdScherm sut;

    @BeforeEach
    void beforeEach(){
        InOutputController.setInOutputController(inOutputControllerMock);
    }
    @Test
    void hoofdSchermIsClosed() {
        when(inOutputControllerMock.getNextLine()).thenReturn("x");
        doNothing().when(inOutputControllerMock).printNl(any());
        sut.show();
        verify(inOutputControllerMock).printNl("afsluiten");
    }

    @Test
    void overzichtSchermIsChosen() {
        when(inOutputControllerMock.getNextLine()).thenReturn("2","x");
        when(inOutputControllerMock.getOverzichtScherm()).thenReturn(overzichtSchermMock);
        doNothing().when(overzichtSchermMock).show();
        doNothing().when(inOutputControllerMock).printNl(any());
        doNothing().when(inOutputControllerMock).print(any());
        sut.show();
        verify(inOutputControllerMock).printNl("afsluiten");
        verify(inOutputControllerMock).getOverzichtScherm();
        verify(overzichtSchermMock).show();
    }
    @Test
    void invulSchermIsChosen() {
        when(inOutputControllerMock.getNextLine()).thenReturn("1","x");
        when(inOutputControllerMock.getInvulScherm()).thenReturn(invulSchermMock);
        doNothing().when(invulSchermMock).show();
        doNothing().when(inOutputControllerMock).printNl(any());
        doNothing().when(inOutputControllerMock).print(any());
        sut.show();
        verify(inOutputControllerMock).printNl("afsluiten");
        verify(inOutputControllerMock).getInvulScherm();
        verify(invulSchermMock).show();
    }
}