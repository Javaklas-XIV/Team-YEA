package nl.YEA.controller;
import nl.YEA.model.OpenVraag;
import nl.YEA.model.Vraag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
