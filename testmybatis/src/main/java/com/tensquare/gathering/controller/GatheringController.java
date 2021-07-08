package com.tensquare.gathering.controller;

import com.tensquare.gathering.entity.Gathering;
import com.tensquare.gathering.service.GatheringService;
import com.tensquare.gathering.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author tyler.chen
 * @version 1.0 2020/6/24
 * @date 2020/6/24 0:25
 */
@RestController
@RequestMapping("/gathering")
@Slf4j
public class GatheringController {

    @Autowired
    private GatheringService gatheringService;


    @GetMapping("/list")
    public Result getgatheringList() {
        List<Gathering> gatherings = gatheringService.getgatheringList();
        return new Result(true, 200, "查询成功", gatherings);
    }

    @PostMapping(value = "/gathering")
    public Result findById(@RequestBody Gathering gathering) {
        if (Objects.isNull(gathering.getId()) && Objects.isNull(gathering.getName())) {
            return new Result(false, 201, "查询失败");

        }
        Gathering ga = gatheringService.getGathering(gathering);
        return new Result(true, 200, "查询成功", ga);
    }
    @PostMapping(value = "/findName")
    public  Result findByName(@RequestBody Gathering gathering){
        if(Objects.isNull(gathering.getName())){
            return new Result(false, 201, "查询失败");

        }
        List<Gathering> byName = gatheringService.findByName(gathering);
        return new Result(true, 201, "查询成功",byName);

    }
    @PostMapping(value = "/updateById")
    public Result updateById(@RequestBody Gathering gathering){
        Boolean aBoolean = gatheringService.updateById(gathering);
        return new Result(aBoolean, 201, "查询成功");
    }

//   @RequestMapping("/gathering/update")
//   public List<Gathering> getgatheringList(@RequestBody List<Gathering> ge) {
//      for (Gathering gathering : ge) {
//         if (!StringUtils.isEmpty ( gathering.getName () )) {
//            Gathering gather = new Gathering ();
//            gather.setName ( gathering.getName () );
//            List<Gathering> tt = gatheringMapper.getByName ( gather );
//
//         }
//      }
//      return gatheringMapper.getGatheringList ();
//   }
}
