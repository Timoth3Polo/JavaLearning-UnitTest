package learning.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorMockTest {

    @Mock
    Calculator calculator;

    @Test
    public void calculate_shouldUseCalculator_forAddition() {
        // GIVEN
        when(calculator.addTwoInteger(1, 2)).thenReturn(4);

        // WHEN
        final int result = calculator.addTwoInteger(1,2);

        // THEN
        verify(calculator).addTwoInteger(1, 2);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void calculate_shouldUseCalculator_forAddition_WithGenerateEntries() {
        // GIVEN
        when(calculator.addTwoInteger(any(Integer.class), any(Integer.class))).thenReturn(4);

        // WHEN
        final int result = calculator.addTwoInteger(1,2);

        // THEN
        verify(calculator).addTwoInteger(any(Integer.class), any(Integer.class));
        verify(calculator, never()).multiplyTwoInteger(any(Integer.class), any(Integer.class));

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void calculate_shouldThrowIllegalArgumentException_forADivisionBy0() {
        // GIVEN
        when(calculator.multiplyTwoInteger(1, 0)).thenThrow(new IllegalArgumentException());

        // WHEN
        assertThrows(IllegalArgumentException.class, () -> calculator.multiplyTwoInteger(1, 0));

        // THEN
        verify(calculator, times(1)).multiplyTwoInteger(1, 0);
    }
}
