package nl.YEA.controller;

import nl.YEA.Singleton;
import nl.YEA.model.FormulierOnderdeel;
import nl.YEA.model.OpenVraag;
import nl.YEA.model.Vraag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VraagControllerTest {
    @Mock
    private Singleton singletonMock;

    private VraagController sut;
    @BeforeEach
    void beforeEach() {
        Singleton.setSingletonInstance(singletonMock);
        sut = new VraagController();
    }

    @Test
    public void VraagAddedCanBeFound(){
        Vraag vraag = new OpenVraag("kaas");
        vraag.setVraagnummer(1);
        when(singletonMock.getVragenlijst()).thenReturn(List.of(vraag));
        assertEquals(vraag, sut.getVraag(1));
    }

    @Test
    public void VraagAddedInOnderdeelCanBeFound(){
        Vraag vraag = new OpenVraag("kaas");
        FormulierOnderdeel onderdeel = new FormulierOnderdeel("kaas");
        onderdeel.getOnderdelen().add(vraag);
        vraag.setVraagnummer(1);
        when(singletonMock.getVragenlijst()).thenReturn(List.of(onderdeel));
        sut = new VraagController();
        assertEquals(vraag, sut.getVraag(1));
    }
    @Test
    public void VraagAddedInLinkedVraagCanBeFound(){
        Vraag vraag = new OpenVraag("kaas");
        vraag.setVraagnummer(1);
        Vraag comVraag = new OpenVraag("kaas");
        comVraag.setAnyAwnserLink(vraag);
        when(singletonMock.getVragenlijst()).thenReturn(List.of(comVraag));
        sut = new VraagController();
        assertEquals(vraag, sut.getVraag(1));
    }

}