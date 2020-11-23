package com.example.kimovements.model.joystick;

import com.example.kimovements.model.HitType;
import com.example.kimovements.model.Intensity;
import com.example.kimovements.model.button.arcade.ArcadeButton;
import com.example.kimovements.model.button.snes.SNESButton;
import com.example.kimovements.model.button.snes.SNESButtonLetter;

import java.util.ArrayList;
import java.util.List;

public class JoystickBuilder {
    public static List<Joystick> getJoysticks(){
        List<Joystick> joysticks = new ArrayList<>();

        Joystick snesJoystick = create(JoystickType.SNES);
        Joystick arcadeJoystick = create(JoystickType.ARCADE);

        joysticks.add(snesJoystick);
        joysticks.add(arcadeJoystick);

        return joysticks;
    }

    private static Joystick create(JoystickType joystickType){
        Joystick joystick;

        switch (joystickType){
            case SNES:
                joystick = new SNESJoystick();

                return joystick
                    .addButton(new SNESButton(SNESButtonLetter.L, Intensity.QUICK, HitType.PUNCH))
                    .addButton(new SNESButton(SNESButtonLetter.Y, Intensity.MEDIUM, HitType.PUNCH))
                    .addButton(new SNESButton(SNESButtonLetter.X, Intensity.FIERCE, HitType.PUNCH))
                    .addButton(new SNESButton(SNESButtonLetter.R, Intensity.QUICK, HitType.KICK))
                    .addButton(new SNESButton(SNESButtonLetter.B, Intensity.MEDIUM, HitType.KICK))
                    .addButton(new SNESButton(SNESButtonLetter.A, Intensity.FIERCE, HitType.KICK));
            case ARCADE:
                joystick =  new ArcadeJoystick();

                return joystick
                    .addButton(new ArcadeButton(Intensity.QUICK, HitType.PUNCH))
                    .addButton(new ArcadeButton(Intensity.MEDIUM, HitType.PUNCH))
                    .addButton(new ArcadeButton(Intensity.FIERCE, HitType.PUNCH))
                    .addButton(new ArcadeButton(Intensity.QUICK, HitType.KICK))
                    .addButton(new ArcadeButton(Intensity.MEDIUM, HitType.KICK))
                    .addButton(new ArcadeButton(Intensity.FIERCE, HitType.KICK));
            default:
                return null;
        }
    }
}
