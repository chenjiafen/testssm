import com.tensquare.gathering.GatheringApplication;
import com.tensquare.gathering.dao.GatheringDao;
import com.tensquare.gathering.entity.Gathering;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
   private GatheringDao gatheringDao;

   @Test
   public void test01() {
      Gathering gathering = new Gathering ();
      gathering.setName ( "aaaa" );
      gathering.setId ( "1" );
      Gathering gs = gatheringDao.getGathering ( gathering );
      System.out.println ( gs );
   }

   @Test
   public void test02() {

      List<Gathering> gatheringList = gatheringDao.getGatheringList ();
      for (Gathering gathering : gatheringList) {
         System.out.println ( gathering );
      }
   }

   /**
    * 无注解的的更新
    */
   @Test
   public void test03() {
      List<Gathering> gatheringList = new ArrayList<Gathering> ();
      Gathering ge = new Gathering ();
      ge.setImage ( "aaaa" );
      ge.setId ( "1" );
      Gathering ge1 = new Gathering ();
      ge1.setImage ( "111" );
      ge1.setId ( "94377594140" );
      gatheringList.add ( ge );
      gatheringList.add ( ge1 );
      for (Gathering s : gatheringList) {
         gatheringDao.updateGathering ( s );


      }
   }

   /**
    * 注解更新
    */
   @Test
   public void test04(){
      Boolean flag=false;
      List<Gathering> gatheringList = new ArrayList<Gathering> ();
      Gathering ge = new Gathering ();
      ge.setImage ( "aaaa/bbb" );
      ge.setId ( "1" );
      Gathering ge1 = new Gathering ();
      ge1.setImage ( "111/ccc" );
      ge1.setId ( "94377594140" );
      gatheringList.add ( ge );
      gatheringList.add ( ge1 );
      for (Gathering s : gatheringList) {
         flag= gatheringDao.updategathering( s );


      }
      System.out.println ("数据是否更新成功"+flag);
   }

   @Test
   public void forechUpdate(){
      List<Gathering> gatheringList = new ArrayList<Gathering> ();
      Gathering ge = new Gathering ();
      ge.setImage ( "aaaa/bbb/fff" );
      ge.setId ( "1" );
      Gathering ge1 = new Gathering ();
      ge1.setImage ( "111/ccc/ddd" );
      ge1.setId ( "94377594140" );
      gatheringList.add ( ge );
      gatheringList.add ( ge1 );
      gatheringDao.updatega ( gatheringList );

   }

   @Test
   public void test001() {
      String pass = "admin";

      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
      final String passHash = encoder.encode(pass);
      System.out.println(passHash);

      final boolean matches = encoder.matches(pass, passHash);
      System.out.println(matches);
   }
}
