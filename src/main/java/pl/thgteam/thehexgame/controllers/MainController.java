package pl.thgteam.thehexgame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.thgteam.thehexgame.battlefield.FirstBattlefield;
import pl.thgteam.thehexgame.battlefield.TestBattlefield;
import pl.thgteam.thehexgame.hex.Cord;
import pl.thgteam.thehexgame.hex.Polygon;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    FirstBattlefield firstBattlefield;

    @GetMapping
    public String toMain(Model model) {
        model.addAttribute("firstBattlefield", firstBattlefield.getRawMap().getBattlefield());

        model.addAttribute("one_polygon", new Polygon(
                new Cord(100,130),
                new Cord( 150,130),
                new Cord( 175,173),
                new Cord( 150,216),
                new Cord( 100,216),
                new Cord( 75,173)
                ).createString()
        );

        return "index";
    }

}
