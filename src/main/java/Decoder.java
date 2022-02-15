public class Decoder {
    static Decoded decode(Integer flag) {
        Integer unsigned = Short.toUnsignedInt(flag.shortValue());

        int lower = unsigned & 0b11111111;
        int upper = Integer.valueOf(unsigned >> 8);

        final Decoded decoded = new Decoded();
        decoded.battery_end_of_life = (upper & 0b10) == 2;
        decoded.smoke_chamber_pollution_pre_warning = (upper & 0b1000) == 8;
        decoded.smoke_chamber_pollution_warning = (upper & 0b10000) == 16;
        decoded.test_button_failure = (upper & 0b100000) == 32;
        decoded.acoustic_alarm_failure = (upper & 0b1000000) == 64;;
        decoded.removal_detection = upper >> 7 == 1;
        decoded.test_alarm_executed = (lower & 0b1) == 1;
        decoded.smoke_alarm = (lower & 0b10) == 2;
        decoded.obstruction_detection = (lower & 0b100) ==4;
        decoded.surrounding_area_monitoring = (lower & 0b1000) == 8;
        decoded.led_failure = (lower & 0b10000) == 16;


        return decoded;
    }
}

