/*
 * Copyright 2018 InfAI (CC SES)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import org.infai.ses.senergy.exceptions.NoValueException;
import org.infai.ses.senergy.operators.BaseOperator;
import org.infai.ses.senergy.operators.Message;

public class FlagsEzProtect extends BaseOperator {
    public FlagsEzProtect() {
        super();
    }

    @Override
    public void run(Message message) {
        Integer flag;
        try {
            flag = message.getFlexInput("flag").getValue(Integer.class);
        } catch (NoValueException e) {
            System.out.println(e.getMessage());
            System.out.println(message.getMessage().getMessages());
            return;
        }

        Decoded decoded = Decoder.decode(flag);


        message.output("battery_end_of_life", decoded.battery_end_of_life);
        message.output("smoke_chamber_pollution_pre_warning", decoded.smoke_chamber_pollution_pre_warning);
        message.output("smoke_chamber_pollution_warning", decoded.smoke_chamber_pollution_warning);
        message.output("test_button_failure", decoded.test_button_failure);
        message.output("acoustic_alarm_failure", decoded.acoustic_alarm_failure);
        message.output("removal_detection", decoded.removal_detection);
        message.output("test_alarm_executed", decoded.test_alarm_executed);
        message.output("smoke_alarm", decoded.smoke_alarm);
        message.output("obstruction_detection", decoded.obstruction_detection);
        message.output("surrounding_area_monitoring", decoded.surrounding_area_monitoring);
        message.output("led_failure", decoded.led_failure);
    }

    @Override
    public Message configMessage(Message message) {
        message.addFlexInput("flag");
        return message;
    }
}
