//package pl.thgteam.thehexgame.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import pl.thgteam.thehexgame.battlefield.FirstBattlefield;
//import pl.thgteam.thehexgame.hex.Location;
//import pl.thgteam.thehexgame.xother.Polygon;
//
//@Controller
//@RequestMapping("/")
//public class MainController {
//
//    @Autowired
//    FirstBattlefield firstBattlefield;
//
//    @GetMapping
//    public String toMain(Model model) {
//        model.addAttribute("firstBattlefield", firstBattlefield.getRawMap().getBattlefield());
//
//        model.addAttribute("one_polygon", new Polygon(
//                new Location(100,130),
//                new Location( 150,130),
//                new Location( 175,173),
//                new Location( 150,216),
//                new Location( 100,216),
//                new Location( 75,173)
//                ).createString()
//        );
//
//        return "index";
//    }
//
//}
