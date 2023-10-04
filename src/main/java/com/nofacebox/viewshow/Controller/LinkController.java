package com.nofacebox.viewshow.Controller;

import com.nofacebox.viewshow.Entity.Link;
import com.nofacebox.viewshow.Entity.LinkPk;
import com.nofacebox.viewshow.Entity.Movie;
import com.nofacebox.viewshow.Model.AdateDto;
import com.nofacebox.viewshow.Model.LinkDto;
import com.nofacebox.viewshow.Model.ResponseVo;
import com.nofacebox.viewshow.Servic.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LinkController {
    @Autowired
    LinkService linkService;


    @GetMapping("/link/theater/{tid}")
    public ResponseEntity<List<Movie>> searchMoviesByTheater(@PathVariable Long tid){
        return ResponseEntity.ok(linkService.findAllMoviesByTheater(tid));
    }
    @GetMapping("/link/theater/{tid}/movie/{mid}")
    public ResponseEntity<List<AdateDto>> searchDatesByTheaterMovie(@PathVariable Long tid, @PathVariable Long mid){
        return ResponseEntity.ok(linkService.findAllDatesByTheaterMovie(tid,mid));
    }
//    @PostMapping(value="/link",produces = "application/json")
//    public ResponseEntity <LinkPk> save (@RequestBody LinkPk saveItem) throws Exception {
//        Assert.notNull(saveItem,"This entity can not be null");
//        Assert.isNull(linkService.getLinkId(saveItem),"ready to insert");
//        return ResponseEntity.ok(linkService.saveLink(saveItem));
//    }
    @PostMapping(value="/link",produces = "application/json")
    public ResponseEntity <Link> save (@RequestBody Link saveItem) throws Exception {
        Assert.notNull(saveItem,"This entity can not be null");
        Assert.isNull(linkService.getLinkId(saveItem),"ready to insert");
        return ResponseEntity.ok(linkService.saveLink(saveItem));
    }

//    @PutMapping(value= "/link",produces = "application/json")
//    public ResponseEntity<LinkPk> upateLinkPk(@RequestBody LinkPk modify) throws Exception {
//        Assert.notNull(modify,"This entity can not be null");
//        return ResponseEntity.ok(linkService.modifyLinkPk(modify));
//    }
    @PutMapping(value= "/link",produces = "application/json")
    public ResponseEntity<Link> upateLink(@RequestBody Link modify) throws Exception {
//        System.out.println(modify.toString());
        Assert.notNull(modify,"This entity can not be null");
        return ResponseEntity.ok(linkService.modifyLink(modify));
    }
    @DeleteMapping("/link/{lid}")
    public ResponseEntity<ResponseVo> deleteLink(@PathVariable Long lid){
        return ResponseEntity.ok(linkService.deleteLink(lid));
    }
    //待確認功能
    @GetMapping("/link/{lid}")
    public ResponseEntity<LinkPk> getAllLink(@PathVariable Long lid){
        return ResponseEntity.ok(linkService.getLink(lid));
    }
    //單間戲院可以同時看到電影和日期清單
    @GetMapping("/links/{tid}")
    public ResponseEntity<List<LinkDto>> getLinksByTheater(@PathVariable Long tid){
        return ResponseEntity.ok(linkService.findLinkDTOByTheater(tid));
    }



//linkpk版本
//    @PostMapping("/link/findlinkid")
//    public ResponseEntity<Long> getLinkId(@RequestBody LinkPk item) throws Exception {
//        return ResponseEntity.ok(linkService.getLinkId(item));
//    }

    @PostMapping("/link/findlinkid")
    public ResponseEntity<Long> getLinkId(@RequestBody Link item) throws Exception {

        return ResponseEntity.ok(linkService.getLinkId(item));
    }


}
