package storageapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import storageapp.service.PhotoService;

@CrossOrigin
@Controller
public class FrontEndController {

    private PhotoService photoService;

    public FrontEndController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/gallery")
    public String userGallery(ModelMap map) {
        map.put("files", photoService.getPhotos());
        return "gallery";
    }

}