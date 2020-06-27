import com.tensquare.gathering.GatheringApplication;
import com.tensquare.gathering.mapper.GatheringMapper;
import com.tensquare.gathering.pojo.Gathering;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tyler.chen
 * @version 1.0 2020/6/24
 * @date 2020/6/24 0:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = GatheringApplication.class)
public class TestDemo {

   @Autowired
   private GatheringMapper gatheringMapper;

   @Test
   public void test01() {
      Gathering gathering = new Gathering ();
      gathering.setName ( "aaaa" );
      gathering.setId ( "1" );
      Gathering gs = gatheringMapper.getGathering ( gathering );
      System.out.println ( gs );
   }

   @Test
   public void test02() {

      List<Gathering> gatheringList = gatheringMapper.getGatheringList ();
      for (Gathering gathering : gatheringList) {
         System.out.println ( gathering );
      }
   }

   @Test
   public void test03() {
      List<Gathering> gatheringList = new ArrayList<Gathering> ();
      Gathering ge = new Gathering ();
      ge.setName ( "aaaa" );
      ge.setState ( "2" );
      Gathering ge1 = new Gathering ();
      ge1.setName ( "111" );
      gatheringList.add ( ge );
      gatheringList.add ( ge1 );
      for (Gathering s : gatheringList) {
         List<Gathering> s1 = gatheringMapper.getByName ( s );
         for (Gathering s2 : s1) {
            System.out.println ( s2 );
            System.out.println ("============>>getId"+s2.getId ());
            gatheringMapper.updateGathering ( ge1,s2.getId ());
         }
      }

   }
}
