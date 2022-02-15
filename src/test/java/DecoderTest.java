import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DecoderTest {

    @org.junit.Test
    public void decode() {
        Decoded decoded = Decoder.decode(-32768);
        assertTrue(decoded.removal_detection);
        decoded.removal_detection = false;
        assertAllFalse(decoded);

        decoded = Decoder.decode(0);
        assertAllFalse(decoded);

        decoded = Decoder.decode(1);
        assertTrue(decoded.test_alarm_executed);
        decoded.test_alarm_executed = false;
        assertAllFalse(decoded);

        decoded = Decoder.decode(2);
        assertTrue(decoded.smoke_alarm);
        decoded.smoke_alarm = false;
        assertAllFalse(decoded);

        decoded = Decoder.decode(3);
        assertTrue(decoded.smoke_alarm);
        decoded.smoke_alarm = false;
        assertTrue(decoded.test_alarm_executed);
        decoded.test_alarm_executed = false;
        assertAllFalse(decoded);
    }

    private void assertAllFalse(Decoded d) {
        assertFalse(d.removal_detection);
        assertFalse(d.battery_end_of_life);
        assertFalse(d.smoke_chamber_pollution_pre_warning);
        assertFalse(d.smoke_chamber_pollution_warning);
        assertFalse(d.test_button_failure);
        assertFalse(d.acoustic_alarm_failure);
        assertFalse(d.removal_detection);
        assertFalse(d.test_alarm_executed);
        assertFalse(d.smoke_alarm);
        assertFalse(d.obstruction_detection);
        assertFalse(d.surrounding_area_monitoring);
        assertFalse(d.led_failure);
    }
}
