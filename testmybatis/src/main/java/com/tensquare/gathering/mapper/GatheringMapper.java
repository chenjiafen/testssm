package com.tensquare.gathering.mapper;

import com.tensquare.gathering.pojo.Gathering;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tyler.chen
 * @version 1.0 2020/6/24
 * @date 2020/6/24 0:08
 */
public interface GatheringMapper {
   List<Gathering> getGatheringList();

   //   select * from tb_gathering where id=#{ga.id} and `name`=#{ga.name};
   Gathering getGathering(@Param("ga") Gathering ga);

   List<Gathering> getByName(@Param("ga") Gathering ga);

   /**
    * 把name为a的数据状态更新为2
    */
   void updateGathering(Gathering ga);

   Boolean updategathering(@Param ( "ga" ) Gathering ga);

   void updatega(List<Gathering> ga);
}
