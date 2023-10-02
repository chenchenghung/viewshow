package com.nofacebox.viewshow.Servic;

import com.nofacebox.viewshow.Entity.Link;
import com.nofacebox.viewshow.Entity.LinkPk;
import com.nofacebox.viewshow.Entity.Movie;
import com.nofacebox.viewshow.Model.AdateDto;
import com.nofacebox.viewshow.Model.LinkDto;
import com.nofacebox.viewshow.Model.ResponseVo;
import com.nofacebox.viewshow.Repository.LinkPkRepositary;
import com.nofacebox.viewshow.Repository.LinkRepositary;
import com.nofacebox.viewshow.Servic.Interface.ILinkService;
import com.nofacebox.viewshow.Utils.NativeQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
@Service
public class LinkService implements ILinkService {
    @Autowired
    LinkRepositary linkRepositary;
    @Autowired
    LinkPkRepositary linkPkRepositary;

    //待確認實際功能
    @Override
    public LinkPk getLink(Long id) {
        return linkPkRepositary.findById(id).orElse(null);
    }

    @Override
    public LinkPk saveLink(LinkPk saveItem) throws Exception {
        if(this.getLinkId(saveItem)==0){
            return linkPkRepositary.save(saveItem);
        }else {return  null;}
    }

    @Override
    public LinkPk modifyLinkPk(LinkPk modify) throws Exception {
        LinkPk l = linkPkRepositary.findById(modify.getLinkid()).orElseThrow(()->new Exception("not found"));
        l.setAid(modify.getAid());
        l.setMid(modify.getMid());
        l.setTid(modify.getTid());
        return linkPkRepositary.save(l);
    }

    @Override
    public ResponseVo deleteLink(long id) {
        ResponseVo res = new ResponseVo();
        if(linkRepositary.findById(id).isPresent()){
            linkRepositary.deleteById(id);
            res.setMessage("OK");
        }else{
            res.setMessage("FAILED");
        }
        return res;
    }

    @Override
    public Long getLinkId(LinkPk pk) throws Exception {
        Example<LinkPk> example = Example.of(pk);
        Optional<LinkPk> ex = linkPkRepositary.findOne(example);
        LinkPk data = ex.orElseThrow(() -> new Exception("no data"));
        if(ex.isEmpty()){
            return null;
        }
        return data.getLinkid() ;
    }

    @Override
    public List<AdateDto> findAllDatesByTheaterMovie(Long tid, Long mid) {
        List<Map<String, Object>> allDates = linkRepositary.getAllDatesByTheaterMovie(tid, mid);
        List<AdateDto> data = NativeQueryConverter.convert(allDates, AdateDto.class);

        return data;
    }

    @Override
    public List<Movie> findAllMoviesByTheater(Long tid) {
        List<Map<String, Object>> allMovies = linkRepositary.getAllMoviesByTheater(tid);
        List<Movie> data = NativeQueryConverter.convert(allMovies, Movie.class);
        return data;
    }

    @Override
    public List<LinkDto> findLinkDTOByTheater(Long tid) {
        List<Map<String, Object>> dtos = linkRepositary.getLinkDTOByTheater(tid);
        List<LinkDto> data = NativeQueryConverter.convert(dtos, LinkDto.class);
        return data;

    }
}
