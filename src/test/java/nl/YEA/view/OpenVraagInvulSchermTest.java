package nl.YEA.view;

import nl.YEA.controller.OpenAntwoordController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OpenVraagInvulSchermTest {
    @Mock
    private InOutputUtil inOutputUtilMock;
    @Mock
    private OpenAntwoordController openAntwoordControllerMock;
    @InjectMocks
    private OpenVraagInvulScherm sut = new OpenVraagInvulScherm(1);

    @BeforeEach
    void beforeEach() {
        InOutputUtil.setInOutputController(inOutputUtilMock);
    }

    @Test
    void openAntwoordInvulSchermSucessvolOpslaan() {
        when(inOutputUtilMock.getNextLine()).thenReturn("Abc");
        openAntwoordControllerMock.addAntwoord(anyInt(), anyString());
        sut.show();
        verify(inOutputUtilMock).print("""

                Vraag succesvol opgeslagen

                """);
    }
}