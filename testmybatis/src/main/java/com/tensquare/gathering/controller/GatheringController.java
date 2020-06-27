package com.tensquare.gathering.controller;

import com.tensquare.gathering.mapper.GatheringMapper;
import com.tensquare.gathering.pojo.Gathering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tyler.chen
 * @version 1.0 2020/6/24
 * @date 2020/6/24 0:25
 */
@RestController
public class GatheringController {

   @Autowired
   private GatheringMapper gatheringMapper;


   @RequestMapping("/gathering/list")
   public List<Gathering> getgatheringList() {
      return gatheringMapper.getGatheringList ();
   }

   @RequestMapping("/gathering/update")
   public List<Gathering> getgatheringList(@RequestBody List<Gathering> ge) {
      for (Gathering gathering : ge) {
         if (!StringUtils.isEmpty ( gathering.getName () )) {
            Gathering gather = new Gathering ();
            gather.setName ( gathering.getName () );
            List<Gathering> tt = gatheringMapper.getByName ( gather );

         }
      }
      return gatheringMapper.getGatheringList ();
   }
}
