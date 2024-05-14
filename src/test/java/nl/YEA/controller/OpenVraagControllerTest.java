package nl.YEA.controller;
import nl.YEA.model.OpenVraag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OpenVraagControllerTest {
    @Mock
    OpenVraag ovMock;

    @InjectMocks
    private OpenVraagController sut;

    @Test
    public void maxAantalTekensTerugKrijgen() {
        int nummer = 1;
        ovMock.setMaxAantalTekens(256);
        ovMock.setVraagnummer(1);
        Assertions.assertEquals(256, sut.getmaxAantalTekens(nummer));
    }
}
