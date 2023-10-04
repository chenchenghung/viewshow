package com.nofacebox.viewshow.Controller;


import com.nofacebox.viewshow.Entity.LinkPk;
import com.nofacebox.viewshow.Entity.Session;
import com.nofacebox.viewshow.Model.ResponseVo;
import com.nofacebox.viewshow.Model.SessionDto;
import com.nofacebox.viewshow.Servic.LinkService;
import com.nofacebox.viewshow.Servic.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SessionController {

    @Autowired
    SessionService sessionService;

    @Autowired
    LinkService linkService;

    @GetMapping("/session/{sid}")
    public ResponseEntity<Session> searchSession(@PathVariable Long sid) throws Exception {
        return ResponseEntity.ok(sessionService.getSession(sid));
    }

    @GetMapping("/session/{linkid}")
    public ResponseEntity<List<SessionDto>> searchSessionsByLinkid(@PathVariable Long linkid) throws Exception {
        return ResponseEntity.ok(sessionService.findSessionsByLinkid(linkid));
    }

    @PostMapping(value="/session",produces = "application/json")
    public ResponseEntity <Session> save (@RequestBody Session saveItem) throws Exception {
        Assert.notNull(saveItem,"This entity can not be null");
        LinkPk l = linkService.getLink(saveItem.getLinkPk().getLinkid());
        saveItem.setLinkPk(l);
        return ResponseEntity.ok(sessionService.saveSession(saveItem));
    }

    @PutMapping(value= "/session",produces = "application/json")
    public ResponseEntity<Session> upateSession(@RequestBody Session modify) throws Exception {
        Assert.notNull(modify,"This entity can not be null");
        LinkPk l = linkService.getLink(modify.getLinkPk().getLinkid());
        return ResponseEntity.ok(sessionService.modifySession(modify,l));
    }
    @DeleteMapping("/session/{sid}")
    public ResponseEntity<ResponseVo> deleteSession(@PathVariable Long sid){
        return ResponseEntity.ok(sessionService.deleteSession(sid));
    }
//    @PatchMapping("/session/{seat}/{userid}/{sid}")
//    public ResponseEntity<ResponseVo> upateSessionPartially(@PathVariable String seat,@PathVariable String userid,@PathVariable Long sid) throws Exception {
//        Assert.notNull(sessionService.getSession(sid),"This entity can not be null");
//        return ResponseEntity.ok(sessionService.modifySessionSeat(seat,userid,sid));
//    }

}
