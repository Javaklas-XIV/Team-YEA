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
    private InOutputUtil inOutputUtilMock;
    @Mock private OverzichtScherm overzichtSchermMock;
    @Mock private InvulScherm invulSchermMock;
    @InjectMocks
    private HoofdScherm sut;

    @BeforeEach
    void beforeEach(){
        InOutputUtil.setInOutputController(inOutputUtilMock);
    }
    @Test
    void hoofdSchermIsClosed() {
        when(inOutputUtilMock.getNextLine()).thenReturn("x");
        doNothing().when(inOutputUtilMock).printNl(any());
        sut.show();
        verify(inOutputUtilMock).printNl("Afsluiten");
    }

    @Test
    void overzichtSchermIsChosen() {
        when(inOutputUtilMock.getNextLine()).thenReturn("2","x");
        when(inOutputUtilMock.getOverzichtScherm()).thenReturn(overzichtSchermMock);
        doNothing().when(overzichtSchermMock).show();
        doNothing().when(inOutputUtilMock).printNl(any());
        doNothing().when(inOutputUtilMock).print(any());
        sut.show();
        verify(inOutputUtilMock).printNl("Afsluiten");
        verify(inOutputUtilMock).getOverzichtScherm();
        verify(overzichtSchermMock).show();
    }
    @Test
    void invulSchermIsChosen() {
        when(inOutputUtilMock.getNextLine()).thenReturn("1","x");
        when(inOutputUtilMock.getInvulScherm()).thenReturn(invulSchermMock);
        doNothing().when(invulSchermMock).show();
        doNothing().when(inOutputUtilMock).printNl(any());
        doNothing().when(inOutputUtilMock).print(any());
        sut.show();
        verify(inOutputUtilMock).printNl("Afsluiten");
        verify(inOutputUtilMock).getInvulScherm();
        verify(invulSchermMock).show();
    }
}