package nl.YEA.view;

import nl.YEA.controller.NumeriekAntwoordController;
import nl.YEA.controller.NumeriekeVraagController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class NumeriekeVraagInvulSchermTest {

    @Mock
    private NumeriekeVraagController nvControllerMock;
    @Mock
    private NumeriekAntwoordController naControllerMock;
    @Mock
    private InOutputUtil inOutputUtilMock;
    @InjectMocks
    private NumeriekeVraagInvulScherm sut;

    @BeforeEach
    void setUp() {
        InOutputUtil.setInOutputController(inOutputUtilMock);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void geldigAntwoordIsAdded() {

    }
}